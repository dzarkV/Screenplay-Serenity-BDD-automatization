Feature: Agregar nuevo registro a web tables
#  Varias personas como usuarios de la pagina web
#  necesitan agregar nuevos registros
#  para hacer uso de los servicios

  @happy
  Scenario: Agregar los datos de usuario de manera exitosa
    Given "Pepe" desea guardar sus datos de usuario en la pagina web
    When El ingresa sus datos de usuario completos
    Then El ve sus datos como una fila en el registro

  @incompletedata
  Scenario: Agregar los datos de usuario de manera incompleta
    Given "Dayro" desea guardar sus datos de usuario en la pagina web
    When El ingresa sus datos excepto el email
    Then El ve un aviso indicando que le falta ingresar el email

  @typeerror
  Scenario: Agregar los datos de edad con caracteres en lugar de números
    Given "Marina" desea guardar sus datos de usuario en la pagina web
    When Ella ingresa sus datos de edad con letras
    Then Ella ve que no puede continuar con el registro
    And sus datos no son guardados