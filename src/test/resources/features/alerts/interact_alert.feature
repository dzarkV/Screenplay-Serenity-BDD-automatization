Feature: Interactuar con alertas

  Scenario Outline: Recorrer las alertas de la pagina para ver el nombre de usuario en pantalla
    Given "<usuario>" quiere ver su apodo en pantalla
    When El recorre las alertas en la pagina
    And Ingresa su "<apodo>"
    Then Su "<apodo>" se muestra en pantalla
    Examples:
      | usuario | apodo                                       |
      | Jorge   | El patróóón                                 |
      | Messi   | 10000000.....0000000000000.0000000000000000 |