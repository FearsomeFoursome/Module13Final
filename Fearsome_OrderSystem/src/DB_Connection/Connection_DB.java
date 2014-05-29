/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

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
        

}
}