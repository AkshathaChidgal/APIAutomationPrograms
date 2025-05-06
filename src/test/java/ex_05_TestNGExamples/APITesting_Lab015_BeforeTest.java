package ex_05_TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting_Lab015_BeforeTest {

    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void getToken()
    {
        System.out.println("Before GET token");
    }
    @BeforeTest
    public void getBookingId()
    {
        System.out.println("Before GET BookingId");
    }

    @Test
    public void test_PUT()
    {
        System.out.println("Test the PUT request");
    }

    @AfterTest
    public void closeAllThings()
    {
        System.out.println("Close all things");
    }


}
