/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

/**
 *
 * @author Gregory
 */
public class Customer_DB {
    
        private static final String CUSTOMER_TABLE_NAME = "FEARSOME_CUSTOMERS";   
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
  /*
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
            "(CustomerID integer identity (1,1) NOT NULL, " +
            "FirstName varchar(50) NOT NULL, " +
            "LastName varchar(50) NOT NULL, " +
            "BillAddress integer NOT NULL, " + 
            "ShipAddress integer NOT NULL, " + 
            "EmailAddress varchar(50) NOT NULL, " + 
            "PhoneNumber varchar(13) NULL, " + 
            "OrderIDs integer NULL, " +
            "PRIMARY KEY (CustomerID), " +
            "FOREIGN KEY (BillAddress) REFERENCE FEARSOME_ADDRESS (AddressID), " +
            "FOREIGN KEY (ShipAddress) REFERENCE FEARSOME_ADDRESS (AddressID))";
            stmt = Connection_DB.dbCon.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + CUSTOMER_TABLE_NAME + "\nDetaill: " + e);
        }        
    }
    
/**
 * @author Bella Belova
 * @param CustomerID A unique Customer_DB ID
 * @param FirstName Customer_DB First Name
 * @param LastName Customer_DB Last Name
 * @param BillAddress An integer that except "0" or "1" for checked or unchecked Billing Address
 * @param ShipAddress An integer that except "0" or "1" for checked or unchecked Shipping Address
 * @param EmailAddress Customer_DB EMail Address
 * @param PhoneNumber Varchar field that will except parenthesis and numbers
 * @param OrderIDs Order Number
 * @throws TableException This exception represents a problem with the access and updating of the DB table.
 */
 /*   
    //Insert Customer_DB data
    public static void createCustomer(int Cust_ID, String FName, String LName, int BillAddr, 
                                        int ShipAddr, String EMail, String PhNbr, int OrderNbr) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + CUSTOMER_TABLE_NAME + 
                  " (CustomerID, FirstName, LastName, BillAddress, ShipAddress, "
                  + "EmailAddress, PhoneNumber, OrderIDs) VALUES(" +
                    Cust_ID + ", '" + FName + "', '" + LName + "', '" + BillAddr + ", " + 
                    ShipAddr + ", '" + EMail + "', " + PhNbr + ", " + OrderNbr + ");" ;
          stmt = Connection_DB.dbCon.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Customer_DB in the Database." + "\nDetaill: " + e);
        }
    }

*/    
    // Search table data
    public static java.util.ArrayList searchbyLASTNAME(String LAST_NAME)
            throws TableException{
        int id; String fn; String ln;
        java.sql.Statement stmt;
        Object p = null;
        java.util.ArrayList results = null;
        java.sql.ResultSet rs = null;
        
        try{
          String createString = "select * from " + CUSTOMER_TABLE_NAME + " where LastName like '%" + LAST_NAME + "%';" ;                
          stmt = Connection_DB.dbCon.createStatement();
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
