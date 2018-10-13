package api.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    DateUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static LocalDateTime getFormatedDate(String fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(fecha, formatter);
    }
}
