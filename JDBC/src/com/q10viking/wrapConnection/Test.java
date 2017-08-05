package com.q10viking.wrapConnection;

import java.sql.Connection;
import java.sql.SQLException;

import com.q10viking.jdbcUtils.DataSource;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DataSource pool = new DataSource();
		Connection conn1 = pool.getConnection();
		Connection conn2 = pool.getConnection();
		Connection conn3 = pool.getConnection();
		Connection conn4 = pool.getConnection();
		 
	//自身连接关闭，不用亲自调用pool来回收
		conn1.close();
		conn2.close();
		conn3.close();
		conn4.close();
	}

}
