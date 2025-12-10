package demo_Oauth;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.List;

public class SpecBuilderTest {
	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		AddPlace P = new AddPlace();
		P.setAccuracy(50);
		P.setAddress("29, side layout, cohen 09");
		P.setLanguage("French-IN");
		P.setPhone_number("(+91) 983 893 3937");
		P.setWebsite("http://chandujadhav.com");
		P.setName("Frontline house");

		List<String> myList = new ArrayList<>();
		myList.add("shoe park");
		myList.add("shop");

		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		P.setLocation(l);
		
		
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		
		ResponseSpecification respec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        RequestSpecification res=given().spec(req)
        .body(P);
		
        Response response =res.when().post("/maps/api/place/add/json")
		.then().spec(respec).extract().response();
		
		String reponseString=response.asString();
		System.out.println(reponseString);
		
		
	}
}
