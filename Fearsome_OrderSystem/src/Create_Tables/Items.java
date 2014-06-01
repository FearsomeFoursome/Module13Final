/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

/**
 *
 * @author Gregory
 */
public class Items {
    
    private static final String ITEMS_TABLE_NAME = "FEARSOME_ITEMS";   
    private static java.sql.Connection sqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Items()
    {
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        /*
        try{      
            createString = "drop table " + ITEMS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        */
        try{
            //Create the Items Table
            createString =
            "create table " + ITEMS_TABLE_NAME + " " + 
            "(OrderItemID integer identity (1,1) NOT NULL, " +
            "OrderID integer NOT NULL, " +
            "ProductID integer NOT NULL, " +
            "Quantaty integer NOT NULL, " +
            "PRIMARY KEY (OrderItemID), " +
            "FOREIGN KEY (OrderID) REFERENCE FEARSOME_ORDERS (OrderID)) ";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ITEMS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

    
        //Insert Items data
    public static void createItems(int Ord_Item_ID, int Ord_ID, int Prod_ID, int QTY) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + ITEMS_TABLE_NAME + 
                  " (OrderItemID, OrderID, ProductID, Quantaty ) VALUES(" + Ord_Item_ID + ", "
                   + Ord_ID + ", " + Prod_ID + ", " + QTY  + " );" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Address in the Database." + "\nDetaill: " + e);
        }
    }

    
    // Search table data
    public static java.util.ArrayList searchbyItemID(int Item_ID)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + ITEMS_TABLE_NAME + " where Order_Item_ID like %" + Item_ID + "%;" ;                
          stmt = sqlConn.createStatement();
          rs = stmt.executeQuery(createString);  
          results = new java.util.ArrayList();
            while (rs.next() == true)
                results.add(new OrderSystem_Classes.Items (rs.getInt("Order_Item_ID"), rs.getInt("OrderID"), 
                        rs.getInt("ProductID"), rs.getInt("Quantaty")));  
        }catch (java.sql.SQLException e){
            throw new TableException("Unable to search Item Database." + "\nDetaill: " + e);
        }
        return results;
    }


    
    
    
}
