package com.challenge.userinterfaces.registry;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.xpath;

public class DemoQaWebTablesPage extends PageObject {

    private DemoQaWebTablesPage(){}

    public static final Target ADD_BUTTON = Target.the("Add new registry button")
            .locatedBy("//button[@id='addNewRecordButton']");

    public static final Target
            NEW_REGISTRY_IN_TABLE = Target.the("Row in web data with new registry")
        .located(xpath("(//div[@role='row'])[5]"));

    public static final Target DELETE_NEW_REGISTRY = Target.the("Delete new registry button")
            .locatedBy("//span[@id='delete-record-4']");

}
