package example;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {
	
	private static String baseUri = "https://petstore.swagger.io/v2/user";

	  @Test(priority = 1)
	  public void createUser() {
		  
		  File file = new File("src/test/resources/input.json");
		  	  
		  
		  Response response = given()
				  .contentType(ContentType.JSON)
				  .body(file).when().post(baseUri);
		  
		  response.prettyPrint();
		  		    
		  response.then().body("code", equalTo(200));
		  response.then().body("type",equalTo("unknown"));
		  response.then().body("message",equalTo("1001"));
	  }
	  
	  @Test(priority = 2)
	  public void getUser() throws IOException {
		  String username = "justintime";
		  Response response = given()
				  .header("Content-Type", "application/json")
				  .when().pathParam("username", username)
				  .get(baseUri + "/{username}");
		  
		  response.prettyPrint();
		  
		  response.then().statusCode(200);
		  		  
		  response.then().body("id", equalTo(1001));
		  response.then().body("username",equalTo("justintime"));
		  response.then().body("firstName",equalTo("Justin"));
		  response.then().body("lastName",equalTo("Case"));
		  response.then().body("email",equalTo("justincase@mail.com"));
		  response.then().body("password",equalTo("password123"));
		  response.then().body("phone",equalTo("9812763450"));
		  response.then().body("userStatus",equalTo(0));
		  
		  File outputFile = new File("src/test/resources/output.json");		  
		  FileWriter writer = new FileWriter(outputFile);
		  
		  writer.write(response.getBody().asPrettyString());
		  
		  writer.close();
	  }
	  
	  @Test(priority = 3)
	  public void deleteUser() {
		  String username = "justintime";
		  
		  Response response = given()
				  .header("Content-Type", "application/json")
				  .when().pathParam("username", username)
				  .delete(baseUri + "/{username}");
		   
		  response.prettyPrint();
		  
		  response.then().body("code", equalTo(200));
		  response.then().body("message",equalTo("justintime"));
	  }
	}
