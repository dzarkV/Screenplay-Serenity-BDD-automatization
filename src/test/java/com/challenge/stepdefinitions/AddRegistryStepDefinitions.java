package com.challenge.stepdefinitions;

import com.challenge.models.UserData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static com.challenge.hooks.csvToUsersDataRegistry.fromCsvToUsersData;

public class AddRegistryStepDefinitions {
    @Given("{string} desea guardar sus datos de usuario")
    public void deseaGuardarSusDatosDeUsuario(String actor) {
        System.out.println("Preparando al " + actor);
    }

    @When("el ingresa sus datos de usuario")
    public void elIngresaSusDatosDeUsuario() {
        List<UserData> userData = fromCsvToUsersData();
        System.out.println("Data table es:");
        System.out.println(userData.get(0).getName());
    }

    @Then("el ve sus datos como una fila en el registro")
    public void veSusDatosComoUnaFilaEnElRegistro() {
        System.out.println("ya");
    }
}
