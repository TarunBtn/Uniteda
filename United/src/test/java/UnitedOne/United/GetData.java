package UnitedOne.United;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void testResponsecode() {
		
		Response resp=RestAssured.get("https://rahulshettyacademy.com/maps/api/place/get/json?key=qaclick123&place_id=246c793922866c26b389052697b58ec6");
		
		int code=resp.getStatusCode();
		
		System.out.println("Status code is: "+code);
		
		Assert.assertEquals(code, 400);
		
	}

}
