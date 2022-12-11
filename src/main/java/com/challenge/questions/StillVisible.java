package com.challenge.questions;

import com.challenge.userinterfaces.registry.DemoQaWebTablesPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentlyEnabled;

public class StillVisible {

    public static Question<Boolean> submitButton(){
            return Question.about("Submit button is not let continue")
                .answeredBy(actor -> actor.asksFor(CurrentlyEnabled.of(DemoQaWebTablesPage.SUBMIT_BUTTON)));
    }
}
