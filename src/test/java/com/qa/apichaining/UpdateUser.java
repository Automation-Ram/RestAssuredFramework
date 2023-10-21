package com.qa.apichaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	@Test

	public void updateUserTest(ITestContext itc) {
		Faker fake = new Faker();
		JSONObject data = new JSONObject();
		data.put("name", fake.name().fullName());
		data.put("gender", "Female");
		data.put("email", fake.internet().emailAddress());
		data.put("status", "active");

		String bearerToken = "f7db87325652726d68bbf9a3478b95bcf6e5de302e167e946527fa53a11dd8ef";
		int id=(int) itc.getAttribute("user_id");
		given().headers("Authorization", "Bearer " + bearerToken).contentType("application/json").pathParam("id", id)
				.body(data.toString())

				.when().put("https://gorest.co.in/public/v2/users/{id}").then().statusCode(200).log().all();

	}

}
