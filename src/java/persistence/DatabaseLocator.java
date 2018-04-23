
package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseLocator {
    
    private static DatabaseLocator instance = new DatabaseLocator();
    
    static DatabaseLocator getInstance(){
        return instance;
    }
    private DatabaseLocator(){}
    
    public Connection getConnection() throws SQLException,ClassNotFoundException{
       Class.forName("com.mysql.jdbc.Driver");
        Connection conn =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/entrega", "root", "");
        return conn;
    }
    
    
}
