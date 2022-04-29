package FST_Rest_Assured.FST_Rest_Assured;

import org.testng.annotations.Test;

import POJO.PojoTypicode;
import io.restassured.RestAssured;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;	

public class tyicodeClass {
	
	@Test(priority=1)
	public void GETtypicode(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		given().when().get("posts/1").then().log().all().assertThat().statusCode(200)
		.body("userId", equalTo(1));
	}
	
	@Test(priority=2)
	public int POSTtypicode(){
		PojoTypicode ptc = new PojoTypicode("jain", "bodyJain", 1);
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		String reponse  =given().header("Content-type", "application/json; charset=UTF-8").body(ptc).when().post("posts")
		.asString();
		JsonPath js = new JsonPath(reponse);
		Assert.assertEquals(js.get("title"), "jain");
		Assert.assertEquals(js.get("body"), "bodyJain");
		System.out.println("========================================"+js.get("id"));
		return Integer.parseInt(js.get("id").toString());
	}
	
	@Test(priority=3)
	public void PUTtypicode(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		int getId = POSTtypicode();
		System.out.println("==========>>>>>>>>>>>>>>"+getId);
		PojoTypicode ptc = new PojoTypicode("jain11", "bodyJain22", 1,getId );
		given().header("Content-type", "application/json; charset=UTF-8").body(ptc).when().log().all()
		.put("posts/1")
		.then().log().all().assertThat().statusCode(200)
		.body("title", equalTo("jain11"))
		.body("body", equalTo("bodyJain22"));
	}
	
	@Test(priority=4)
	public void DELETEtypicode(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
		given().when().log().all()
		.delete("posts/1")
		.then().log().all().assertThat().statusCode(200);
	}

}
