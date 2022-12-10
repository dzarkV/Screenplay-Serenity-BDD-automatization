package com.challenge.userinterfaces.registry;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DemoQaWebTablesPage extends PageObject {

    public static final Target ADD_BUTTON = Target.the("Add new registry button")
            .locatedBy("//button[@id='addNewRecordButton']");
}
