package com.eprod.school.utils;


import com.eprod.school.data.Response;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DataUtility {
    public static double roundOff(double value) {
        return (double)Math.round(value * 10.0) / 10.0;
    }

    public static String leftPadWithZeroes(String originalString, int length) {
        String paddedString = originalString;
        while (paddedString.length() < length) {
            paddedString = "0" + paddedString;
        }
        return paddedString;
    }

    public static String leftPadWithZeroes(String originalString) {
        String paddedString = originalString;
        while (paddedString.length() < 5) {
            paddedString = "0" + paddedString;
        }
        return paddedString;
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public static LocalDate convertStringToDate(String dateString){
        return LocalDate.parse(dateString);
    }

    public static Response successResponse(String message){
        return new Response(false, message);
    }


    public static Response errorResponse(String message){
        return new Response(true, message);
    }


    public static int calculateDays(Date from, Date to) {
        LocalDate beginning = (new java.sql.Date(from.getTime())).toLocalDate();
        LocalDate ending = (new java.sql.Date(to.getTime())).toLocalDate();

        return (int) ChronoUnit.DAYS.between(beginning, ending);
    }

    public static int calculateDays(LocalDate from, LocalDate to) {
        return (int) ChronoUnit.DAYS.between(from, to);
    }

}

