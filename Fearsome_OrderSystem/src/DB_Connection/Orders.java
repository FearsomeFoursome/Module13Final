/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Gregory
 */
public class Orders {
    
    private static final String CUSTOMER_TABLE_NAME = "FEARSOME_ORDERS";   
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    // Drop Table
    
    static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        try{      
            createString = "drop table " + CUSTOMER_TABLE_NAME + ";";
            stmt = Connection_DB.dbCon.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + CUSTOMER_TABLE_NAME + " " + 
            "(OrderID integer identity (1,1) NOT NULL, " +
            "CustomerID integer NOT NULL, " +
            "Financial varchar(50) NULL, " +
            "OrderDate DATE NULL, " +
            "PRIMARY KEY (OrderID))";
            stmt = Connection_DB.dbCon.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + CUSTOMER_TABLE_NAME + "\nDetaill: " + e);
        }        
    }
    
    
    
}
