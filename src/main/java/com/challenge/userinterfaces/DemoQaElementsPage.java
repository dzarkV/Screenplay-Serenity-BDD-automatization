package com.challenge.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DemoQaElementsPage extends PageObject {

    public static final Target SUB_ELEMENT = Target.the("Subsection of element")
            .locatedBy("//span[normalize-space()='{0}']");

}
