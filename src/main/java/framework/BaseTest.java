package framework;

import framework.selenium.BaseEntity;
import org.testng.annotations.Test;

public abstract class BaseTest extends BaseEntity {

    public abstract void runTest();

    @Test
    public void xTest() throws Throwable {
        Class<? extends BaseTest> currentClass = this.getClass();
        try {
            loggerHelper.logStart(currentClass.getName());
            runTest();
            loggerHelper.getInstance().logEnd(currentClass.getName());
        } catch (Exception | AssertionError e) {
            loggerHelper.error(e.getMessage());
            throw e;
        }
    }
}
