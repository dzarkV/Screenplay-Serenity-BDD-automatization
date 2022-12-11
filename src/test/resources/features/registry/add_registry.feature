Feature: Agregar nuevo registro a web tables
#  Yo como aprendiz de sophos academy
#  Necesito agregar nuevos registros
#  Para validar que los registros son guardados correctamente

#  Background:
#    Given "John" va a la pagina web de demoqa
#    Then puede ver el titulo de la pagina demoqa

#  Scenario Outline: Agregar los datos de usuario al registro
#    Given "<nombre>" desea guardar sus datos de usuario
#    When el ingresa sus datos "<nombre>" "<apellido>" "<edad>" "<email>" "<salario>" y "<departamento>"
#    Then el ve sus datos como una fila en el registro
#    Examples:
#      | nombre | apellido     | edad | email                  | salario | departamento |
#      | Pepe   | Portocarrero | 32   | pportocarrero@mail.com | 350000  | Sports       |
#      | Dayro  | Moreno       | 35   |                        | 500000  | Parties      |

  Scenario: Agregar los datos de usuario de manera exitosa
    Given "Pepe" desea guardar sus datos de usuario
    When el ingresa sus datos de usuario
    Then el ve sus datos como una fila en el registro