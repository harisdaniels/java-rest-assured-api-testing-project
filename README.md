# This Is My Self-Mini Project of API Testing Using REST-Assured

## Project Information
For this project, i use: 
- Java Programming Language (https://www.oracle.com/java/)
- REST-Assured (https://rest-assured.io/)
- TestNG (https://testng.org/doc/)
- Eclipse IDE (https://www.eclipse.org/ide/)
- API (https://github.com/james-willett/VideoGameDB)

### Java Programming Language
Java is the #1 programming language and development platform. It reduces costs, shortens development timeframes, drives innovation, and improves application services. 
With millions of developers running more than 51 billion Java Virtual Machines worldwide, Java continues to be the development platform of choice for enterprises and developers.

### REST-Assured
Testing and validating REST services in Java is harder than in dynamic languages such as Ruby and Groovy. 
REST Assured brings the simplicity of using these languages into the Java domain.

### TestNG
TestNG is a testing framework inspired from JUnit and NUnit but introducing some new functionalities that make it more powerful and easier to use

### Eclipse IDE
The Eclipse IDE is famous for our Java Integrated Development Environment (IDE), but we have a number of pretty cool IDEs, including our C/C++ IDE, JavaScript/TypeScript IDE, PHP IDE, and more.
You can easily combine multiple languages support and other features into any of our default packages, and the Eclipse Marketplace allows for virtually unlimited customization and extension.

## Preparation

### Run the Application Server
- Go to https://github.com/james-willett/VideoGameDB
- Download application as ZIP file 
   
  ![Screenshot_1](https://user-images.githubusercontent.com/74105380/128622269-dcf68035-67d1-437a-8b56-e99add298449.jpg)


-  Extract the ZIP file
-  Double-click file named `VideoGameDB-master`
-  Type `cmd` and then press `Enter`

   ![Screenshot_2](https://user-images.githubusercontent.com/74105380/128622369-fb508025-647e-4273-9f1f-a945d530aac6.jpg)
   
- Then, type `mvn spring-boot:run` and press `Enter`. (But, make sure you have Apache Maven [downloaded and installed](https://maven.apache.org/download.cgi) and setup [MAVEN_HOME system variable](https://mkyong.com/maven/how-to-install-maven-in-windows/) )
  
  ![Screenshot_3](https://user-images.githubusercontent.com/74105380/128622607-3e84f970-292b-4604-896b-2d5f6a0bafae.jpg)

- When the application is running, open a browser and go to http://localhost:8080/swagger-ui/index.html#/ to explore the API endpoints

![Screenshot_4](https://user-images.githubusercontent.com/74105380/128622711-d6386251-9fec-430a-9157-201203cf716d.jpg)

## Project Setup
### Clone Repo
- Clone from this repo https://github.com/harisdaniels/rest-assured-api-testing-project.git.
- The steps of cloning Github Repository to your Eclipse IDE can be found [here](https://www.youtube.com/watch?v=z8BKGUxFdM4).

## Test Structure
- Use `@BeforeClass` The annotated method will be run before the first test method in the current class is invoked.
- Use `@Test(priority = 1)` Marks a class or a method as part of the test. The priority for this test method. Lower priorities will be scheduled first.
  Full explanation can be found [here](https://testng.org/doc/documentation-main.html#test-methods)
- `given()`, `when()`, `then()` are part of RestAssured Syntax. Full explanation can be found [here](https://www.javadoc.io/doc/io.rest-assured/rest-assured/latest/io/restassured/RestAssured.html)

- Example:

```
public class Setup {
	
	@BeforeClass
	public void set_up() {
		
		RestAssured.baseURI = "http://localhost:8080/app/videogames";
		
	}

}
```

```
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
	
}
```

## Run Test

In order to run your test and generating TestNG Report at once, you can hover your cursor to `testng.xml` file, then right-click, click `Run As TestNG Suite`.
![Screenshot_5](https://user-images.githubusercontent.com/74105380/128624014-7b5c78c8-869f-417a-a944-c35aee57a973.jpg)



## Test Report by TestNG
After run the test, you can also see the result of the test by double-clicking the `index.html` file that stored inside the `test-output` folder.
![Screenshot_10](https://user-images.githubusercontent.com/74105380/128624249-f9a2b853-2ecf-4f66-9720-096b6d54c1b5.jpg)
> If `test-output` folder does not appear, right-click on the project and click `refresh`.


### Test Report Sample
![Screenshot_4](https://user-images.githubusercontent.com/74105380/129662415-13b182b6-a54f-472c-9f95-b7e253cfc8cf.jpg)
The result will be like this.


# All is Done!
