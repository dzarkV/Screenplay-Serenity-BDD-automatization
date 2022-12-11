package com.challenge.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.DELETE_NEW_REGISTRY;
import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.NEW_REGISTRY_IN_TABLE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class DeleteRegistry {

    public static Performable withDeleteButton(){
        return Task.where("{0} delete a registry",
                WaitUntil.the(NEW_REGISTRY_IN_TABLE, isCurrentlyVisible()).forNoMoreThan(2).seconds(),
            Click.on(DELETE_NEW_REGISTRY)
        );
    }
}
