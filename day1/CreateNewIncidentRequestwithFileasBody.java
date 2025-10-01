package week3.day1;

import static org.hamcrest.Matchers.*;

import java.io.File;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class CreateNewIncidentRequestwithFileasBody {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File requestBody = new File ("src/main/resources/request_payload/body.json");
               
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
