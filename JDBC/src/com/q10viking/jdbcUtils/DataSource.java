package com.q10viking.jdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;

import com.q10viking.wrapConnection.connectionWrap;

public class DataSource {

	static LinkedList<Connection> pool = new LinkedList<>();

	static {
		// 默认定义三个连接
		for (int i = 0; i < 3; i++) {
			try {
				Connection conn = jdbcUtils.getConnection();
				// 添加到LinkedList数据结构中
				pool.addLast(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("建立一个连接池后默认的连接数为"+pool.size());
	}

	public Connection getConnection() {
		if (pool.isEmpty()) {
			// 如果连接池的数量不够需要添加连接
			System.out.println("连接池中连接不够用，添加三个连接");
			for (int i = 0; i < 3; i++) {
				try {
					Connection conn = jdbcUtils.getConnection();
					// 添加到LinkedList数据结构中
					pool.addLast(conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		Connection conn = pool.removeFirst();
		System.out.println("从连接池获取一个连接");
		System.out.println("目前的连接数"+pool.size());
		//return conn;
		
		//-------------------------------
		//添加装饰器
		connectionWrap connWrap=new connectionWrap(conn,pool);
		return connWrap;
	}
	
	public void addBack(Connection conn) {
		pool.addLast(conn);
		System.out.println("归还一个连接到连接池");
		System.out.println("目前的连接数"+pool.size());
	}
	
}
