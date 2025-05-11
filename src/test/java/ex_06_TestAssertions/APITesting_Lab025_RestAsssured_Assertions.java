package ex_06_TestAssertions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class APITesting_Lab025_RestAsssured_Assertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Owner("AkshathaC")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the Create Booking is working fine and booking ID is not null")
    @Test
    public void test_createBooking_post()
    {
        String payload= "{\n" +
                "    \"firstname\" : \"Akshatha\",\n" +
                "    \"lastname\" : \"Chidgal\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

         response =requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse=response.then().log().all();

        //Rest Assured
        validatableResponse.statusCode(200);

        validatableResponse.body("booking.firstname", Matchers.equalTo("Akshatha"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Chidgal"));
        //validatableResponse.body("booking.totalprice",Matchers.equalTo("111"));
        validatableResponse.body("booking.bookingdates.checkin",Matchers.equalTo("2018-01-01"));
        validatableResponse.body("bookingid",Matchers.notNullValue());



    }

}
