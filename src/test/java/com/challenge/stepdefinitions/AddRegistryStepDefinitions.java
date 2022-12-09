package com.challenge.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddRegistryStepDefinitions {
    @Given("{string} desea guardar sus datos de usuario")
    public void deseaGuardarSusDatosDeUsuario(String actor) {
        System.out.println("Preparando al " + actor);
    }

    @When("el ingresa sus datos {string} {string} {string} {string} {string} y {string}")
    public void ingresaSusDatosY(String nombre, String apellido, String edad,
                                 String email, String salario, String departamento) {
        System.out.println("Esto es -> " + nombre + departamento);
    }

    @Then("el ve sus datos como una fila en el registro")
    public void veSusDatosComoUnaFilaEnElRegistro() {
        System.out.println("ya");
    }

}
