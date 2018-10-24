package framework.utils;

public class StringUtils {
    private static final String SLASH = "⁄";
    private static final String EMPTY = "";

    public static String replaceAllSlashAndTrim(String value){
        return value.replaceAll(SLASH, EMPTY).trim();
    }
}
