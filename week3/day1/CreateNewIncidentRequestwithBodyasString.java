package week3.day1;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;

public class CreateNewIncidentRequestwithBodyasString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		          
		String requestBody = """
	                         {
	                           "short_description": "RESTAPISEP2025",
	                           "description": "my first post method"
	                         } """;
	

                    given()
                          .baseUri("https://dev299881.service-now.com")
          	              .basePath("api/now/table")
          	              .auth().basic("admin","fNuU8@AL+2qi")
          	              .pathParam("table-name","incident")
          	              .header("Content-Type", "application/json")
                          .log().all()
                    .when()
                           .body(requestBody)
                           .post("/{table-name}")
                     .then()
                           .log().all()
                           .assertThat()
                           .statusCode(201)
                           .statusLine(containsString("Created"))
                           //.contentType(containsString("application/json")); 
                           .contentType(ContentType.JSON)
                           .time(lessThan(5000L));

                           }
                           

	}


