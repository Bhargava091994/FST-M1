package example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3 {
	private static	RequestSpecification requestSpec;
	 private static	ResponseSpecification responseSpec;
		
	 private static String baseUri = "https://petstore.swagger.io/v2/pet";
	 
	 @BeforeClass
	 public void setUp() {
		 requestSpec = new RequestSpecBuilder()
				 .setContentType(ContentType.JSON)
				 .setBaseUri(baseUri).build();
		 
		 responseSpec = new ResponseSpecBuilder()
				 .expectStatusCode(200)
				 .expectContentType(ContentType.JSON)
				 .expectBody("status", equalTo("alive"))
				 .build();	 
	 }
	 
	 @DataProvider(name="petInfo")
	 public Object[][] petInfoProvider(){
		  Object[][] testData = new Object[][] { 
			    { 1001, "Riley", "alive" }, 
			    { 1002, "Hansel", "alive" } 
			};
			
			return testData;
	 }

	  @Test(priority = 1, dataProvider="petInfo")
	  public void createPet(int petId, String petName, String status) {
		
			Map<String, Object> reqBody = new HashMap<>();
			reqBody.put("id", petId);
			reqBody.put("name", petName);
			reqBody.put("status", status);
		  
		  Response response = given()
				  .spec(requestSpec)
				  .body(reqBody)
				  .when().post();
		  	  
		  response.then()
		  .spec(responseSpec)
		  .body(
				  "id", equalTo(petId),
		          "name",equalTo(petName));
	  }
	    
	  @Test(priority = 2, dataProvider="petInfo")
	  public void getPet(int petId, String petName, String status) {
		  
		  Response response = given()
				  .spec(requestSpec)
				  .pathParam("petId", petId)
				  .log().all()
				  .when()
				  .get("/{petId}");
		  
	  
		  response.then()
		  .spec(responseSpec)
		  .body(
				  "id", equalTo(petId),
		          "name",equalTo(petName),
		          "status",equalTo(status)
		          );
	  }
	  
	  @Test(priority = 3, dataProvider = "petInfo")
	  public void deletePet(int petId, String petName, String status) {

	      Response response = given()
	              .spec(requestSpec)
	              .pathParam("petId", petId)
	              .when()
	              .delete("/{petId}");

	      response.prettyPrint();

	      response.then()
	              .body(
	                      "code", equalTo(200),
	                      "message", equalTo(String.valueOf(petId))
	              );
	  }
	}
