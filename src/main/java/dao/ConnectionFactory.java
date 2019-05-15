package dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static HikariDataSource ds;
	
	private static HikariDataSource getDS() throws IOException {
        if (ds == null) {
            Properties props = new Properties();
            props.load(ConnectionFactory.class.getResourceAsStream("/db/hikari.properties"));
            HikariConfig config = new HikariConfig(props);
            ds = new HikariDataSource(config);
        }
        return ds;
    }
	
	public static Connection getPooledConnection() throws SQLException, IOException {
        return getDS().getConnection();
    }
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection("jdbc:sqlite:"+ ConnectionFactory.class.getResource("/db/sqlite/petclinic.db").getFile());
		
	}

}
