package com.q10viking.jdbcUtils;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataSource pool = new DataSource();
		Connection conn1 = pool.getConnection();
		Connection conn2 = pool.getConnection();
		Connection conn3 = pool.getConnection();
		Connection conn4 = pool.getConnection();
		 
		pool.addBack(conn1);
		pool.addBack(conn4);
		pool.addBack(conn3);
		pool.addBack(conn2);
	}

}
