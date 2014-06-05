/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;


/**
 *
 * @author Gregory
 */
public class Product_Table {
    
    public static final String PRODUCT_TABLE_NAME = "FEFO_PRODUCTS";
    public static java.sql.Connection mysqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Product_Table()
    {
        mysqlConn = Connect.MYSQL.getMSQLConn();
    }
    
    
        // Drop Table
    
        static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + PRODUCT_TABLE_NAME + ";";
            stmt = mysqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + PRODUCT_TABLE_NAME + " " + 
            "(PROD_ID integer NOT NULL, " + 
            "CATEGORY_ID integer NOT NULL, " +
            "PROD_NAME varchar(40) NOT NULL, " +
            "PROD_DESC varchar(40) NOT NULL, " +
            "PROD_PRICE float NOT NULL, " + 
            "PRIMARY KEY (PROD_ID)), " + 
            "FOREIGN KEY (PROD_ID) REFERENCE FEFO_STOCK_ITEMS (PROD_ID))";
            stmt = mysqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + PRODUCT_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

            //Insert Items data
    public static void createOrder(int Prod_ID, int Categ_ID, String Prod_Name, String Prod_Desc, float Prod_Price) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + PRODUCT_TABLE_NAME + 
                  " (PROD_ID, CATEGORY_ID, PROD_NAME, PROD_DESC, PROD_PRICE ) VALUES(" + Prod_ID + ", " + 
                  Categ_ID + ", '" + Prod_Name + "', '" + Prod_Desc  + "', " + Prod_Price + " );" ;
          stmt = mysqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Order in the Database." + "\nDetaill: " + e);
        }
    }

}
