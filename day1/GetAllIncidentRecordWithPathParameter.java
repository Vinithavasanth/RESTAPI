package week3.day1;

import static io.restassured.RestAssured.*;

public class GetAllIncidentRecordWithPathParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		given()
		      .baseUri("https://dev299881.service-now.com")
		      .basePath("api/now/table")
		      .auth().basic("admin","fNuU8@AL+2qi")
		      .pathParam("table-name","incident")
		      .log().all()
		.when()
		       .get("/{table-name}")
		.then()
		        .log().all()
		        .assertThat()
		        .statusCode(200);

	}

}
