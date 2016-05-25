package com.thb.login;

import java.sql.SQLException;

public interface RegisterUser {
	public Boolean register(String username , String password , String sex ,String urlData ) throws SQLException;
	public void saveCategoryForUserName( String userName , String category) throws SQLException;
	public void saveBookDetails(String username, String category , String bookName ,String pageNumber,String pageContent) throws SQLException;
}
