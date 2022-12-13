package com.challenge.utilities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDate {

    public static LocalDate fromStringToLocalDate(String dateString){
            return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static LocalDateTime fromStringToLocalDatetime(String dateString){
        return LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}

