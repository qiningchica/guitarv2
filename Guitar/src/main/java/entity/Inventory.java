package entity;

import java.util.List;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import util.guitarjdbc;
import entity.Guitar;

public class Inventory {
  private LinkedList guitars;
  private String sql;
  private String specSql;
  private PreparedStatement pstmt;
  private PreparedStatement sp;
  public Inventory() {
    guitars = new LinkedList();
  }
/**
 * 添加新的吉他
 * @param serialNumber
 * @param price
 * @param builder
 * @param model
 * @param type
 * @param backWood
 * @param topWood
 */
  public void addGuitar(String serialNumber, double price,
          GuitarSpec spec) {
	  	  Guitar guitar = new Guitar(serialNumber, price, spec);
	  	  guitars.add(guitar);
}
  /**
   * 通过编码查询吉他
   * @param serialNumber
   * @return
   */
  public Guitar getGuitar(String serialNumber) {
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar = (Guitar)i.next();
      if (guitar.getSerialNumber().equals(serialNumber)) {
        return guitar;
      }
    }
    return null;
  }
  /**
   * 获取guitar中的所有对象
   * @return
   */
  public List<Guitar> guitarList(){
	  sql="select * from guitar;"; 
	  specSql= "select * from guitarSpec where spec= ";
	  try {
			pstmt =guitarjdbc.getConnection().prepareStatement(sql);      			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				String serialNumber = rs.getString("serialNumber");
				double price = rs.getDouble("price");
		        int id = rs.getInt("spec");
		        sp =guitarjdbc.getConnection().prepareStatement(specSql+id);      			
				ResultSet spec1 = sp.executeQuery();
				while(spec1.next()){
					String  builder = spec1.getString("builder");
					String	model = spec1.getString("model");
					String	type = spec1.getString("type");
					String	backWood = spec1.getString("backWood");
					String	topWood = spec1.getString("topWood");
					int numStrings = spec1.getInt("numStrings");
					GuitarSpec spec=new GuitarSpec(Builder.valueOf(builder.toUpperCase()),
					model,Type.valueOf(type.toUpperCase()),Wood.valueOf(backWood.toUpperCase()),Wood.valueOf(topWood.toUpperCase()),numStrings);
					Guitar guitar=new Guitar(serialNumber,price,spec);
					guitars.add(guitar);			    
				}
				sp.close();
			}
				pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return guitars;
	
}
  public List search(GuitarSpec searchSpec) {
	    List matchingGuitars = new LinkedList();
	    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
	      Guitar guitar = (Guitar)i.next();
	      if (guitar.getSpec().matches(searchSpec))
	        matchingGuitars.add(guitar);
	    }
	    return matchingGuitars;
	  }
}