package week3.day1;

import static io.restassured.RestAssured.*;

public class GetAllIncidentwithAcceptXMLHeader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		given()
		      .baseUri("https://dev299881.service-now.com")
		      .basePath("api/now/table")
		      .header("Accept","application/xml")
		      .auth()
		      .basic("admin", "fNuU8@AL+2qi")
		      .log().all()
	    .when()
	          .get("/incident")
	    .then()
	           .log().all()
	           .assertThat()
	           .statusCode(200);
	                

	}

}
