/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

/**
 *
 * @author Gregory
 */
public class Stock_Items_Table {
    
    public static final String STOCK_ITEMS_TABLE_NAME = "FEFO_STOCK_ITEMS";
    public static java.sql.Connection mysqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Stock_Items_Table()
    {
        mysqlConn = Connect.MYSQL.getMSQLConn();
    }
    
    
    // Drop Table
    
        static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + STOCK_ITEMS_TABLE_NAME + ";";
            stmt = mysqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + STOCK_ITEMS_TABLE_NAME + " " + 
            "(PROD_ID integer NOT NULL, " +
            "PROD_NAME varchar(40) NULL, " +
            "STOCK_QTY integer NOT NULL, " +
            "PRIMARY KEY (PROD_ID))";
            stmt = mysqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + STOCK_ITEMS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

            //Insert Items data
    public static void createOrder(int Prod_ID, String Prod_Name, int Stock_QTY) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + STOCK_ITEMS_TABLE_NAME + 
                  " (PROD_ID, PROD_NAME, STOCK_QTY ) VALUES(" + Prod_ID + ", '" + Prod_Name + "', " + Stock_QTY  + " );" ;
          stmt = mysqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Order in the Database." + "\nDetaill: " + e);
        }
    }

    
 


    
}
