package ex_04_RestAssured_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_Lab008_NonBDDStyle {

    RequestSpecification r; //give
    Response response; //when
    ValidatableResponse vr; //then
    @Test
    public void test_GET_Postive_NonBDD()
    {   //Given
        String pincode="560066";
        r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //when
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then
        vr=response.then().log().all();
        vr.statusCode(200);


    }
    @Test
    public void test_GET_Negative_NonBDD()
    {   //Given
        String pincode="@*";
        r=RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //when
        response=r.when().log().all().get();
        System.out.println(response.asString());

        //then
        vr=response.then().log().all();
        vr.statusCode(200);


    }

}
