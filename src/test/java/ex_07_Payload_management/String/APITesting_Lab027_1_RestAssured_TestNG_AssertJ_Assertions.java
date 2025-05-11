package ex_07_Payload_management.String;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class APITesting_Lab027_1_RestAssured_TestNG_AssertJ_Assertions {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingID;

    @Owner("AkshathaC")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 - Verify that the Create Booking is working fine and booking ID is not null")
    @Test
    public void test_create_Booking_post() {
        String payload = "{\n" +
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

        response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();

        //Rest Assured
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; %4-%5
        // Matchers.equalto()
        validatableResponse.body("booking.firstname", Matchers.equalTo("Akshatha"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Chidgal"));
        //validatableResponse.body("booking.totalprice",Matchers.equalTo("111"));
        validatableResponse.body("booking.bookingdates.checkin", Matchers.equalTo("2018-01-01"));
        validatableResponse.body("bookingid", Matchers.notNullValue());


        // TestNG - Extract the details of the firstname, bookingId, lastname from Response.
        bookingID=response.then().extract().path("bookingid");
        String firstname=response.then().extract().path("booking.firstname");
        String lastname=response.then().extract().path("booking.lastname");


        // TestNG Assertions - 75%
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        Assert.assertEquals(firstname,"Akshatha");
        Assert.assertEquals(lastname,"Chidgal");
        Assert.assertNotNull(bookingID);


        // AssertJ( 3rd- Lib to Assertions) - 20%
        assertThat(bookingID).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Akshatha").isNotBlank().isNotNull().isAlphanumeric();



    }
}
