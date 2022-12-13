package com.challenge.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.challenge.userinterfaces.registry.DemoQaElementsPage.SUB_ELEMENT;
import static com.challenge.userinterfaces.registry.DemoQaHomePage.ELEMENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class NavigateTo {

    public static Performable theDemoQaHomePage() {
        return Task.where("{0} opens the Demo QA home page",
                Open.browserOn().thePageNamed("pages.demoqa"));
    }

    public static Performable theDemoQaSubPage(String initialEndpoint, String secondEndpoint) {
        return Task.where("{0} navigates towards the page needed",
                WaitUntil.the(ELEMENT.of(initialEndpoint), isCurrentlyVisible())
                        .forNoMoreThan(2).seconds(),
                Click.on(ELEMENT.of(initialEndpoint)),
                Click.on(SUB_ELEMENT.of(secondEndpoint))
        );
    }
}
