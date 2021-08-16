package com.restassured.project;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class Setup {
	
	@BeforeClass
	public void set_up() {
		
		RestAssured.baseURI = "http://localhost:8080/app/videogames";
		
	}

}
