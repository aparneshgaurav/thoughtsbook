package com.thb.login.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thb.db.DatabaseConnection;
import com.thb.login.Authenticate;
import com.thb.model.RegisterBean;

public class AuthenticateImpl implements Authenticate{

	public Boolean authenticateLoginData(String username, String password) throws SQLException {
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select password from login where username = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setString(1,username);
			ResultSet res = preparedStatement.executeQuery();
			String str = "";
			while(res.next()){
				str = str + res.getString(1);
			}
//			System.out.println(str);	 
			if(str.equalsIgnoreCase(password)){
				bool = true ; 
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}

	public RegisterBean getUserData(String userName) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = DatabaseConnection.getConnection();
		RegisterBean registerBean = new RegisterBean();
		try{

			String sql = "select password,sex,urldata from login where username = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setString(1, userName);
			ResultSet res = preparedStatement.executeQuery();
			String str = "";
			while(res.next()){
				str = str + res.getString(1)+"aparnesh-gaurav"+res.getString(2)+"aparnesh-gaurav"+res.getString(3);
			}
			//		 System.out.println(str);
			String[] stryArray = str.split("aparnesh-gaurav");


//			System.out.println(stryArray[0]);
//			System.out.println(stryArray[1]);
//			System.out.println(stryArray[2]);


			
			registerBean.setUserName(userName);
			registerBean.setPassword(stryArray[0]);
			registerBean.setSex(stryArray[1]);
			registerBean.setUrlData(stryArray[2]);


			//	     System.out.println(str);	 
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}

		return registerBean;
	}

	public String getBookList(String userName, String category) throws SQLException {
		// TODO Auto-generated method stub
		String bookList = "";
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "select bookname from bookdetails where username = ? and category = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2, category);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()){
				bookList = bookList + res.getString(1);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bookList ;
	}

}
