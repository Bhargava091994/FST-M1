package example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
	
	private static String baseUri = "https://petstore.swagger.io/v2/pet";

	  @Test(priority = 1)
	  public void createPet() {
		  
		  String data = """
	               {
	                 "id": 77232,
	                 "name": "Riley",
	                 "status": "alive"
	               }
		  		""";
		  
		  Response response = given().
				  contentType(ContentType.JSON)
				  .body(data).when().post(baseUri);
		  
		  response.then().body("id", equalTo(77232));
		  response.then().body("name",equalTo("Riley"));
		  response.then().body("status",equalTo("alive"));
	  }
	  
	  @Test(priority = 2)
	  public void getPet() {
		  int petId = 77232;
		  
		  Response response = given()
				  .header("Content-Type", "application/json")
				  .when().pathParam("pedtId", petId)
				  .get(baseUri + "/{petId}");
		  
		  response.then().body("id", equalTo(petId));
		  response.then().body("name",equalTo("Riley"));
		  response.then().body("status",equalTo("alive"));
	  }
	  
	  @Test(priority = 3)
	  public void deletePet() {
		  int petId = 77232;
		  
		  Response response = given()
				  .header("Content-Type", "application/json")
				  .when().pathParam("petId", petId)
				  .delete(baseUri + "/{petId}");
		   
		  response.prettyPrint();
		  
		  response.then().body("code", equalTo(200));
		  response.then().body("message", equalTo("77232"));
	  }
	}
