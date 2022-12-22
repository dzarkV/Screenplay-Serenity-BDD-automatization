Feature: Interactuar con alertas
#  Varias personas como usuarios de la pagina web
#  desean ver sus apodos en pantalla


  Scenario Outline: Recorrer las alertas de la pagina para ver el nombre de usuario en pantalla
    Given "<usuario>" quiere ver su apodo en pantalla
    When El recorre las alertas en la pagina
    And Ingresa su "<apodo>"
    Then Su "<apodo>" se muestra en pantalla
    Examples:
      | usuario | apodo                                       |
      | Jorge   | El patróóón                                 |
      | Lio     | 10000000.....0000000000000.0000000000000000 |