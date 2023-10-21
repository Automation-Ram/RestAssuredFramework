package com.qa.apichaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GetUser {


	@Test

	public void getUserTest(ITestContext itc) {
		int id=(int) itc.getAttribute("user_id");
		String bearerToken = "f7db87325652726d68bbf9a3478b95bcf6e5de302e167e946527fa53a11dd8ef";
		given().headers("Authorization", "Bearer " + bearerToken)
		.pathParam("id", id)
		.when().get("https://gorest.co.in/public/v2/users/{id}")
		.then().statusCode(200).log().all();

	}


}
