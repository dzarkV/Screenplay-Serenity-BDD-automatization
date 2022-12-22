package com.challenge.userinterfaces.dates;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class DemoQaDatesPickerPage extends PageObject {

    private DemoQaDatesPickerPage(){}

    //Select Date input
    public static final Target DATE_INPUT = Target.the("Date picker input")
            .locatedBy("#datePickerMonthYearInput");

    public static final Target DATE_INPUT_MONTH_SELECT = Target.the("Select month")
            .locatedBy(
                    "//select[@class='react-datepicker__month-select']/child::option[text()='{0}']");

    public static final Target DATE_INPUT_YEAR_SELECT = Target.the("Select year")
            .locatedBy(
                    "//select[@class='react-datepicker__year-select']/child::option[text()='{0}']");

    public static final Target DATE_INPUT_DAY_SELECT = Target.the("Select day")
            .locatedBy(
                    "(//div[@role='listbox']/child::div/child::div[text()='{0}'])[1]");

    //Date and time input
    public static final Target DATE_TIME_INPUT = Target.the("Date and time picker input")
            .locatedBy("#dateAndTimePickerInput");

    public static final Target DATE_TIME_MONTH_VIEW = Target.the("View dropdown of month on date and time")
            .locatedBy(".react-datepicker__month-read-view");

    public static final Target DATE_TIME_MONTH_SELECT = Target.the("Select month on date and time")
            .locatedBy(
                    "//div[@class='react-datepicker__month-dropdown']/child::div[text()='{0}']");

    public static final Target DATE_TIME_YEAR_VIEW = Target.the("View dropdown of year on date and time")
            .locatedBy(".react-datepicker__year-read-view");

    public static final Target DATE_TIME_YEAR_SELECT = Target.the("Select year on date and time")
            .locatedBy(
                    "//div[@class='react-datepicker__year-dropdown']/child::div[text()='{0}']");

    public static final Target DATE_TIME_DAY_SELECT = Target.the("Select day on date and time")
            .locatedBy(
                    "(//div[@role='listbox']/child::div/child::div[text()='{0}'])[1]");

    public static final Target DATE_TIME_SELECT = Target.the("Select time on date and time")
            .locatedBy(
                    "//ul[@class='react-datepicker__time-list']/child::li[text()='{0}']");

}
