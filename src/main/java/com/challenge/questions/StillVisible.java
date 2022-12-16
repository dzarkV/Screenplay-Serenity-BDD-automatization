package com.challenge.questions;

import com.challenge.userinterfaces.dates.DemoQaDatesPickerPage;
import com.challenge.userinterfaces.registry.DemoQaWebTablesPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.TextValue;


public class StillVisible {

    private StillVisible() {
    }

    public static Question<Boolean> submitButton(){
            return Question.about("Submit button is not let continue")
                .answeredBy(actor -> actor.asksFor(CurrentVisibility.of(DemoQaWebTablesPage.SUBMIT_BUTTON)));
    }

    public static Question<String> dateInScreen(){
        return Question.about("Selected date field is on the screen")
                .answeredBy(actor -> actor.asksFor(TextValue.of(DemoQaDatesPickerPage.DATE_INPUT)));
    }

    public static Question<String> dateAndTimeInScreen(){
        return Question.about("Selected date and time field is on the screen")
                .answeredBy(actor -> actor.asksFor(TextValue.of(DemoQaDatesPickerPage.D_T_INPUT)));
    }
}
