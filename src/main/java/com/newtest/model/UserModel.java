package com.newtest.model;

import com.newtest.bean.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newtest.utility.JDBCDataSource;

public class UserModel {
	
	public static int computeID() {
		try(Connection conn = JDBCDataSource.getConnection();
            Statement stat = conn.createStatement();) {
			String q1 = "select max(id) from USERS";
			ResultSet rs = stat.executeQuery(q1);
			int maxid=0;
			while (rs.next()) {
				maxid = rs.getInt(1);
			}
			return maxid+1;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}
	}
	
	public static int delete(String eid) {
		try(Connection conn = JDBCDataSource.getConnection();
	            Statement stat = conn.createStatement();) {
				String q1 = "delete from USERS where id="+eid;
				int result = stat.executeUpdate(q1);
				return result; // 1 if delete, 0 if not delete
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
	}
	
	
	public static UserBean viewUser(String id) {
    	try(Connection conn = JDBCDataSource.getConnection();
			Statement stat = conn.createStatement(); ) {
    		UserBean bean = new UserBean();
			String q1 = "select * from USERS where id="+id;
			ResultSet rs = stat.executeQuery(q1);
			if (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setUsername(rs.getString(2));
				bean.setPassword(rs.getString(3));
			}
			return bean;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
	
	public static ArrayList userReport() {
    	List l1 = new ArrayList<UserBean>();
		try(Connection conn = JDBCDataSource.getConnection();
			Statement stat = conn.createStatement(); ) {
			String q1 = "select * from USERS";
			ResultSet rs = stat.executeQuery(q1);
			while (rs.next()) {
				String id = String.valueOf(rs.getInt(1));
				UserBean bean = UserModel.viewUser(id); 
				l1.add(bean);
			}
			return (ArrayList) l1;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
	
	public static int addUser(UserBean bean) {
		int result = -1;
        try (Connection conn = JDBCDataSource.getConnection();) {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS VALUES(?,?,?)");
            ps.setInt(1, bean.getId());
            ps.setString(2, bean.getUsername());
            ps.setString(3, bean.getPassword());
            result = ps.executeUpdate();
            conn.commit();
            ps.close();
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
	}
	
	public static int update(UserBean bean) {
		try(Connection conn = JDBCDataSource.getConnection()) {
				conn.setAutoCommit(false);
	            PreparedStatement ps = conn.prepareStatement(
	            		"update USERS set "
	            		+ "password=? "
	            		+ "where username=? "
	            );
	            ps.setString(1, bean.getPassword() );
	            ps.setString(2, bean.getUsername() );
	            int result = ps.executeUpdate();
	            conn.commit();
	            return result;
			} 
	        catch (Exception e) {
	        	e.printStackTrace();
	        	return 0;
	        }
	}
	
	
	public static UserBean login(String username, String password) {
		UserBean bean;
		try (Connection conn = JDBCDataSource.getConnection();) {
            PreparedStatement ps = conn.prepareStatement("select id from USERS where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	bean = new UserBean();
            	bean.setUsername(username);
            	bean.setPassword(password);
            	bean.setId(rs.getInt(1));
            	return bean;
            }
            ps.close();
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
	}
}
