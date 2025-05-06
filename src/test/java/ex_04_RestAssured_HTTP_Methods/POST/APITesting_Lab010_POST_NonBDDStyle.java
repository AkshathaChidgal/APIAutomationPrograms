package ex_04_RestAssured_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab010_POST_NonBDDStyle {

    RequestSpecification r; //give
    Response response; //when
    ValidatableResponse vr; //then
@Test
    public void test_POST_Auth_NonBDD() {
//          https://restful-booker.herokuapp.com/auth \
//    "username" : "admin",
//    "password" : "password123"

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println("--Part 1 --");

    // Part 1 - Pre Condition - Preparing Request - URL, Headers, Auth...
        //Given
        String pincode="560066";
        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.body(payload);

    // Making HTTP Request -> Part 2
        System.out.println("--Part 2 --");
        //when
        response=r.when().log().all().post();

        // Verification Part -> Part 3
        System.out.println("--Part 3 --");
        //then
        vr=response.then().log().all();
        vr.statusCode(200);
    }
}
