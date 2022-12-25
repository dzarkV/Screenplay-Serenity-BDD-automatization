package com.challenge.userinterfaces.alerts;

import net.serenitybdd.screenplay.targets.Target;


public class DemoQaAlertsPage {

    private DemoQaAlertsPage(){}

    public static final Target TO_SEE_BUTTON = Target.the("First button to see alert")
            .locatedBy("#alertButton");

    public static final Target TIME_TO_APPEAR_BUTTON = Target.the("Button to see time delayed alert")
            .locatedBy("#timerAlertButton");

    public static final Target CONFIRM_BUTTON = Target.the("Button to see confirm alert")
            .locatedBy("#confirmButton");

    public static final Target PROMT_BUTTON = Target.the("Button to deploy prompt alert")
            .locatedBy("#promtButton");

    public static final Target PROMT_RESULT = Target.the("Field with text entered in prompt alert")
            .locatedBy("#promptResult");

}
