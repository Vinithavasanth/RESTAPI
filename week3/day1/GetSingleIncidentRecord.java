package week3.day1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetSingleIncidentRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	given()
	      .baseUri("https://dev299881.service-now.com")
	      .basePath("api/now/table")
	      .auth().basic("admin","fNuU8@AL+2qi")
	      .pathParam("table-name","incident")
	      .pathParam("sys_id", "1c741bd70b2322007518478d83673af3")
	      .log().all()
	.when()
	       .get("/{table-name}/{sys_id}")
	.then()
	        .log().all()
	        .assertThat()
	        .statusCode(200)
	        .body("result.sys_id", equalTo("1c741bd70b2322007518478d83673af3"));

	}

}
