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

import static com.challenge.utilities.WebElementsJsonData.fromJsonFileToList;
import static com.challenge.utilities.CsvToUsersDataRegistry.fromCsvToUsersData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;


public class AddRegistryStepDefinition {

    private final List<UserData> userDataList = fromCsvToUsersData();
    private final List<String> webElementsRegistry = fromJsonFileToList("Flow 1");

    @Given("{string} desea guardar sus datos de usuario en la pagina web")
    public void deseaGuardarSusDatosDeUsuarioEnLaPaginaWeb(String actor) {
        theActorCalled(actor).wasAbleTo(NavigateTo.theDemoQaHomePage());
        theActorInTheSpotlight().attemptsTo(NavigateTo.theDemoQaSubPage(webElementsRegistry.get(0), webElementsRegistry.get(1)));
    }

    @When("El ingresa sus datos de usuario completos")
    public void elIngresaSusDatosDeUsuarioCompletos() {
        theActorInTheSpotlight().attemptsTo(AddNewRegistry.withDataUser(userDataList.get(0)));
    }

    @Then("El ve sus datos como una fila en el registro")
    public void veSusDatosComoUnaFilaEnElRegistro() {
            theActorInTheSpotlight().should(
                    seeThat("New registry entered ",
                            ValidateText.textValidated(),
                            containsString(userDataList.get(0).getName()+
                                    userDataList.get(0).getLastName())));

            theActorInTheSpotlight().attemptsTo(DeleteRegistry.withDeleteButton());
    }

    @When("El ingresa sus datos excepto el email")
    public void elIngresaSusDatosDeUsuarioIncompletos() {
        theActorInTheSpotlight().attemptsTo(AddNewRegistry.withDataUser(userDataList.get(1)));
    }

    @Then("El ve un aviso indicando que le falta ingresar el email")
    public void elVeUnAvisoIndicandoQueLeFaltaIngresarElEmail() {
        theActorInTheSpotlight().should(
                seeThat("Field incompleted is required",
                        ValidateAlert.fieldEmailIsEmpty(),
                        equalTo("rgb(220, 53, 69)"))  // color rojo en rgb
        );
    }

    @When("Ella ingresa sus datos de edad con letras")
    public void ellaIngresaSusDatosDeEdadConLetras() {
        theActorInTheSpotlight().attemptsTo(AddNewRegistry.withDataUser(userDataList.get(2)));
    }

    @Then("Ella ve que no puede continuar con el registro")
    public void ellaVeQueNoPuedeContinuarConElRegistro() {
        theActorInTheSpotlight().should(seeThat("Actor cannot continue with registry",
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
