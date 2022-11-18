package restAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_02_CreatUser_StaticImport_DDT {

	Response resp;

	@BeforeTest
	public void setup() {
		System.out.println("==========================");
	}

	@Test(dataProvider = "smokeData")
	public void setupRequest(String ibm_name, String ibm_role) {
		JSONObject requestBody = new JSONObject();
		requestBody.put("name", ibm_name);
		requestBody.put("job", ibm_role);
		baseURI = "https://reqres.in"; // Environment - QA/DEV/STAGE/PROD

		given().header("Content-Type", "application/json").body(requestBody).

				when().post("/api/users").

				then().statusCode(201).statusLine("HTTP/1.1 201 Created").body("name", equalTo(ibm_name))
				.body("job", equalTo(ibm_role)).log().all();

	}

	@DataProvider
	public Object[][] smokeData() {
		Object[][] data = { { "Anjali", "leader" }, { "Apeksha", "leader" }, { "Rupam", "sr.leader" },
				{ "Sudha", "sr.leader" }, { "Swathy", "leader" } };
		return data;

	}

}
