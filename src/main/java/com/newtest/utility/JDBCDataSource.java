package com.newtest.utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {
	
	/**
     * JDBC Database connection pool ( DCP )
     */
    private static JDBCDataSource datasource;
    private JDBCDataSource() {
    }
    private ComboPooledDataSource cpds = null;
    /**
     * Create instance of Connection Pool
     *
     * @return
     */
    public static JDBCDataSource getInstance() {
        if (datasource == null) {
            ResourceBundle rb = ResourceBundle.getBundle("newtest.System");
            datasource = new JDBCDataSource();
            datasource.cpds = new ComboPooledDataSource();
            try {
                datasource.cpds.setDriverClass(rb.getString("driver"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            datasource.cpds.setJdbcUrl(rb.getString("url"));
            datasource.cpds.setUser(rb.getString("username"));
            datasource.cpds.setPassword(rb.getString("password"));
        }
        return datasource;
    }
    /**
     * Gets the connection from ComboPooledDataSource
     *
     * @return connection
     */
    public static Connection getConnection() throws Exception {
        return getInstance().cpds.getConnection();
    }
    /**
     * Closes a connection4
     *
     * @param connection
     * @throws Exception
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            }
        }
    }
    
    //public static void main(String[] args) throws Exception {
    //	Connection con = JDBCDataSource.getConnection();
    //	System.out.println(con);
    //	System.out.println("end");
    //	Statement stat = con.createStatement();
    	//String q1 = "create table test123(no int)";
    	//int result = stat.executeUpdate(q1);
    	//System.out.println(result);
    	
    	//String q1 = "insert into test123 values(101)";
    	//PreparedStatement ps = con.prepareStatement(q1);
    	//int result = ps.executeUpdate();
    	//System.out.println(result);
    	
    	//String q1 = "select * from test123";
    	//ResultSet rs = stat.executeQuery(q1);
    	//while(rs.next()) {
    	//	System.out.println(rs.getInt(1));
    	//}
    //}
}
