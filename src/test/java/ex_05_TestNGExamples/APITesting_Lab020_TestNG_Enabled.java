package ex_05_TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting_Lab020_TestNG_Enabled {

    @Test
    public void test01()
    {
        System.out.println("Test1");
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void test02()
    {
        System.out.println("Test2");
        Assert.assertTrue(true);
    }
    @Test
    public void test03()
    {
        System.out.println("Test3");
        Assert.assertTrue(true);
    }
}
