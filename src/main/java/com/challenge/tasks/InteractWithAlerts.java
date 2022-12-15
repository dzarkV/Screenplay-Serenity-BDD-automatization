package com.challenge.tasks;


import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;

import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static com.challenge.userinterfaces.alerts.DemoQaAlertsPage.*;
import static net.serenitybdd.core.Serenity.*;

public class InteractWithAlerts {

    public static Performable toSeeAlert(){
        return Task.where("First button to see first alert",
                Ensure.that(TO_SEE_BUTTON).isEnabled(),
                MoveMouse.to(TO_SEE_BUTTON).andThen(Actions::click),
                Switch.toAlert().andAccept()
        );
    }

    public static Performable timeAppearAlert(){
        return Task.where("Second button to wait the alert",
                Ensure.that(TIME_TO_APPEAR_BUTTON).isEnabled(),
                MoveMouse.to(TIME_TO_APPEAR_BUTTON).andThen(Actions::click),
                WaitUntil.the(ExpectedConditions.alertIsPresent()).forNoMoreThan(Duration.ofSeconds(7))
                        .then(Switch.toAlert().andAccept())
        );
    }

    public static Performable confirmBoxAlert(){
        return Task.where("Third button to confirm or cancel the alert",
                Ensure.that(CONFIRM_BUTTON).isEnabled(),
                MoveMouse.to(CONFIRM_BUTTON).andThen(Actions::click),
                Switch.toAlert().andDismiss()
        );
    }

    public static Performable promptAlert(){
        return  Task.where("Fourth button to prompt text in te alert",
                Ensure.that(PROMT_BUTTON).isEnabled(),
                MoveMouse.to(PROMT_BUTTON).andThen(Actions::click)
        );
    }
    public static Performable sendKeysToPrompt(String nick){
        getDriver().switchTo().alert().sendKeys(nick);
        return Task.where("Accept prompt alert before send text", Switch.toAlert().andAccept());
    }
}
