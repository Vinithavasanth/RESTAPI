package week3.Homeassignment;

import static org.hamcrest.Matchers.*;

import java.io.File;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class CreateChangeRequestwithFileasBody {
	
    @Test
    public static void createChangeRequest() {
    	
    	baseURI="https://dev299881.service-now.com";
    	basePath="api/now/table/";
    	authentication=basic("admin","fNuU8@AL+2qi");
    	
    	File jsonFile =new File ("src\\main\\resources\\request_payload\\changerequest.json");
    	Response response = given().pathParam("tableName", "change_request").contentType(ContentType.JSON)
				.body(jsonFile).post("{tableName}");
    	
    	System.out.println("POST status code is " + response.getStatusCode());
	   
	       response.then().assertThat().statusCode(201).statusLine(containsString("Created"));
	       response.prettyPrint();      
	          
	       

	}

}
