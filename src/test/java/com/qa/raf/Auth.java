package com.qa.raf;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Auth {

	//@Test(priority = 1)

	public void testBasicAuth() {
		given().auth().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	//@Test(priority = 2)

	public void testDigestAuth() {
		given().auth().digest("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	//@Test(priority = 3)

	public void testPreemptiveAuth() {
		given().auth().preemptive().basic("postman", "password")

				.when().get("https://postman-echo.com/basic-auth")

				.then().statusCode(200).body("authenticated", equalTo(true)).log().all();
	}

	@Test(priority = 4)
	public void Autho() {
		String bearerToken ="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";
		given()
		.headers("Authorization", "Bearer" + bearerToken)

				.when().get("https://api.github.com/user/repos")

				.then().statusCode(200).log().all();
	}

}
