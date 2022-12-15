package com.challenge.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

import static com.challenge.userinterfaces.alerts.DemoQaAlertsPage.PROMT_RESULT;
import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.NEW_REGISTRY_IN_TABLE;

public class ValidateText  {

    public static Question<String> textInRegistryValidated(){
        return Question.about("If new registry is entered in a new row")
                .answeredBy(actor -> actor.asksFor(TextContent.of(NEW_REGISTRY_IN_TABLE)));
    }

    public static Question<String> fieldRetrieveInPromptAlert(){
        return Question.about("If data send to prompt alert is the same that sended")
                .answeredBy(actor -> actor.asksFor(TextContent.of(PROMT_RESULT)));
    }
}
