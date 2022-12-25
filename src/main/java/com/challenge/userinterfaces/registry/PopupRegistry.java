package com.challenge.userinterfaces.registry;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import java.time.Duration;

import static org.openqa.selenium.By.id;

public class PopupRegistry extends PageObject {

    private PopupRegistry(){}

    public static final Target NAME_FIELD = Target.the("Name field form")
            .located(id("firstName"));

    public static final Target LAST_NAME_FIELD = Target.the("Last name field form")
            .located(id("lastName"));

    public static final Target EMAIL_FIELD = Target.the("Email field form")
            .located(id("userEmail")).waitingForNoMoreThan(Duration.ofSeconds(2));

    public static final Target AGE_FIELD = Target.the("Age field form")
            .located(id("age"));

    public static final Target SALARY_FIELD = Target.the("Salary field form")
            .located(id("salary"));

    public static final Target DEPARTMENT_FIELD = Target.the("Deparment field form")
            .located(id("department"));

    public static final Target SUBMIT_BUTTON = Target.the("Submit registry button")
            .located(id("submit"));
}
