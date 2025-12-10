package demo_Oauth;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;

import static io.restassured.RestAssured.*;

public class EcommerceAPITest {

	public static void main(String[] args) {
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").setContentType(ContentType.JSON).build();
		LoginRequest loginRequest=new LoginRequest();
		loginRequest.setUserEmail("chandujadhav96k+1204@gmail.com");
		loginRequest.setUserPassword("Hello123@");
		RequestSpecification reqLogin = given().log().all().spec(req).body(loginRequest);
		
		LoginResponse loginResponse = reqLogin.when().post("/api/ecom/auth/login").then().extract().response()
				.as(LoginResponse.class);
		
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getUserId());
		
	}

}
