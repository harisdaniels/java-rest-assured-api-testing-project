package com.restassured.project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test_Suite_POST_Video_Games extends Setup {
	
	// Positive Test Case
		@Test(priority = 3)
		public void test_add_new_video_game_with_valid_url() {
			
			Map<String, Object> data = new HashMap<>();
			data.put("id", "11");
			data.put("name", "Point Blank");
			data.put("releaseDate", "2008-10-06T11:06:23.797Z");
			data.put("reviewScore", "8");
			data.put("category", "First-person shooter");
			data.put("rating", "PG-13");
			
			Response response = 
				given()
					.header("Accept", "application/json")
					.contentType("application/json")
					.body(data)
				.when()
					.post()
				.then()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 ")
					.header("Content-Type", equalTo("application/json"))
					.log().all()
					.extract().response();
			
			String jsonString = response.asString();
			
			Assert.assertEquals(jsonString.contains("Record Added Successfully"), true);
			
		}

}
