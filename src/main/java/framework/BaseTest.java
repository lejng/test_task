package framework;

import framework.selenium.BaseEntity;
import org.testng.annotations.Test;

public abstract class BaseTest extends BaseEntity {

    public abstract void runTest();

    @Test
    public void xTest() throws Throwable {
        Class<? extends BaseTest> currentClass = this.getClass();
        loggerHelper.logStart(currentClass.getName());
        try {
            runTest();
            loggerHelper.logPass();
        } catch (Exception | AssertionError e) {
            loggerHelper.error(e.getMessage());
            loggerHelper.logFail();
            throw e;
        }finally {
            loggerHelper.logEnd(currentClass.getName());
        }
    }
}
