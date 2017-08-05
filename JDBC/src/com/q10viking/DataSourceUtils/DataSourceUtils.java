package com.q10viking.DataSourceUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	static ComboPooledDataSource ds=new ComboPooledDataSource("Q10Viking");
	/**
	 * 获取数据源
	 * @return 数据源
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * 获取一个连接
	 * @return 连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	
	
	/**
	 * 关闭资源
	 * @param ct  连接
	 * @param st  执行者
	 * @param rs  结果结
	 */
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
