package com.thb.login;

import java.sql.SQLException;

import com.thb.model.RegisterBean;

public interface Authenticate {
 public Boolean authenticateLoginData(String username , String password ) throws SQLException;
 public RegisterBean getUserData(String userName) throws SQLException;
 public String getBookList(String userName , String category) throws SQLException;
}
