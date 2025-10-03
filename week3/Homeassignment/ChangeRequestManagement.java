package week3.Homeassignment;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Response;

public class ChangeRequestManagement {

	public static void createChangeRequest() {
		
		
		baseURI="https://dev299881.service-now.com";
    	authentication=basic("admin","fNuU8@AL+2qi");
		
    	String requestPayload = """
				{
				"short_description": "Test Change Request",
				"description": "Created via RestAssured"
				 }""";
    	        
    	Response response = given().contentType(ContentType.JSON).body(requestPayload)
				.post("/api/now/table/change_request");

		// Print response to console
		       System.out.println("Create Change Request Response: ");
		       response.prettyPrint();
		    }
	public static void main(String[] args) {

		createChangeRequest();

	}

	}


