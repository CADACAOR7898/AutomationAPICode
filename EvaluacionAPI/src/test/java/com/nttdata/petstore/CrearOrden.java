package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.jruby.RubyProcess;

public class CrearOrden {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";

    @Step("Crear Orden {0} en PetStore")
    public void crearOrden(int id, int petId, int quantity){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \"string\",\n" +
                        "  \"status\": \"string\",\n" +
                        "  \"complete\": \"string\",\n" +
                        "}")
                .post(CREATE_ORDER);
    }
}
