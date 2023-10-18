package com.qa.raf;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ParsingJsonResponseData {

	@Test

	public void testParseJSONData() {
		given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2").then().statusCode(200)
				.header("Content-Type", "application/json; charset=utf-8").body("data[5].last_name", equalTo("Howell"));

	}

	@Test
	public void validateParseJSONData() {
		Response res = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		String name = res.jsonPath().get("data[5].last_name").toString();
		Assert.assertEquals(name, "Howell");

	}

	@Test
	public void validateallJson() {
		Response res = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users?page=2");

		JSONObject jo = new JSONObject(res.toString());
		for (int i = 0; i < jo.getJSONArray("data").length(); i++) {
			String emailData = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(emailData);
		}

	}

}
