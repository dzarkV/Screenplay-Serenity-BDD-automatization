Feature: Interactuar con alertas

  Scenario Outline: Recorrer las alertas de la pagina para ver el nombre de usuario en pantalla
    Given "<usuario>" quiere ver su apodo en pantalla
    When El recorre las alertas en la pagina
    And Ingresa su "<apodo>"
    Then Su "<apodo>" se muestra en pantalla
    Examples:
      | usuario | apodo       |
      | Messi   | La pulga    |
      | Jorge   | El patrón   |
      | Jair    | El chiguiro |