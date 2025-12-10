package demo_Oauth;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import pojo.AddPlace;
import pojo.Location;

import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.List;

public class serializeTest {
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
		

		Response res= given().log().all().queryParam("key", "qaclick123").body(P)
		
		.when().post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String reponseString=res.asString();
		System.out.println(reponseString);
		
		
	}
}
