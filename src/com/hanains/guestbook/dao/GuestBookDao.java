package com.hanains.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanains.guestbook.vo.GuestBookVo;

public class GuestBookDao {
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			//1.driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.db connect
			String dbUrl = "jdbc:oracle:thin:@localhost:1522:xe";
			connection = DriverManager.getConnection(dbUrl,"webdb","webdb");
			//3.statement make
			stmt = connection.createStatement();
			//4.sql execute
			String sql="select no,name,password,message,reg_date from guestbook";
			rs = stmt.executeQuery(sql);
			//5.result get
			while(rs.next()){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String message = rs.getString(4);
				String date = rs.getString(5);
				
				GuestBookVo vo = new GuestBookVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setPassword(password);
				vo.setMessage(message);
				vo.setDate(date);
				
				list.add(vo);
			}
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패 - "+e);
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(connection!=null)connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void insert(GuestBookVo vo){
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1522:xe";
			connection = DriverManager.getConnection(dbUrl,"webdb","webdb");
			
			String sql = "insert into guestbook values(GUESTBOOK_SEQ.nextval,?,?,?,SYSDATE)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());
			
			pstmt.executeUpdate();
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패 - "+e);
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				System.out.println("에러- "+e);
				e.printStackTrace();
			}
		}
	}
	
	public void Delete(GuestBookVo vo){
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String dbUrl = "jdbc:oracle:thin:@localhost:1522:xe";
			connection = DriverManager.getConnection(dbUrl,"webdb","webdb");
			
			String sql = "delete from guestbook where no =? AND password = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			
			pstmt.executeUpdate();
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패 - "+e);
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				System.out.println("에러- "+e);
				e.printStackTrace();
			}
		}
	}
}
