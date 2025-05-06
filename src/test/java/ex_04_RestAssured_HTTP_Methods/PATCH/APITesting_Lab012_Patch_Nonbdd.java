package ex_04_RestAssured_HTTP_Methods.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab012_Patch_Nonbdd {
    RequestSpecification r; //give
    Response response; //when
    ValidatableResponse vr; //then
    @Test
    public void test_PATCH_Auth_NonBDD() {
//          https://restful-booker.herokuapp.com/auth \
//    "username" : "admin",
//    "password" : "password123"
        String bookingid="1119";
        String token="b8d4f652f3f53a4";
        String payload = "{\n" +
                "    \"firstname\" : \"Anna\",\n" +
                "    \"lastname\" : \"Bond\"\n" +
                "}";

        System.out.println("--Part 1 --");

        // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        //Given

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" +bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload);


        // Making HTTP Request -> Part 2
        System.out.println("--Part 2 --");
        //when
        response=r.when().log().all().patch();

        // Verification Part -> Part 3
        System.out.println("--Part 3 --");
        //then
        vr=response.then().log().all();
        vr.statusCode(200);
    }
}
