package com.challenge.stepdefinitions;

import com.challenge.questions.ValidateText;
import com.challenge.tasks.InteractWithAlerts;
import com.challenge.tasks.NavigateTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.challenge.utilities.WebElementsJsonData.fromJsonFileToListString;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;

public class InteractAlertsStepDefinition {

    private final List<String> webElementsAlerts = fromJsonFileToListString("Flow 3");
    @Given("{string} quiere ver su apodo en pantalla")
    public void quiereVerSuApodoEnPantalla(String actor) {
        theActorCalled(actor).wasAbleTo(NavigateTo.theDemoQaHomePage());
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaSubPage(webElementsAlerts.get(0), webElementsAlerts.get(1)));
    }

    @When("El recorre las alertas en la pagina")
    public void elRecorreLasAlertasEnLaPagina() {
        theActorInTheSpotlight().attemptsTo(InteractWithAlerts.toSeeAlert()
                        .then(InteractWithAlerts.timeAppearAlert()
                                .then(InteractWithAlerts.confirmBoxAlert()))
        );
    }

    @And("Ingresa su {string}")
    public void ingresaSu(String nicknameSended) {
        theActorInTheSpotlight().attemptsTo(InteractWithAlerts.promptAlert());
        withCurrentActor(InteractWithAlerts.sendKeysToPrompt(nicknameSended));
    }

    @Then("Su {string} se muestra en pantalla")
    public void suSeMuestraEnPantalla(String nicknameChecked) {
        theActorInTheSpotlight().should(
                seeThat(ValidateText.fieldRetrieveInPromptAlert(),
                        containsString(nicknameChecked)));
    }
}
