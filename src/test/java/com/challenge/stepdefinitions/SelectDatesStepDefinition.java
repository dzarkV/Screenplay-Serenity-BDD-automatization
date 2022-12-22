package com.challenge.stepdefinitions;

import com.challenge.questions.StillVisible;
import com.challenge.tasks.NavigateTo;
import com.challenge.tasks.SelectNewDate;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.challenge.utilities.StringToLocalDate.fromStringToLocalDate;
import static com.challenge.utilities.StringToLocalDate.fromStringToLocalDatetime;
import static com.challenge.utilities.WebMenuFromJsonData.fromJsonFileToListString;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SelectDatesStepDefinition {

    private final List<String> webElementsDates = fromJsonFileToListString("Flow 2");
    @Given("{string} quiere registrar la fecha de nacimiento en la pagina")
    public void quiereRegistrarLaFechaDeNacimiento(String actor) {
        theActorCalled(actor).wasAbleTo(NavigateTo.theDemoQaHomePage());
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaMenu(webElementsDates.get(0), webElementsDates.get(1)));
    }

    @When("El selecciona la {string}")
    public void elSeleccionaLaFecha(String date) {
        if(date.contains(":")){
            theActorInTheSpotlight().attemptsTo(SelectNewDate.withDateAndTime(fromStringToLocalDatetime(date)));
        } else {
            theActorInTheSpotlight().attemptsTo(SelectNewDate.onlyDate(fromStringToLocalDate(date)));
        }

    }

    @Then("La {string} se muestra en pantalla")
    public void laFechaSeMuestraEnPantalla(String dateEntered) {
        if(dateEntered.contains(":")){
            theActorInTheSpotlight().should(seeThat(
                    StillVisible.dateAndTimeInScreen(),
                    equalTo(dateEntered)
            ));
        } else {
            theActorInTheSpotlight().should(seeThat(
                    StillVisible.dateInScreen(),
                    equalTo(dateEntered)
            ));
        }
    }

}
