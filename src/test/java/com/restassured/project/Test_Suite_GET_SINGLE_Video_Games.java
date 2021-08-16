package com.restassured.project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test_Suite_GET_SINGLE_Video_Games extends Setup {
	
	// Positive Test Case
		@Test(priority = 4)
		public void test_get_single_video_game_with_valid_id() {		
			
			given()
				.header("Accept", "application/json")
			.when()
				.get("/11") //id
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 ")
				.header("Content-Type", equalTo("application/json"))
				.body("id", equalTo(11))
				.body("name", equalTo("Point Blank"))
				.body("releaseDate", equalTo("2008-10-06"))
				.body("reviewScore", equalTo(8))
				.body("category", equalTo("First-person shooter"))
				.body("rating", equalTo("PG-13"))
				.log().body();
			
		}
		
		// Negative Test Case
		@Test(priority = 5)
		public void test_get_single_video_game_with_invalid_id() {
			
			Response response = 
				given()
					.header("Accept", "application/json")
				.when()
					.get("/18") //id does not exist
				.then()
					.header("Content-Type", equalTo("application/json;charset=UTF-8"))
					.log().all()
					.extract().response();
			
			Integer statuscode = response.statusCode();
			
			Assert.assertTrue(statuscode.equals(500) || statuscode.equals(404));
			
		}

}
