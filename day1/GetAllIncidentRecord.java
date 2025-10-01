package week3.day1;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class GetAllIncidentRecord {

	public static void main(String[] args) {
		//To given prerequisites
		RestAssured.given()
		           .auth().basic("admin","fNuU8@AL+2qi")
		           .log().all()
		           .when()
		           .get("https://dev299881.service-now.com/api/now/table/incident")
		           .then()
		           .log().all()
		           .assertThat()
		           .statusCode(200);
		           
		

	}

}
