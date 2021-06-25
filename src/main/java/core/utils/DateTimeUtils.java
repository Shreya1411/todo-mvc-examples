package core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
    public static String dateTime = "";
    public static String dtFormatWithoutDashes="yyyyMMddHHmmssSSS";

    public static String getTimestampWithoutDash() {
        try {
            DateFormat dateFormat = new SimpleDateFormat(dtFormatWithoutDashes);
            Date date = new Date();
            return dateTime = dateFormat.format(date);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
