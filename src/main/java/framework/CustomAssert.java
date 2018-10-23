package framework;

import framework.utils.LoggerHelper;
import org.testng.Assert;

public class CustomAssert {

    public static void assertFail(String message){
        LoggerHelper.getInstance().error(message);
        Assert.fail(message);
    }
}
