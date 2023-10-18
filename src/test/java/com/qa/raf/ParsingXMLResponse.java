package com.qa.raf;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ParsingXMLResponse {

	@Test
	public void parsingXML() {
		given()

				.when().get("http://restapi.adequateshop.com/api/Traveler?page=1")

				.then().statusCode(200)
				// .header("Content-Type", "application/json; charset=utf-8")
				.body("TravelerinformationResponse.page", equalTo("1"))
				.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
	}

	@Test

	public void parse() {
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

		Assert.assertEquals(res.getStatusCode(), 200);
		String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageNo, "1");

		String travelName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name")
				.toString();
		Assert.assertEquals(travelName, "Developer");

	}

	@Test

	public void parsetravellers() {
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=1");

		XmlPath xml = new XmlPath(res.asString());
		List<String> travellers = xml.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travellers.size(), 10);

		List<String> travellers_name = xml.getList("TravelerinformationResponse.travelers.Travelerinformation");
		boolean status = false;
		for (String t : travellers_name) {
			if (t.equals("Developer"))

			{
				status = true;
				break;
			}

		}

	}

}
