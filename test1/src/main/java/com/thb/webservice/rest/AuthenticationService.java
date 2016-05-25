package com.thb.webservice.rest;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.thb.login.Authenticate;
import com.thb.model.RegisterBean;

@Component
@Path("/login")
public class AuthenticationService {
	@Autowired
	Authenticate  authenticate;
	RegisterBean registerBean;
	
	
	
	@GET
	@Path("{username}/{password}")
	public Response savePayment(@PathParam("username") String username,@PathParam("password") String password) {
		Boolean bool = false;
		String result = "unauthenticated";
		try {
			System.out.println(username);
			System.out.println(password);
			bool = authenticate.authenticateLoginData(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "authenticated";
		}
		else {
			result = "unauthenticated";
		}
//		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication
	
	
	
	@GET
	@Path("getUserData/{username}")
	public Response getUserData(@PathParam("username") String username) {
		String result = "unauthenticated";
		try {
			System.out.println(username);
			 registerBean = authenticate.getUserData(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(registerBean==null){
			result = "Sorry , some issues in retrieving the user data !";
		}
		else {
			result = registerBean.getUrlData();
		}
//		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication
	
	
	@GET
	@Path("getBookListForUserAndCategory/{username}")
	public Response getBookListForUserAndCategory(@PathParam("username") String username , @PathParam("category") String category) {
		String result = "book list fetched !";
		try {
			String bookList = authenticate.getBookList(username,category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(result).build();
	} // end of method login authentication
	
}