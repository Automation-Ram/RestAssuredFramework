package com.qa.raf;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderInfo {

	@Test

	public void getHearder() {
		given().when().get("https://www.google.com").then().statusCode(200).log().headers();
	}

	@Test

	public void getHeaders() {
		Response res = given().when().get("https://www.google.com");

		Headers headers = res.getHeaders();
		for (Header h : headers) {
			System.out.println(h.getName() + " " + h.getValue());
		}

	}

}
