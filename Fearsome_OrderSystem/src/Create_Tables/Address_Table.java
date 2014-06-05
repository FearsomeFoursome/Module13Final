/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Create_Tables;



/**
 *
 * @author Gregory
 */
public class Address_Table {
    
    public static final String ADDRESS_TABLE_NAME = "FEFO_ADDRESS";  
    public static java.sql.Connection sqlConn;
    public static class TableException extends Exception{
        TableException(String s){
            super(s);
        }
    }
    
    public Address_Table()
    {
        sqlConn = Connect.SQL.getSQLConn();
    }
    
    // Drop Table
    
    static void reset()throws TableException{
        String createString;    
        java.sql.Statement stmt;
        
        try{      
            createString = "drop table " + ADDRESS_TABLE_NAME + ";";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
         } catch (java.sql.SQLException e) {
             if (!(e.getMessage().contains("Unknown")))
                System.err.println(e); 
        }
        
        try{
            //Create the CUSTOMER Table
            createString =
            "create table " + ADDRESS_TABLE_NAME + " " + 
            "(AddressID integer identity (1,1) NOT NULL, " +
            "CustomerID integer NOT NULL, " +
            "AddressType varchar(10) NOT NULL, " +
            "Address1 varchar(50) NOT NULL, " +
            "Address2 varchar(50) NULL, " +
            "City varchar(50) NOT NULL, " + 
            "State varchar(50) NOT NULL, " + 
            "Zip integer NOT NULL, " +
            "PRIMARY KEY (AddressID), " + 
            "FOREIGN KEY (CustomerID) REFERENCES FEARSOME_CUSTOMER (CustomerID)) ";
            stmt = sqlConn.createStatement();
            stmt.executeUpdate(createString);
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create " + ADDRESS_TABLE_NAME + "\nDetaill: " + e);
        }        
    }

        //Insert Address_Table data
    public static void createAddress(int Addr_ID, int Cust_ID, String Addr_Type,
                                        String Addr1, String Addr2, String Addr_City, String Addr_State, int Addr_Zip) 
        throws TableException{
    
    java.sql.Statement stmt;
        try{

          String createString = "insert into " + ADDRESS_TABLE_NAME + 
                  " (AddressID, CustomerID, AddressType, Address1, Address2, "
                  + "City, State, Zip) VALUES(" + Addr_ID + 
                    Cust_ID + ", '" + Addr_Type + "', '" + Addr1 + "', '" + Addr2 + "', " + 
                    Addr_City + "', '" + Addr_State + "', " + Addr_Zip + ");" ;
          stmt = sqlConn.createStatement();
          stmt.executeUpdate(createString);  
        } catch (java.sql.SQLException e) {
            throw new TableException("Unable to create a new Address in the Database." + "\nDetaill: " + e);
        }
    }
    
}
