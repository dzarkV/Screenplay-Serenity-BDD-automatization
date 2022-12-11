package com.challenge.stepdefinitions;

import com.challenge.models.UserData;
import com.challenge.questions.StillVisible;
import com.challenge.questions.ValidateAlert;
import com.challenge.questions.ValidateText;
import com.challenge.tasks.AddNewRegistry;
import com.challenge.tasks.DeleteRegistry;
import com.challenge.tasks.NavigateTo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.challenge.utilities.csvToUsersDataRegistry.fromCsvToUsersData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;


public class AddRegistryStepDefinitions {

    private final List<UserData> userDataList = fromCsvToUsersData();

    @Given("{string} desea guardar sus datos de usuario")
    public void deseaGuardarSusDatosDeUsuario(String actor) {
        theActorCalled(actor).wasAbleTo(NavigateTo.theDemoQaHomePage());
    }

    @When("el ingresa sus datos de usuario completos")
    public void elIngresaSusDatosDeUsuarioCompletos() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaWebTables(),
                AddNewRegistry.withDataUser(userDataList.get(0)));
    }

    @Then("el ve sus datos como una fila en el registro")
    public void veSusDatosComoUnaFilaEnElRegistro() {
            theActorInTheSpotlight().should(
                    seeThat("New registry entered ",
                            ValidateText.textValidated(),
                            containsString(userDataList.get(0).getName()+
                                    userDataList.get(0).getLastName())));

            theActorInTheSpotlight().attemptsTo(DeleteRegistry.withDeleteButton());
    }

    @When("el ingresa sus datos excepto el email")
    public void elIngresaSusDatosDeUsuarioIncompletos() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaWebTables(),
                AddNewRegistry.withDataUser(userDataList.get(1)));
    }

    @Then("el ve un aviso indicando que le falta ingresar el email")
    public void elVeUnAvisoIndicandoQueLeFaltaIngresarElEmail() {
        theActorInTheSpotlight().should(
                seeThat("Field incompleted is required",
                        ValidateAlert.fieldEmailIsEmpty(),
                        equalTo("rgb(220, 53, 69)"))  // color rojo en rgb
        );
    }

    @When("ella ingresa sus datos de edad con letras")
    public void ellaIngresaSusDatosDeEdadConLetras() {
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaWebTables(),
                AddNewRegistry.withDataUser(userDataList.get(2)));
    }

    @Then("ella ve que no puede continuar con el registro")
    public void ellaVeQueNoPuedeContinuarConElRegistro() {
        theActorInTheSpotlight().should(seeThat("Actor cannnot continue with registry",
                StillVisible.submitButton(),
                equalTo(true))
        );
    }

    @And("sus datos no son guardados")
    public void susDatosNoSonGuardados() {
        theActorInTheSpotlight().should(
                seeThat("New registry is not saved",
                        ValidateText.textValidated(),
                        not(containsString(userDataList.get(2).toString()))));

    }
}
