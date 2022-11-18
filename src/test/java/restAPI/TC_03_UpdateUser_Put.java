package restAPI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_03_UpdateUser_Put {

	Response resp;

	@Test
	public void setupRequest() {

		// {
		// "name": "morpheus",
		// "job": "leader"
		// }

		JSONObject requestBody = new JSONObject();
		requestBody.put("name", "Padma");
		requestBody.put("job", "Sr. Leader");
		requestBody.put("contact", "9999988888");
		System.out.println(requestBody.toJSONString());
		// BaseURI
		RestAssured.baseURI = "https://reqres.in"; // Environment - QA/DEV/STAGE/PROD
		// Request Object
		RequestSpecification httpRequest = RestAssured.given();
		// header
		httpRequest.header("Content-Type", "application/json");
		// parameter
		// auth token
		// body
		httpRequest.body(requestBody);

		// list ------ header, body, authToken
		// Response Object
		resp = httpRequest.request(Method.PUT, "/api/users/2"); // request sent to server
		System.out.println(resp.getBody().asPrettyString());
	}

	// //@Test
	// public void verifyListUserTest() {
	//// System.out.println(resp.asString());
	//// System.out.println(resp.asPrettyString());

	// System.out.println(resp.getContentType()); // application/json; charset=utf-8
	// System.out.println(resp.getHeader("Content-Type")); // application/json;
	// charset=utf-8
	// System.out.println(resp.getStatusCode()); // 200
	// System.out.println(resp.getStatusLine()); // HTTP/1.1 200 OK
	// System.out.println(resp.getTime()); // Response Time
	// System.out.println(resp.getBody().asPrettyString()); // body
	// System.out.println(resp.getHeader("X-Powered-By")); // Express
	//
	// }
	
	@Test
	public void verifyStatusCode() {
		int actualStatusCode = resp.getStatusCode(); // Status Code: 200
		System.out.println("Status Code: " + actualStatusCode);
		Assert.assertEquals(actualStatusCode, 200);
	}

}
