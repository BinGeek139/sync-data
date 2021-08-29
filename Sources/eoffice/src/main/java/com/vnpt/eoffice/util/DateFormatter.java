package com.vnpt.eoffice.util;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

    public static String formatSecondsToDate(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsToOnlyDate(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String getDateForNameFile(LocalDate localDate) {
        Date myDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        return  sdf.format(myDate);
    }

    public static Long formatDateToSeconds(LocalDate date, LocalTime localTime) {
        if (date != null) {
            Long seconds = date.toEpochSecond(localTime,
                    ZoneOffset.of(ZonedDateTime.now(ZoneId.systemDefault()).getOffset().toString()));
            return seconds;
        }
        return null;
    }

    public static String formatSecondsToDatehhmmss(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsToDatehhmm(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd-MM-yyyy");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsTohhmmss(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsToddMMyyy(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static boolean checkStringIsLocalTime(String dateStr) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sdf = sdf.withLocale(Locale.getDefault());
        try {
            LocalDate.parse(dateStr, sdf);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static LocalDate formatStringToLocalDate(String dateStr) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sdf = sdf.withLocale(Locale.getDefault());
        return LocalDate.parse(dateStr, sdf);
    }

    public static LocalDate formatSecondToLocalDate(Long date) {
        LocalDate ld = Instant.ofEpochSecond(date).atZone(ZoneId.systemDefault()).toLocalDate();
        return ld;
    }

    public static LocalDateTime formatSecondToLocalDateTime(Long date) {
        LocalDateTime ldt = Instant.ofEpochSecond(date).atZone(ZoneId.systemDefault()).toLocalDateTime();
        return ldt;
    }
    
    public static String formatSecondsToTime(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsTohhmm(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsTohh(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsToOnlyDateMdyyy(Long time) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("M/d/yyyy");
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static String formatSecondsFollowFormat(Long time, String format) {
        if (time != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date myDate = Date.from(Instant.ofEpochSecond(time));
            return sdf.format(myDate);
        }
        return null;
    }

    public static boolean checkStringIsLocalTimeNewFormat(String dateStr) {
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sdf = sdf.withLocale(Locale.getDefault());
        try {
            LocalDate.parse(dateStr, sdf);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
