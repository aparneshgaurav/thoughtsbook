package com.thb.webservice.rest;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.thb.login.RegisterUser;

@Component
@Path("/register")
public class RegisterUserService {
	@Autowired
	RegisterUser registerUser;
	
	
	
	
	@POST
	@Consumes ("text/plain")
	public Response savePayment(String registrationData)  {
		Boolean bool = false;
		String result = "unregistered";
		try {
//			System.out.println("data is : "+registrationData);
		
			
			// parse the data into usernmae , password  , sex and in urlData
			String[] arrayOfRegistrationDataElements = registrationData.split("aparnesh-gaurav");
			String userName = arrayOfRegistrationDataElements[0];
			String password = arrayOfRegistrationDataElements[1];
			String sex = arrayOfRegistrationDataElements[2];
			String urlData = arrayOfRegistrationDataElements[3];
			
			// persist in the database 
			
			bool = registerUser.register(userName, password, sex , urlData);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bool){
			result = "registered the user successfully";
		}
		else {
			result = "Sorry , registration couldn't be completed ! ";
		}
//		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of the method register user data 
	
	
	
	
	
	
	
	
	@GET
	@Path("attachUserNameWithCategory/{username}/{category}")
	public Response attachUserNameWithCategory(@PathParam("username") String username , @PathParam("category") String category) {
		String result = "attached category";
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@");
		System.out.println("username is : "+username);
		System.out.println("category is : "+category);
		try {
			registerUser.saveCategoryForUserName(username, category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication
	
	@GET
	@Path("attachBookDetailsWithCategoryAndUserName/{username}/{category}/{bookName}/{pageNumber}/{pageContent}")
	public Response attachBookDetailsWithCategoryAndUserName(@PathParam("username") String username , @PathParam("category") String category,
			 @PathParam("bookName") String bookName ,  @PathParam("pageNumber") String pageNumber ,  @PathParam("pageContent") String pageContent) {
		String result = "attached book details ";
		System.out.println("######################");
		System.out.println("username is : "+username);
		System.out.println("category is : "+category);
		try {
			registerUser.saveBookDetails(username, category , bookName , pageNumber , pageContent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("result is "+result);
		return Response.status(200).entity(result).build();
	} // end of method login authentication
	
	
	
}