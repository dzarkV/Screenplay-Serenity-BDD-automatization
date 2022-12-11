Feature: Agregar nuevo registro a web tables
#  Yo como aprendiz de sophos academy
#  Necesito agregar nuevos registros
#  Para validar que los registros son guardados correctamente

  Scenario: Agregar los datos de usuario de manera exitosa
    Given "Pepe" desea guardar sus datos de usuario
    When el ingresa sus datos de usuario
    Then el ve sus datos como una fila en el registro

  Scenario: Agregar los datos de usuario de manera incompleta
    Given "Dayro" desea guardar sus datos de usuario
    When el ingresa sus datos excepto el email
    Then el ve un aviso indicando que le falta ingresar el email
