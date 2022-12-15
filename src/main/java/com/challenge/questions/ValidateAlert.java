package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CSSValue;

import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.EMAIL_FIELD;

public class ValidateAlert {

    public static Question<String> fieldEmailIsEmpty(){
        return Question.about("If data of email field required is not filled")
                .answeredBy(actor -> actor.asksFor(CSSValue.of(EMAIL_FIELD).named("border-color")));
    }

}
