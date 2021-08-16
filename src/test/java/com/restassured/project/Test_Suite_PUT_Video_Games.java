package com.restassured.project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test_Suite_PUT_Video_Games extends Setup {
	

	
	// Positive Test Case
	@Test(priority = 6)
	public void test_update_video_game_with_valid_id() {
		
		Map<String, Object> data = new HashMap<>();
		data.put("id", "11");
		data.put("name", "PlayerUnknown's Battlegrounds");
		data.put("releaseDate", "2017-12-20T11:06:23.797Z");
		data.put("reviewScore", "10");
		data.put("category", "Battle royale");
		data.put("rating", "PG-13");
		
		given()
			.header("Accept", "application/json")
			.contentType("application/json")
			.body(data)
		.when()
			.put("/11") //id
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ")
			.header("Content-Type", equalTo("application/json"))
			.log().all();
		
	}
	
	// Negative Test Case
	@Test(priority = 7)
	public void test_update_video_game_with_invalid_id() {
		
		Map<String, Object> data = new HashMap<>();
		data.put("id", "11");
		data.put("name", "PlayerUnknown's Battlegrounds");
		data.put("releaseDate", "2017-12-20T11:06:23.797Z");
		data.put("reviewScore", "10");
		data.put("category", "Battle royale");
		data.put("rating", "PG-13");
		
		Response response = 
			given()
				.header("Accept", "application/json")
				.contentType("application/json")
				.body(data)
			.when()
				.put() // try to update data without sending id
			.then()
				.header("Content-Type", equalTo("application/json;charset=UTF-8"))
				.log().all()
				.extract().response();
		
		Integer statuscode = response.statusCode();
		
		Assert.assertTrue(
				statuscode.equals(400) || 
				statuscode.equals(404) || 
				statuscode.equals(405) || 
				statuscode.equals(500)
				);
		
	}

}
