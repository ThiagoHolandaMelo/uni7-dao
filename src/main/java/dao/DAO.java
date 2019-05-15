package dao;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.function.Function;

public class DAO<T> {
	
	protected Connection getConnection() throws SQLException, IOException {
        try {
            return ConnectionFactory.getPooledConnection();
        } catch (Exception e) {
            return null;
        }
    }
	
	protected List<T> find(String sql, Function<PreparedStatement, List<T>> action){
        try(Connection conn = getConnection()){
            try(var stmt = conn.prepareStatement(sql)){
                    return action.apply(stmt);
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }catch(SQLException e){
        	System.out.println(e.getMessage());
        } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        return null;
    }
	
}
