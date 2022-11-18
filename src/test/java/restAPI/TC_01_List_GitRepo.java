package restAPI;

import org.json.simple.JSONObject;
import org.junit.internal.runners.statements.Fail;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_01_List_GitRepo {
	Response resp;

	@BeforeTest

	public void setup() {
		System.out.println("==========================");
	}

	// @Test

	// public void setupRequest() {
	// JSONObject requestBody = new JSONObject();
	// requestBody.put("name", "");
	// //https://api.github.com/user/repos
	// baseURI = "https://api.github.com"; // Environment - QA/DEV/STAGE/PROD
	//
	// given().
	// header("Content-Type", "application/json").
	// //body(requestBody).
	//
	// when().
	// get("/user/repos").
	//
	// then().
	// statusCode(200).
	// //body("name", equalTo("Rupam")).
	// //body("job", equalTo("Leader")).
	// log().all();
	// }

	// with this code we will get 401 status code error: auth error related to
	// server.
	// so we need to create a token from git repository from settings. then we have
	// to give that path here.

	@Test
	public void setupRequest() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "TestingRepo");
		// https://api.github.com/user/repos
		// baseURI = "https://api.github.com"; // Environment - QA/DEV/STAGE/PROD

		given().header("Content-Type", "application/json").auth().oauth2("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")
				.body(requestBody).when().post("https://api.github.com/user/repos").

				then().statusCode(201).
				// body("name", equalTo("Rupam")).
				// body("job", equalTo("Leader")).
				log().all();
		
		//with this coe, one repository is created. and we got the count of the repositories as well.
	//	if we run this program again, it will Fail.class bcoz repository is already created with the psecified name. if we want we can change the name to create e new repository.

	}

}
