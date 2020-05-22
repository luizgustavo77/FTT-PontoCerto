package pontocerto.Bussines.DAO;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Documentacao https://docs.microsoft.com/pt-br/sql/connect/jdbc/working-with-a-connection?view=sql-server-ver15

public abstract class BancoDAO {


    public Connection abrirConeccao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Connection connection;
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();  
            String connectionUrl = "jdbc:sqlserver://localhost;database=PontoCerto;integratedSecurity=true;";  
            connection = driver.connect(connectionUrl, new Properties());  
            //connection =  DriverManager.getConnection("mysql://localhost/alura_jdbc", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }
}
