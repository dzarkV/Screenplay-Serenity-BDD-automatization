package com.challenge.userinterfaces.dates;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;


public class DemoQaDatesPickerDate extends PageObject {

    private DemoQaDatesPickerDate(){}

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

}
