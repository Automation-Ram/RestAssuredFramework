package com.qa.raf;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Jsschema {

	@Test
	public void schemaValidator() {
		given()

				.when().get("http://localhost:3000/data")

				.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));

	}

}
