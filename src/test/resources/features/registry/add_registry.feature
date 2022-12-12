Feature: Agregar nuevo registro a web tables
#  Yo como aprendiz de sophos academy
#  Necesito agregar nuevos registros
#  Para validar que los registros son guardados correctamente

  @happy
  Scenario: Agregar los datos de usuario de manera exitosa
    Given "Pepe" desea guardar sus datos de usuario en la pagina web
    When el ingresa sus datos de usuario completos
    Then el ve sus datos como una fila en el registro

  @incompletedata
  Scenario: Agregar los datos de usuario de manera incompleta
    Given "Dayro" desea guardar sus datos de usuario en la pagina web
    When el ingresa sus datos excepto el email
    Then el ve un aviso indicando que le falta ingresar el email

  @typeerror
  Scenario: Agregar los datos de edad con caracteres en lugar de números
    Given "Marina" desea guardar sus datos de usuario en la pagina web
    When ella ingresa sus datos de edad con letras
    Then ella ve que no puede continuar con el registro
    And sus datos no son guardados