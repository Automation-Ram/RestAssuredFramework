package com.qa.apichaining;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.github.javafaker.Faker;

public class CreateUser {

	@Test

	public void createUserTest(ITestContext itc) {
		Faker fake = new Faker();
		JSONObject data = new JSONObject();
		data.put("name", fake.name().fullName());
		data.put("gender", "Male");
		data.put("email", fake.internet().emailAddress());
		data.put("status", "inactive");

		String bearerToken = "f7db87325652726d68bbf9a3478b95bcf6e5de302e167e946527fa53a11dd8ef";
		int id = given().headers("Authorization", "Bearer " + bearerToken).contentType("application/json")
				.body(data.toString())

				.when().post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");

		System.out.println("Generated ID is : " + id);
		itc.setAttribute("user_id", id);
	}

}
