package framework.utils;

import org.apache.log4j.Logger;

public class LoggerHelper {
    private static LoggerHelper instance;
    private final Logger log = Logger.getLogger(LoggerHelper.class);
    protected static final String END_TEST = "END TEST";
    protected static final String START_TEST = "START TEST";
    protected static final String PASS = "TEST PASS";
    protected static final String FAIL = "TEST FAIL";
    protected static final String STEP_NAME = "====================== %s ======================";
    protected static final String SEPARATOR = "================================================";

    private LoggerHelper(){}

    public static LoggerHelper getInstance(){
        return instance != null ? instance : (instance = new LoggerHelper());
    }

    public void logStep(String stepName, int stepNumber){
        String name = String.format("%s) %s", stepNumber, stepName);
        info(String.format(STEP_NAME, name));
    }

    public void info(String message){
        log.info(message);
    }

    public void error(String message){
        log.error(message);
    }

    public void logFail(){
        log.error(FAIL);
    }

    public void logPass(){
        log.info(PASS);
    }

    public void logEnd(String testName){
        logTestBorder(END_TEST, testName);
    }

    public void logStart(String testName){
        logTestBorder(START_TEST, testName);
    }

    private void logTestBorder(String border, String testName){
        info(SEPARATOR);
        info(String.format(STEP_NAME, border));
        info(String.format(STEP_NAME, testName));
        info(SEPARATOR);
    }
}
