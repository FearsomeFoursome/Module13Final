/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

/**
 *
 * @author Gregory
 */
public class Items_Table {
    
    public static final String ITEMS_TABLE_NAME = "FEFO_ITEMS";   
    public static java.sql.Connection sqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Items_Table()
    {
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + ITEMS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the Items_Table Table
            createString =
            "create table " + ITEMS_TABLE_NAME + " " + 
            "(OrderItemID integer identity (1,1) NOT NULL, " +
            "OrderID integer NOT NULL, " +
            "ProductID integer NOT NULL, " +
            "Quantaty integer NOT NULL, " +
            "PRIMARY KEY (OrderItemID), " +
            "FOREIGN KEY (OrderID) REFERENCE FEFO_ORDERS (OrderID)) ";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ITEMS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

    
        //Insert Items_Table data
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

    
    
    }


    
    
    
