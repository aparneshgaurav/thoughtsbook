package com.thb.webservice.rest.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.thb.db.DatabaseConnection;

public class DBTest {
 public static void main(String[] args) throws SQLException{
	 
		 Boolean bool = false;
			Connection connection = DatabaseConnection.getConnection();
			try{
				System.out.println(connection);
				String sql = "insert into userNameCategoryBookIdBookName values( ? , ? , ? , ?) ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);	
				preparedStatement.setString(1,"userName");
				preparedStatement.setString(2,"category");
				preparedStatement.setString(3,"bookid");
				preparedStatement.setString(4,"bookName");
				
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
