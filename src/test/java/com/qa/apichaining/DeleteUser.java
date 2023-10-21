package com.qa.apichaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	@Test

	public void deleteUserTest(ITestContext itc) {
		int id = (int) itc.getAttribute("user_id");
		String bearerToken = "f7db87325652726d68bbf9a3478b95bcf6e5de302e167e946527fa53a11dd8ef";
		given().headers("Authorization", "Bearer " + bearerToken).pathParam("id", id).when()
				.delete("https://gorest.co.in/public/v2/users/{id}").then().statusCode(204).log().all();

	}

}
