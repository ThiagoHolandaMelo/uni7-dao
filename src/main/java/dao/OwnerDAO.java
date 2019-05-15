package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OwnerModel;

public class OwnerDAO extends DAO<OwnerModel>{
	
	private OwnerModel loadOwner(ResultSet rs) throws SQLException {
        return new OwnerModel(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
    }
	
	public List<OwnerModel> findAll() {
        return find("select * from owners", (PreparedStatement stmt) -> {
            try(ResultSet rs = stmt.executeQuery()) {
                List<OwnerModel> owners = new ArrayList<OwnerModel>();
                while (rs.next()) {
                	owners.add(loadOwner(rs));
                }
                return owners;
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;
        });
    }
}
