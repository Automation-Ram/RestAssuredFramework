package com.qa.raf;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesTest {

	@Test

	public void testCookies() {
		given().when().get("https://www.google.com").then().statusCode(200).log().all();
	}

	@Test

	public void getCookies() {
		Response res = given()

				.when().get("https://www.google.com");

		String cookie_value = res.getCookie("AEC");
		System.out.println("The Value of Cookie is----->" + cookie_value);
	}

	@Test
	public void getAllCookies() {
		Response res = given()

				.when().get("https://www.google.com");

		Map<String, String> cookies = res.getCookies();

		System.out.println(cookies.keySet());

		for (String k : cookies.keySet()) {
			String cookies_value = res.getCookie(k);
			System.out.println(k + " " + cookies_value);
		}

	}

}
