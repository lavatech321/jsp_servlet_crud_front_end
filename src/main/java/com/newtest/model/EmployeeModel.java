package com.newtest.model;
import com.newtest.bean.*;
import com.newtest.utility.*;

import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
	
	public static int computeID() {
		try(Connection conn = JDBCDataSource.getConnection();
             Statement stat = conn.createStatement();) {
			String q1 = "select max(id) from EMPLOYEE";
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
	
	public static int delete(int eid) {
		try(Connection conn = JDBCDataSource.getConnection();
	            Statement stat = conn.createStatement();) {
				String q1 = "delete from EMPLOYEE where id="+eid;
				int result = stat.executeUpdate(q1);
				return result; // 1 if delete, 0 if not delete
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
				return 0;
			}
	}
	
	/*
	 * fname VARCHAR(35), lname VARCHAR(35), username VARCHAR(35), email
	 * VARCHAR(40), address VARCHAR(200), phno VARCHAR(11), country VARCHAR(30),
	 * state VARCHAR(30), zip INT, remote TINYINT(1) NOT NULL, jobtype VARCHAR(15),
	 * profile BLOB
	 */
	
	public static int update(EmployeeBean bean) {
		try(Connection conn = JDBCDataSource.getConnection()) {
				conn.setAutoCommit(false);
				PreparedStatement ps = conn.prepareStatement(
	            		"update EMPLOYEE set "
	            		+ "fname=? ,"
	            		+ "lname=? ,"
	            		+ "username=? ,"
	            		+ "email=? ,"
	            		+ "address=? ,"
	            		+ "phno=? ,"
	            		+ "country=? ,"
	            		+ "state=? ,"
	            		+ "remote=? ,"
	            		+ "zip=? ,"
	            		+ "jobtype=? ,"
	            		+ "profile=? "
	            		+ "where id=? "
	            );
				PreparedStatement ps1 = conn.prepareStatement(
	            		"update EMPLOYEE set "
	            		+ "fname=? ,"
	            		+ "lname=? ,"
	            		+ "username=? ,"
	            		+ "email=? ,"
	            		+ "address=? ,"
	            		+ "phno=? ,"
	            		+ "country=? ,"
	            		+ "state=? ,"
	            		+ "remote=? ,"
	            		+ "zip=? ,"
	            		+ "jobtype=? "
	            		+ "where id=? "
	            );
		        if (bean.getProfile() != null) {
		        	ps.setString(1, bean.getFname() );
		            ps.setString(2, bean.getLname() );
		            ps.setString(3, bean.getUsername() );
		            ps.setString(4, bean.getEmail() );
		            ps.setString(5, bean.getAddress() );
		            ps.setString(6, bean.getPhno() );
		            ps.setString(7, bean.getCountry() );
		            ps.setString(8, bean.getState() );
		            ps.setInt(9, bean.getRemote() );
		            ps.setInt(10, bean.getZip() );
		            ps.setString(11, bean.getJobtype() );
		            ps.setBlob(12, bean.getProfile());
		            ps.setInt(13, bean.getId() );
		            int result = ps.executeUpdate();
		            conn.commit();
		            return result;
		        }
		        else {
		        	ps1.setString(1, bean.getFname() );
		            ps1.setString(2, bean.getLname() );
		            ps1.setString(3, bean.getUsername() );
		            ps1.setString(4, bean.getEmail() );
		            ps1.setString(5, bean.getAddress() );
		            ps1.setString(6, bean.getPhno() );
		            ps1.setString(7, bean.getCountry() );
		            ps1.setString(8, bean.getState() );
		            ps1.setInt(9, bean.getRemote() );
		            ps1.setInt(10, bean.getZip() );
		            ps1.setString(11, bean.getJobtype() );
		            ps1.setInt(12, bean.getId());
		            int result = ps1.executeUpdate();
		            conn.commit();
		            return result;
		        }
			} 
	        catch (Exception e) {
	        	e.printStackTrace();
	        	return 0;
	        }
	}
	
    public static long add(EmployeeBean bean){
        int result = -1;
        try (Connection conn = JDBCDataSource.getConnection();) {
            conn.setAutoCommit(false);
            PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, bean.getId());
            ps.setString(2, bean.getFname());
            ps.setString(3, bean.getLname());
            ps.setString(4, bean.getUsername());
            ps.setString(5, bean.getEmail());
            ps.setString(6, bean.getAddress());
            ps.setString(7, bean.getPhno());
            ps.setString(8, bean.getCountry());
            ps.setString(9, bean.getState());
            ps.setInt(10, bean.getZip());
            ps.setInt(11, bean.getRemote());
            ps.setString(12, bean.getJobtype());
            ps.setBlob(13, bean.getProfile());
            result = ps.executeUpdate();
            conn.commit();
            ps.close();
        } 
        catch (Exception e) {
        	e.printStackTrace();
        }
        return result;
    }
    
    public static ArrayList empReport() {
    	List l1 = new ArrayList<EmployeeBean>();
		try(Connection conn = JDBCDataSource.getConnection();
			Statement stat = conn.createStatement(); ) {
			String q1 = "select * from EMPLOYEE";
			ResultSet rs = stat.executeQuery(q1);
			while (rs.next()) {
				String id = String.valueOf(rs.getInt(1));
				EmployeeBean bean = EmployeeModel.viewEmp(id); 
				l1.add(bean);
			}
			return (ArrayList) l1;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    public static ArrayList listID() {
    	List l1 = new ArrayList<Integer>();
		try(Connection conn = JDBCDataSource.getConnection();
			Statement stat = conn.createStatement(); ) {
			String q1 = "select * from EMPLOYEE";
			ResultSet rs = stat.executeQuery(q1);
			while (rs.next()) {
				l1.add(rs.getInt(1));
			}
			return (ArrayList) l1;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
    public static EmployeeBean viewEmp(String id) {
    	try(Connection conn = JDBCDataSource.getConnection();
			Statement stat = conn.createStatement(); ) {
    		EmployeeBean bean = new EmployeeBean();
			String q1 = "select * from EMPLOYEE where id="+id;
			ResultSet rs = stat.executeQuery(q1);
			if (rs.next()) {
				bean.setId(rs.getInt(1));
				bean.setFname(rs.getString(2));
				bean.setLname(rs.getString(3));
				bean.setUsername(rs.getString(4));
				bean.setEmail(rs.getString(5));
				bean.setAddress(rs.getString(6));
				bean.setPhno(rs.getString(7));
				bean.setCountry(rs.getString(8));
				bean.setState(rs.getString(9));
				bean.setZip(rs.getInt(10));
				bean.setRemote(rs.getInt(11));
				bean.setJobtype(rs.getString(12).toUpperCase());
			}
			return bean;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
    }
    
}
