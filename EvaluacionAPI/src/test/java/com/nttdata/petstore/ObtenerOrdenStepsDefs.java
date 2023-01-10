package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class ObtenerOrdenStepsDefs {

    @When("consultamos al petId {int}")
    public void obtenerOrden(int petId){
        String GET_ORDER = "https://petstore.swagger.io/v2/store/order/" + petId;
        SerenityRest.given()
                .contentType("application/json").get(GET_ORDER);
    }

    @And("el status response es {string}")
    public void el_status_sGET(String status) {
        restAssuredThat(response -> response.body("'status'", equalTo(status)));
        System.out.println("Status: " + SerenityRest.lastResponse().body().path("status").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }

}
