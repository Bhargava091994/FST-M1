package example;

import static io.restassured.RestAssured.given;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Projectgithub {
	private static  RequestSpecification requestSpec; 
	private static int keyId;
	
	@BeforeClass
	public static void setUp() {
		requestSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization","token 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")
				.setBaseUri("https://api.github.com")
				.build();
	}
	
	@Test(priority=1)
	public static void createKeyTest() {
		String reqBody = """
				{
				   "title": "APITestingProjectKey",
				   "key": "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIEewJxEcsetMpSfop7s82q+5mVXs+o2NmfZgTDIwwrvz azuread\\\\aryansharma@IBM-93JWJN3" 
                }
				
				""";			
		Response response = given()
				.spec(requestSpec)
				.body(reqBody)
				.when().post("/user/keys");
		
	    System.out.println("Key Created!");
		
		response.then().assertThat().statusCode(201);
		
		keyId = response.getBody().jsonPath().getInt("id");	
	}
	
	@Test(priority=2)
	public static void getKeyTest() {
		Response response = given()
				.spec(requestSpec)
				.pathParam("keyId",keyId)
				.when().get("/user/keys/{keyId}");	
		
		Reporter.log(response.asPrettyString());	
		response.prettyPrint();
		response.then().assertThat().statusCode(200);
	}
	
	@Test(priority=3)
	public static void deleteKeyTest() {
		Response response = given()
				.spec(requestSpec)
				.pathParam("keyId",keyId)
				.when().delete("/user/keys/{keyId}");
			
		Reporter.log(response.asPrettyString());	
	    System.out.println("Key Deleted!");
		response.then().assertThat().statusCode(204);		
	}
}
