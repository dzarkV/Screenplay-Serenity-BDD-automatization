package com.challenge.stepdefinitions;

import com.challenge.exceptions.ExcepcionGeneral;
import com.challenge.models.UserData;
import com.challenge.questions.IsVisibleThe;
import com.challenge.questions.ValidateField;
import com.challenge.questions.ValidateText;
import com.challenge.tasks.AddNewRegistry;
import com.challenge.tasks.DeleteRegistry;
import com.challenge.tasks.NavigateTo;

import com.challenge.utilities.ErrorMessage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.challenge.utilities.WebMenuFromJsonData.fromJsonFileToListString;
import static com.challenge.utilities.CsvToUsersDataRegistry.fromCsvToUsersData;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.containsString;


public class AddRegistryStepDefinition {

    private final List<UserData> userDataList = fromCsvToUsersData();
    private final List<String> webElementsRegistry = fromJsonFileToListString("Flow 1");

    @Given("{string} desea guardar sus datos de usuario en la pagina web")
    public void deseaGuardarSusDatosDeUsuarioEnLaPaginaWeb(String actor) {
        theActorCalled(actor).wasAbleTo(NavigateTo.theDemoQaHomePage());
        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theDemoQaMenu(webElementsRegistry.get(0), webElementsRegistry.get(1)));
    }

    @When("El ingresa sus datos de usuario completos")
    public void elIngresaSusDatosDeUsuarioCompletos() {
        theActorInTheSpotlight().attemptsTo(AddNewRegistry.withDataUser(userDataList.get(0)));
    }

    @Then("El ve sus datos como una fila en el registro")
    public void veSusDatosComoUnaFilaEnElRegistro() {
            theActorInTheSpotlight().should(
                    seeThat("New registry entered ",
                            ValidateText.textInRegistryValidated(),
                            both(containsString(userDataList.get(0).getName()))
                                    .and(containsString(userDataList.get(0).getLastName())))
                            .orComplainWith(ExcepcionGeneral.class, ErrorMessage.MSG_ERROR_COMPARE)
            );

            theActorInTheSpotlight().attemptsTo(DeleteRegistry.withDeleteButton());
    }

    @When("El ingresa sus datos excepto el email")
    public void elIngresaSusDatosDeUsuarioIncompletos() {
        theActorInTheSpotlight().attemptsTo(AddNewRegistry.withDataUser(userDataList.get(1)));
    }

    @Then("El ve un aviso indicando que le falta ingresar el email")
    public void elVeUnAvisoIndicandoQueLeFaltaIngresarElEmail() {
        String red = "rgb(220, 53, 69)";

        theActorInTheSpotlight().should(
                seeThat("Field incompleted is required",
                        ValidateField.colorFieldWhenEmailIsEmpty(),
                        either(equalTo(red))
                                .or(matchesRegex("rgb\\(2[12]\\d, ([4-9]\\d|1[0-7]\\d), ([4-9]\\d|1[0-7]\\d)\\)"))
                ).orComplainWith(ExcepcionGeneral.class, ErrorMessage.MSG_ERROR_COMPARE)
        );
    }

    @When("Ella ingresa sus datos de edad con letras")
    public void ellaIngresaSusDatosDeEdadConLetras() {
        theActorInTheSpotlight().attemptsTo(AddNewRegistry.withDataUser(userDataList.get(2)));
    }

    @Then("Ella ve que no puede continuar con el registro")
    public void ellaVeQueNoPuedeContinuarConElRegistro() {
        theActorInTheSpotlight().should(seeThat("Actor cannot continue with registry",
                IsVisibleThe.submitButton(),
                equalTo(true))
                .orComplainWith(ExcepcionGeneral.class, ErrorMessage.MSG_ERROR_COMPARE)
        );
    }

    @And("sus datos no son guardados")
    public void susDatosNoSonGuardados() {
        theActorInTheSpotlight().should(
                seeThat("New registry is not saved",
                        ValidateText.textInRegistryValidated(),
                        not(containsString(userDataList.get(2).toString())))
        );

    }
}
