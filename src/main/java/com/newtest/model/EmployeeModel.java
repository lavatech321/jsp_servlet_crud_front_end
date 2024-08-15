package com.newtest.model;
import com.newtest.bean.*;
import com.newtest.utility.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
	
    public long add(EmployeeBean bean){
        Connection conn = null;
        EmployeeModel model = new EmployeeModel();
        
        try {
            conn = JDBCDataSource.getConnection();
            conn.setAutoCommit(false);
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
            
            System.out.println(bean.getFname());
            System.out.println(bean.getPic());
            
            //ps.setLong(1, pk);
            ps.setString(2, bean.getFname());
            ps.setString(3, bean.getLname());
            ps.setString(4, bean.getEmail());
            ps.setString(5, bean.getAddress());
            ps.setString(6, bean.getPhno());
            ps.setString(7, bean.getCountry());
            ps.setString(8, bean.getState());
            ps.setInt(9, bean.getZip());
            ps.setString(10, bean.getStatus());
            ps.setString(11, bean.getJobtype());
            ps.setBlob(12, bean.getPic());
            ps.executeUpdate();
            System.out.println("Record inserted");
            conn.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (Exception e2) {
                e.printStackTrace();
                System.out.println(e.getStackTrace());
                
            }
    
        }
        return 0;
    }
    
    public List list() throws Exception {
        ArrayList list = new ArrayList ();
        Connection conn = null;
        System.out.println("list called");
        conn = JDBCDataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMPLOYEE ");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            EmployeeBean bean = new EmployeeBean();
            bean.setId(rs.getInt(1));
            bean.setFname(rs.getString(2));
            bean.setLname(rs.getString(3));
            bean.setEmail(rs.getString(4));
            bean.setAddress(rs.getString(5));
            bean.setPhno(rs.getString(6));
            bean.setCountry(rs.getString(7));
            bean.setState(rs.getString(8));
            bean.setZip(rs.getInt(9));
            bean.setStatus(rs.getString(10));
            bean.setJobtype(rs.getString(11));
            bean.setPic(rs.getBlob(12));
            list.add(bean);
        }
        return list;
    }

}
