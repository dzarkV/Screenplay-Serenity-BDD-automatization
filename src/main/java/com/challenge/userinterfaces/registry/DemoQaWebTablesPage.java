package com.challenge.userinterfaces.registry;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class DemoQaWebTablesPage extends PageObject {

    private DemoQaWebTablesPage(){}

    public static final Target ADD_BUTTON = Target.the("Add new registry button")
            .locatedBy("//button[@id='addNewRecordButton']");

    public static final Target NAME_FIELD = Target.the("Name field form")
            .located(id("firstName"));

    public static final Target LAST_NAME_FIELD = Target.the("Last name field form")
            .located(id("lastName"));

    public static final Target EMAIL_FIELD = Target.the("Email field form")
            .located(id("userEmail"));

    public static final Target AGE_FIELD = Target.the("Age field form")
            .located(id("age"));

    public static final Target SALARY_FIELD = Target.the("Salary field form")
            .located(id("salary"));

    public static final Target DEPARTMENT_FIELD = Target.the("Deparment field form")
            .located(id("department"));

    public static final Target SUBMIT_BUTTON = Target.the("Submit registry button")
            .located(id("submit"));

    public static final Target
            NEW_REGISTRY_IN_TABLE = Target.the("Row in web data with new registry")
        .located(xpath("(//div[@role='row'])[5]"));

    public static final Target DELETE_NEW_REGISTRY = Target.the("Delete new registry button")
            .locatedBy("//span[@id='delete-record-4']");

}
