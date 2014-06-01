/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB_Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author bnunez
 */
public class Menu {
    
    private String Selection;
 
public void readSelection (String Option)
{
    Selection = Option;
}
public String Choice ()
{
    return Selection;
}

    /**
     *
     * 
     */
    public static class Connection_DB {

        // Connection string to MYSQL database
        static Connection dbCon = null;
        private static final String jdbcDriver = "com.mysql.jdbc.Driver";
        private static final String connectionUrl = "jdbc:mysql://oak.safesecureweb.com:3306/nianbrandsco?zeroDateTimeBehavior=convertToNull";
        private static final String username = "store";
        private static final String password = "testDB1234!";
        private static String n;

        public static void initialize() {
            try {
                Class.forName(Connection_DB.jdbcDriver);
                try {
                    dbCon = DriverManager.getConnection(connectionUrl, username, password);
                } catch (SQLException e) {
                    System.err.println(e);
                }
            } catch (ClassNotFoundException e) {
                System.err.println(e);
            }
        }

        public static void main(String[] args) {
            Menu selection = new Menu();
            BufferedReader brin = new BufferedReader(new InputStreamReader(System.in));
            //Run the program until user enters "4"
            try {
                while (!"4".equals(selection.Choice())) {
                    if ("4".equals(selection.Choice())) {
                        continue;
                    }
                    System.out.print("Welcome to Olympic Store\n\n\n\n\n");
                    System.out.print("Please make a Selection, just type in number\n\n\n\n\n");
                    System.out.print("Would you like: \n\n");
                    System.out.print("1.Login\n\n");
                    System.out.print("2.Place Order \n\n");
                    System.out.print("3.Update / Modify Order \n\n");
                    System.out.print("4.Exit \n\n");
                    selection.readSelection(brin.readLine());
                    // user enters "4"
                    if ("4".equals(selection.Choice())) {
                        continue;
                    }
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error:" + e);
            } // end catch
        }
    }
}


