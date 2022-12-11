package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.NEW_REGISTRY_IN_TABLE;

public class ValidateText  {

    public static Question<String> textValidated(){
        return Question.about("If new registry is entered in a new row")
                .answeredBy(TextContent.of(NEW_REGISTRY_IN_TABLE));
    }
}
