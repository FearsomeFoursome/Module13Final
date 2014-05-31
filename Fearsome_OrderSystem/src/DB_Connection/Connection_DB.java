/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Gregory
 */
public class Connection_DB {

    // Connection string to MYSQL database
    
    static java.sql.Connection dbCon = null;
    private static final String jdbcDriver = "com.mysql.jdbc.Driver";
    
    private static final String connectionUrl = "jdbc:mysql://oak.safesecureweb.com:3306/nianbrandsco?zeroDateTimeBehavior=convertToNull";
    private static final String username = "store";
    private static final String password = "testDB1234!";
    private static String n;

        public static void initialize(){
        try{
            Class.forName(Connection_DB.jdbcDriver);
            
            try{
                dbCon = java.sql.DriverManager.getConnection(connectionUrl,username, password);
            } catch (java.sql.SQLException e){System.err.println(e); }
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }
    }


            public static void main(String[] args) {
        initialize();
        
        System.out.print("welcome to our store\n");
        System.out.print("please select from our menu\n");
        
        BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
    try
        {
           
            //Loop for menu
            while (!"6".equals)
            {
                
            
            if("6".equals()         // user enters "6
}
}