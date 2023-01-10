Feature: Crear PetStore

  @test1
  Scenario: Scenario 1 - Crear Orden

    When creo la orden con id 7, petId 7, quantity 7
    Then el código de respuesta es 500
    And el message es "something bad happened"

  @test2
  Scenario: Scenario 2 - Obtener Orden

    When consultamos al petId 7
    Then el código de respuesta es 200
    And el status response es "placed"