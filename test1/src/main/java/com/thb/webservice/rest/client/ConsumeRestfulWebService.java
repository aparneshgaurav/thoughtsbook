package com.thb.webservice.rest.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ConsumeRestfulWebService {

  public static void main(String[] args) {
	try {

		Client client = Client.create();

		WebResource webResource = client
		   .resource("http://localhost:8080/thoughtsbook/thoughtsbook/register");
		
		
		String input =  "aparnesh";


		ClientResponse response = webResource.accept("text/plain")
				.post(ClientResponse.class, input);

/*
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}*/

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);

	  } catch (Exception e) {

		e.printStackTrace();

	  }

	}
}