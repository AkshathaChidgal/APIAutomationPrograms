package ex_04_RestAssured_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab011_PUT_NonBDD {
    RequestSpecification r; //give
    Response response; //when
    ValidatableResponse vr; //then
    @Test
    public void test_put_non_bdd_style() {
//          https://restful-booker.herokuapp.com/auth \
//    "username" : "admin",
//    "password" : "password123"
        String bookingid="1337";
        String token="8c6ceddfb8ef695";
        String payload = "{\n" +
                "    \"firstname\": \"Anna\",\n" +
                "    \"lastname\": \"Bond\",\n" +
                "    \"totalprice\": 111,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-01-01\",\n" +
                "        \"checkout\": \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
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
        response=r.when().log().all().put();

        // Verification Part -> Part 3
        System.out.println("--Part 3 --");
        //then
        vr=response.then().log().all();
        vr.statusCode(200);
    }
}
