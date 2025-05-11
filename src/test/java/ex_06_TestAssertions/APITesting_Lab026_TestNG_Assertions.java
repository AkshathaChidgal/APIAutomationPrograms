package ex_06_TestAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_Lab026_TestNG_Assertions {

    //Hard Assertion
    @Test
    public void test_hard_AssertionExample()
    {
        System.out.println("Start of the program");
        Boolean is_good=false;
        Assert.assertEquals("akshatha","Akshatha");
        System.out.println("End of the program, this will not run if above statement fails");
    }


    //Soft Assertion
@Test
    public void test_soft_AssertionExample()
    {
        SoftAssert softAssert = new SoftAssert();
        System.out.println("Start of the program");
        Boolean is_good=false;
        softAssert.assertEquals("akshatha","Akshatha");
        System.out.println("End of the program, this will not run if above statement fails");
        softAssert.assertAll();  //This means assert all of them
    }
}


