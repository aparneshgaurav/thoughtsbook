package com.thb.login.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.thb.db.DatabaseConnection;
import com.thb.login.RegisterUser;

public class RegisterUserImpl implements RegisterUser {

	public Boolean register(String username, String password, String sex , String urlData) throws SQLException {
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "insert into login values( ? , ? , ? , ? ) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setString(1,username);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,sex);
			preparedStatement.setString(4, urlData);
			bool = preparedStatement.execute();
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		return bool ; 
	}

	public void saveCategoryForUserName(String userName, String category) throws SQLException {
		// TODO Auto-generated method stub
		
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "insert into userNameCategoryBookIdBookName values( ? , ? , ? , ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,category);
			preparedStatement.setString(3, "" );
			preparedStatement.setString(4, "");
			bool = preparedStatement.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
		
	}

	public void saveBookDetails(String username, String category, String bookName, String pageNumber,
			String pageContent) throws SQLException {
		// TODO Auto-generated method stub
		Boolean bool = false;
		Connection connection = DatabaseConnection.getConnection();
		try{
			System.out.println(connection);
			String sql = "insert into bookdetails values ( ? , ? , ? , ? , ? , ?) ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setString(1,"");
			preparedStatement.setString(2,bookName);
			preparedStatement.setString(3, pageContent);
			preparedStatement.setString(4, username);
			preparedStatement.setString(5, category);
			preparedStatement.setString(6, pageNumber);
			System.out.println("Saving of the book details is done");
			bool = preparedStatement.execute();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			connection.close();
		}
	}

}
