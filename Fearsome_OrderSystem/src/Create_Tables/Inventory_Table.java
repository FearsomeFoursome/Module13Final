/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

/**
 *
 * @author Gregory
 */
public class Inventory_Table {
    
    private static final String INVENTORY_TABLE_NAME = "FEARSOME_INVENTORY";
    private static java.sql.Connection sqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Inventory_Table()
    {
        sqlConn = Connect.MYSQL.getMSQLConn();
    }
    // Drop Table
    
 public static java.util.ArrayList searchbyItemID(int Item_ID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + INVENTORY_TABLE_NAME + " where ItemID like %" + Item_ID + "%;" ;                
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Customer (rs.getInt("CustomerID"), rs.getString("FirstName"), 
                        rs.getString("LastName"), rs.getInt("BillAddress"), rs.getInt("ShipAddress"), 
                        rs.getString("EmailAddress"), rs.getString("PhoneNumber"), rs.getInt("OrderIDs")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Customer Database." + "\nDetaill: " + e);
        }
        return results;
    }



    
}
