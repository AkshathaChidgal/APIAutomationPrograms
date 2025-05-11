package ex_07_Payload_management.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.codehaus.groovy.util.ListHashMap;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_Lab028_RestAssured_Payload_Map {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Test
    public void test_POST()
    {

        //Hashmap -> Key and Value pair
        Map<String,Object> jsonBodyUsingMap = new LinkedHashMap<>();
        jsonBodyUsingMap.put("firstname","Akshatha");
        jsonBodyUsingMap.put("lastname","Chidgal");
        jsonBodyUsingMap.put("totalprice","111");
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
        jsonBodyUsingMap.put("additonalneeds","Breakfast");
        System.out.println(jsonBodyUsingMap);


        //Hashmap->json

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();



    }

}
