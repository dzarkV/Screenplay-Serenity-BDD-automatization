package com.challenge.userinterfaces.alerts;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementFacadeImpl;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Alert;

import static net.serenitybdd.core.Serenity.getDriver;

public class DemoQaAlertsPage {

    public static final Target TO_SEE_BUTTON = Target.the("FIrt button to see alert")
            .locatedBy("#alertButton");

    public static final Target TIME_TO_APPEAR_BUTTON = Target.the("FIrt button to see alert")
            .locatedBy("#timerAlertButton");

    public static final Target CONFIRM_BUTTON = Target.the("FIrt button to see alert")
            .locatedBy("#confirmButton");

    public static final Target PROMT_BUTTON = Target.the("FIrt button to see alert")
            .locatedBy("#promtButton");

    public static final Target PROMT_RESULT = Target.the("FIrt button to see alert")
            .locatedBy("#promptResult");

}
