package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.TextValue;

import static com.challenge.userinterfaces.dates.DemoQaDatesPickerDate.DATE_INPUT;
import static com.challenge.userinterfaces.dates.DemoQaDatesPickerDateAndTime.DATE_TIME_INPUT;
import static com.challenge.userinterfaces.registry.PopupRegistry.SUBMIT_BUTTON;


public class IsVisibleThe {

    private IsVisibleThe() {
    }

    public static Question<Boolean> submitButton(){
            return Question.about("Submit button is not let continue")
                .answeredBy(actor -> actor.asksFor(CurrentVisibility.of(SUBMIT_BUTTON)));
    }

    public static Question<String> dateInScreen(){
        return Question.about("Selected date field is on the screen")
                .answeredBy(actor -> actor.asksFor(TextValue.of(DATE_INPUT)));
    }

    public static Question<String> dateAndTimeInScreen(){
        return Question.about("Selected date and time field is on the screen")
                .answeredBy(actor -> actor.asksFor(TextValue.of(DATE_TIME_INPUT)));
    }
}
