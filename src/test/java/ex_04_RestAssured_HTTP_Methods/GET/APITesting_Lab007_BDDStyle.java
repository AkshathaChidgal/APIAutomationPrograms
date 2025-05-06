package ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_Lab007_BDDStyle {
    @Test
    public void test_GET_Positive()
    {
        String pincode ="574232";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                     .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all().statusCode(200);
    }
}
