package ex_05_TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_Lab019_TestNG_Parameter {

    @Test
    @Parameters("browser")
    public void demo1(String value)
    {
        System.out.println("Hi, I'm a demo function");
        System.out.println("You are running this param");

        if(value.equalsIgnoreCase("firefox"))
        {
            System.out.println("Started the firefox");
        }
        if(value.equalsIgnoreCase("chrome"))
        {
            System.out.println("Start the chrome");
        }
    }
}
