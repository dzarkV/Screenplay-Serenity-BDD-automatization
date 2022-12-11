package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CSSValue;

import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.EMAIL_FIELD;

public class ValidateAlert {

    public static Question<String> atributeRequiredValidated(String attribute){
        return Question.about("If a data of a field required not entered")
                .answeredBy(CSSValue.of(EMAIL_FIELD, attribute));
    }
}
