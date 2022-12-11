package com.challenge.stepdefinitions;

import com.challenge.models.UserData;
import com.challenge.questions.ValidateAlert;
import com.challenge.questions.ValidateText;
import com.challenge.tasks.AddNewRegistry;
import com.challenge.tasks.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.challenge.utilities.csvToUsersDataRegistry.fromCsvToUsersData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;


public class AddRegistryStepDefinitions {

    private final List<UserData> userDataList = fromCsvToUsersData();

    @Given("{string} desea guardar sus datos de usuario")
    public void deseaGuardarSusDatosDeUsuario(String actor) {
        theActorCalled(actor).wasAbleTo(NavigateTo.theDemoQaHomePage());
    }

    @When("el ingresa sus datos de usuario")
    public void elIngresaSusDatosDeUsuario() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaWebTables(),
                AddNewRegistry.withDataUser(userDataList.get(0)));
    }

    @Then("el ve sus datos como una fila en el registro")
    public void veSusDatosComoUnaFilaEnElRegistro() {
            theActorInTheSpotlight().should(
                    seeThat("New registry entered ",
                            ValidateText.textValidated(),
                            containsString(userDataList.get(0).getName()+userDataList.get(0).getLastName())));
    }

    @When("el ingresa sus datos excepto el email")
    public void elIngresaSusDatosDeUsuarioIncompletos() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaWebTables(),
                AddNewRegistry.withDataUser(userDataList.get(1)));
    }

    @Then("el ve un aviso indicando que le falta ingresar el email")
    public void elVeUnAvisoIndicandoCualDatoLeFaltaIngresar() {
        theActorInTheSpotlight().should(
                seeThat("Fiel incompleted is required",
                        ValidateAlert.atributeRequiredValidated(
                                ".form-control.is-invalid, .was-validated .form-control:invalid"))
        );
    }
}
