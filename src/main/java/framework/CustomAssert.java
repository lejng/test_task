package framework;

import framework.utils.LoggerHelper;
import org.testng.Assert;

public class CustomAssert {

    public static void assertFail(String message){
        LoggerHelper.getInstance().error(message);
        Assert.fail(message);
    }

    public static void assertTrue(boolean condition, String message){
        if(!condition){
            LoggerHelper.getInstance().error(message);
        }
        Assert.assertTrue(condition, message);
    }

    public static void assertEquals(Object actual, Object expected, String message){
        if(!actual.equals(expected)){
            LoggerHelper.getInstance().error(message);
        }
        Assert.assertEquals(actual, expected, message);
    }
}
