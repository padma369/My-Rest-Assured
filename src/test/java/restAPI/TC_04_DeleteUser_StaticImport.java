package restAPI;

import org.json.simple.JSONObject;


import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;




import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_04_DeleteUser_StaticImport {

	Response resp;
	
	@BeforeTest
	public void setup() {
		
		System.out.println("==========================");
	}
	
	
	@Test
	public void setupRequest() {

		JSONObject requestBody = new JSONObject();
		
		requestBody.put("name", "Rupam");
		requestBody.put("job", "Sr. Leader");
		
		baseURI = "https://reqres.in"; 						// Environment - QA/DEV/STAGE/PROD

		
		given().
			header("Content-Type", "application/json").
			//body(requestBody).
			
		when().
			delete("/api/users/2").
			
		then().
			statusCode(204).
			log().all();
		
		

		
	}
	
	

	
}
