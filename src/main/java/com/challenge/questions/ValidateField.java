package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.CSSValue;

import java.time.Duration;

import static com.challenge.userinterfaces.registry.PopupRegistry.EMAIL_FIELD;

public class ValidateField {

    private ValidateField(){}

    public static Question<String> colorFieldWhenEmailIsEmpty(){
        Ensure.that(EMAIL_FIELD.waitingForNoMoreThan(Duration.ofSeconds(2))).isDisplayed();
        return Question.about("If data of email field required is not filled")
                .answeredBy(actor -> actor.asksFor(CSSValue.of(EMAIL_FIELD).named("border-color")));
    }

}
