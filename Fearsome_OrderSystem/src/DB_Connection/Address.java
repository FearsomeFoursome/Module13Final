/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Gregory
 */
public class Address {
    
    private static final String CUSTOMER_TABLE_NAME = "FEARSOME_ADDRESS";   
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
            "(AddressID integer identity (1,1) NOT NULL, " +
            "CustomerID integer NOT NULL, " +
            "AddressType varchar(10) NOT NULL, " +
            "Address1 varchar(50) NOT NULL, " +
            "Address2 varchar(50) NULL, " +
            "City varchar(50) NOT NULL, " + 
            "State varchar(50) NOT NULL " + 
            "Zip integer NOT NULL " +
            "PRIMARY KEY (AddressID))";
            stmt = Connection_DB.dbCon.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + CUSTOMER_TABLE_NAME + "\nDetaill: " + e);
        }        
    }
    
    
}
