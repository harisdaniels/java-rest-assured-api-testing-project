package com.restassured.project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


public class Test_Suite_GET_ALL_Video_Games extends Setup {
	

	// Positive Test Case
	@Test(priority = 1)
	public void test_get_all_video_games_with_valid_url() {		
		
		given()
			.header("Accept", "application/json")
		.when()
			.get()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 ")
			.header("Content-Type", equalTo("application/json"))
			.log().body();
		
	}
	
	// Negative Test Case
	@Test(priority = 2)
	public void test_get_all_video_games_with_invalid_url() {
		
		given()
			.header("Accept", "application/json")
		.when()
			.get("http://localhost:8080/app/videogamesSSS")
		.then()
			.statusCode(404)
			.statusLine("HTTP/1.1 404 ")
			.header("Content-Type", equalTo("application/json;charset=UTF-8"))
			.body("error", equalTo("Not Found"))
			.body("message", equalTo("Not Found"))
			.log().all();
		
	}	
	
}
