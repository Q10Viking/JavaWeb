package com.q10viking.jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class jdbcUtils {
	static final String DRIVERCLASS;
	static final String URL;
	static final String USER;
	static final String PASSWORD;
	
	static {
		//获取ResourceBundle对象
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		
		//从配置文件获取信息
		DRIVERCLASS=bundle.getString("driverClass");
		URL=bundle.getString("url");
		USER=bundle.getString("user");
		PASSWORD=bundle.getString("password");
		
	}
	
	//注册驱动
	static {
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	 public static void closeResource(Connection ct, Statement st, ResultSet rs) {
	        closeResultSet(rs);
	        closeStatement(st);
	        closeConnection(ct);
	    }
	    
	    /**
	     * @param ct连接
	     */
	    public static void closeConnection(Connection ct) {
	        if(ct!=null) {
	            try {
	                ct.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        ct=null;
	    }
	    
	    /**
	     * @param st语句执行者
	     * @return 
	     */
	    public static void  closeStatement(Statement st) {
	        if(st!=null) {
	            try {
	                st.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        st=null;
	    }
	    
	    /**
	     * @param rs结果
	     */
	    public static void closeResultSet(ResultSet rs) {
	        if(rs!=null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        rs=null;
	    }
	
}
