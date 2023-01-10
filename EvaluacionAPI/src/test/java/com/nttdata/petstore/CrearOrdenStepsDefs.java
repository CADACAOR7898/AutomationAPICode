package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenStepsDefs {

    @Steps
    CrearOrden crearOrden;

    @When("creo la orden con id {int}, petId {int}, quantity {int}")
    public void setCrearOrden(int id, int petId, int quantity){
        crearOrden.crearOrden(id, petId, quantity);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.log().all().statusCode(statusCode));
    }

    @And("el type es {string}")
    public void elTypeEs(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
        System.out.println("Type: " + SerenityRest.lastResponse().body().path("type").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    @And("el status es {string}")
    public void el_status_s(String type) {
        restAssuredThat(response -> response.body("'type'", equalTo(type)));
        System.out.println("Type: " + SerenityRest.lastResponse().body().path("type").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

    @And("el message es {string}")
    public void el_message_s(String message) {
        restAssuredThat(response -> response.body("'message'", equalTo(message)));
        System.out.println("Message: " + SerenityRest.lastResponse().body().path("message").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}
