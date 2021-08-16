package com.restassured.project;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Test_Suite_DELETE_Video_Games extends Setup {
	
	// Positive Test Case
		@Test(priority = 8)
		public void test_delete_video_game_with_valid_id() {
			
			Response response = 
				given()
					.header("Accept", "application/json")
				.when()
					.delete("/11") //id
				.then()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 ")
					.header("Content-Type", equalTo("application/json"))
					.log().all()
					.extract().response();
				
			String jsonString = response.asString();
			System.out.println(jsonString);

			Assert.assertEquals(jsonString.contains("Record Deleted Successfully"), true);
			
		}
		
		// Negative Test Case
		@Test(priority = 9)
		public void test_delete_video_game_with_invalid_id() {
			
			Response response = 
				given()
					.header("Accept", "application/json")
				.when()
					.delete("/invalidid") //id
				.then()
					.header("Content-Type", equalTo("application/json;charset=UTF-8"))
					.log().all()
					.extract().response();
			
			Integer statuscode = response.statusCode();
			
			Assert.assertTrue(statuscode.equals(404) || statuscode.equals(405));
			
		}

}
