/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;

/**
 *
 * @author Gregory
 */
public class Orders_Table {
    
    public static final String ORDERS_TABLE_NAME = "FEFO_ORDERS";   
    public static java.sql.Connection sqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Orders_Table()
    {
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + ORDERS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + ORDERS_TABLE_NAME + " " + 
            "(OrderID integer identity (1,1) NOT NULL, " +
            "CustomerID integer NOT NULL, " +
            "Financial varchar(50) NULL, " +
            "OrderDate DATE NULL, " +
            "PRIMARY KEY (OrderID))";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ORDERS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

            //Insert Items data
    public static void createOrder(int Ord_ID, int Cust_ID, String Fin, String Ord_Date) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + ORDERS_TABLE_NAME + 
                  " (OrderID, CustomerID, Financial, OrderDate ) VALUES(" + Ord_ID + ", "
                   + Cust_ID + ", '" + Fin + "', '" + Ord_Date  + "' );" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Order in the Database." + "\nDetaill: " + e);
        }
    }

    


    
    
}
