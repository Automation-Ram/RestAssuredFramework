package com.qa.raf;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.HashMap;

public class HttpReq {

	@Test(priority = 1)
	public void getUser() {

		given().baseUri("http://localhost:3000")

				.when().get("/employees")

				.prettyPrint();

	}

	@Test
	public void createUser() {
		
		File jsonFile=new File("PostData.json");
		given().baseUri("http://localhost:3000").header("Content-Type", "application/json")
		.body(jsonFile).when().post("/employees")
				.prettyPrint();
	}
	
	@Test
	public void putUser() {
		
		File jsonFile=new File("PostData.json");
		given().baseUri("http://localhost:3000").header("Content-Type", "application/json")
		.body(jsonFile).when().put("/employees/4")
				.prettyPrint();
	}
	
	@Test
	public void deleteUser() {
		
		File jsonFile=new File("PostData.json");
		given().baseUri("http://localhost:3000").header("Content-Type", "application/json")
		.body(jsonFile).when().delete("/employees/4")
				.prettyPrint();
	}

}
