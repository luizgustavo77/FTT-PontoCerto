package pontocerto.Business.DAO;

import java.sql.Connection;
import java.sql.Driver;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//import java.util.Properties;

// Documentacao https://docs.microsoft.com/pt-br/sql/connect/jdbc/working-with-a-connection?view=sql-server-ver15
public abstract class BancoDAO
{

    public Connection abrirConexao() throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
        Connection connection;
        try
        {
//            String conexaoUrl = "jdbc:sqlserver://(LocalDb)\\MSSQLLocalDB;database=PontoCerto";
//            String username = "sa";
//            String password = "123456";
//            
//            connection = DriverManager.getConnection(conexaoUrl, username, password);
//            System.out.println("Conectado ao Microsoft Sql Server");
            
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://LAPTOP-43PCBHT1\\SQLEXPRESS;user=sa;password=123456;databaseName=PontoCerto";
            connection = DriverManager.getConnection(connectionUrl);
            
//            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
//            String connectionUrl = "jdbc:sqlserver://LAPTOP-43PCBHT1\\SQLEXPRESS;database=PontoCerto;integratedSecurity=true;";
//            connection = driver.connect(connectionUrl, new Properties());
            
            
            //connection =  DriverManager.getConnection("mysql://localhost/alura_jdbc", "root", "");
        }
        catch (SQLException e)
        {
            System.out.println("Ocorreu um erro: " );
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        
        // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); String connectionUrl = "jdbc:sqlserver://localhost;database=AdventureWorks;integratedSecurity=true;" Connection con = DriverManager.getConnection(connectionUrl);

        return connection;
    }
}
