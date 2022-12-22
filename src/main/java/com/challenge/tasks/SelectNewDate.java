package com.challenge.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.challenge.userinterfaces.dates.DemoQaDatesPickerPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;


public class SelectNewDate {

    private SelectNewDate(){}

    public static Performable onlyDate(LocalDate date){
        return Task.where("{0} enter a new date",
                WaitUntil.the(DATE_INPUT, isCurrentlyVisible())
                        .forNoMoreThan(2).seconds(),
                Click.on(DATE_INPUT),
                Click.on(DATE_INPUT_MONTH_SELECT.of(date
                        .format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH)))),
                Click.on(DATE_INPUT_YEAR_SELECT.of(String.valueOf(date.getYear()))),
                Click.on(DATE_INPUT_DAY_SELECT.of(Integer.toString(date.getDayOfMonth())))
                );
    }

    public static Performable withDateAndTime(LocalDateTime date){
        return Task.where("{0} enter a date with time",
                WaitUntil.the(DATE_TIME_INPUT, isCurrentlyVisible())
                        .forNoMoreThan(2).seconds(),
                Click.on(DATE_TIME_INPUT),
                Click.on(DATE_TIME_MONTH_VIEW),
                Click.on(DATE_TIME_MONTH_SELECT.of(date
                        .format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH)))),
                Click.on(DATE_TIME_YEAR_VIEW),
                Click.on(DATE_TIME_YEAR_SELECT.of(String.valueOf(date.getYear()))),
                Click.on(DATE_TIME_DAY_SELECT.of(Integer.toString(date.getDayOfMonth()))),
                Click.on(DATE_TIME_SELECT.of(date
                        .format(DateTimeFormatter.ofPattern("HH:mm")))));
    }
}
