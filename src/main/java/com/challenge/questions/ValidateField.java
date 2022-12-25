package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CSSValue;

import static com.challenge.userinterfaces.registry.PopupRegistry.EMAIL_FIELD;

public class ValidateField {

    private ValidateField(){}

    public static Question<String> cssColorWhenEmailIsEmpty(){
        return Question.about("If data of email field required is not filled")
                .answeredBy(actor -> actor.asksFor(CSSValue.of(EMAIL_FIELD).named("border-color")));
    }

}
