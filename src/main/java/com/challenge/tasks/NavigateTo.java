package com.challenge.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.challenge.userinterfaces.DemoQaMenuPage.SUB_MENU;
import static com.challenge.userinterfaces.DemoQaHomePage.INITIAL_MENU;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class NavigateTo {

    private NavigateTo(){}

    public static Performable theDemoQaHomePage() {
        return Task.where("{0} opens the Demo QA home page",
                Open.browserOn().thePageNamed("pages.demoqa"));
    }

    public static Performable theDemoQaMenu(String initialEndpoint, String secondEndpoint) {
        return Task.where("{0} navigates towards the page needed",
                Scroll.to(INITIAL_MENU.of(initialEndpoint)),
                WaitUntil.the(INITIAL_MENU.of(initialEndpoint), isClickable())
                        .forNoMoreThan(2).seconds(),
                Click.on(INITIAL_MENU.of(initialEndpoint)),
                Scroll.to(SUB_MENU.of(secondEndpoint)),
                WaitUntil.the(SUB_MENU.of(secondEndpoint), isClickable())
                        .forNoMoreThan(2).seconds(),
                Click.on(SUB_MENU.of(secondEndpoint))
        );
    }
}
