package com.challenge.userinterfaces.registry;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demoqa.com/")
public class DemoQaHomePage extends PageObject {

    public static final Target ELEMENT = Target.the("First section")
            .locatedBy("//div[@class='category-cards']" +
                    "//child::*//descendant::*[text()='Elements']");

}
