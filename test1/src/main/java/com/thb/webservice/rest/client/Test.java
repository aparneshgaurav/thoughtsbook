package com.thb.webservice.rest.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thb.db.DatabaseConnection;

public class Test {
 public static void main(String[] args) throws SQLException{
	 Connection connection = DatabaseConnection.getConnection();
	 try{
	 System.out.println("hello");
 
	
	 System.out.println(connection);
	 
	 
	 String sql = "select password from login where username = ? ";
	 PreparedStatement preparedStatement = connection.prepareStatement(sql);	
	 preparedStatement.setString(1, "aparnesh");
	 ResultSet res = preparedStatement.executeQuery();
	 String str = "";
	 while(res.next()){
		 str = str + res.getString(1);
	 }
     System.out.println(str);	 
	 }
	 catch(SQLException e){
		 e.printStackTrace();
	 }
	 finally{
		 connection.close();
	 }
 }
}
