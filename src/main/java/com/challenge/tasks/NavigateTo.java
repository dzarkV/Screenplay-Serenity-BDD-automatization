package com.challenge.tasks;

import com.challenge.userinterfaces.registry.DemoQaHomePage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.challenge.userinterfaces.registry.DemoQaElementsPage.SUB_ELEMENT;
import static com.challenge.userinterfaces.registry.DemoQaHomePage.ELEMENT;

public class NavigateTo {
    public static Performable theDemoQaHomePage() {
        return Task.where("{0} opens the Demo QA home page",
                Open.browserOn().the(DemoQaHomePage.class));
    }

    public static Performable theDemoQaWebTables() {
        return Task.where("{0} navigate to web tables page",
                WaitUntil.the(ELEMENT, WebElementStateMatchers.isCurrentlyVisible()).forNoMoreThan(5).seconds(),
                Click.on(ELEMENT),
                Click.on(SUB_ELEMENT)
        );
    }
}
