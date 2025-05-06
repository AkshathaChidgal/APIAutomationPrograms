package ex_04_RestAssured_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab0013_DeleteNonBDD {
    RequestSpecification r; //give
    Response response; //when
    ValidatableResponse vr; //then
    @Test
    public void test_delete_Auth_NonBDD() {

        String bookingid="3852";
        String token="b8d4f652f3f53a4";

        r= RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/" +bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        response=r.when().log().all().delete();

        vr=response.then().log().all();
        vr.statusCode(201);
    }
}
