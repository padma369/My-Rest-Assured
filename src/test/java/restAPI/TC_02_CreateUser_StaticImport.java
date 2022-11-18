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

public class TC_02_CreateUser_StaticImport {

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

		baseURI = "https://reqres.in"; // Environment - QA/DEV/STAGE/PROD

		given().header("Content-Type", "application/json").body(requestBody).

				when().post("/api/users").then().

				statusCode(201).statusLine("HTTP/1.1 201 Created").body("name", equalTo("Rupam"))
				.body("job", equalTo("Sr. Leader")).log().all();

	}

}
