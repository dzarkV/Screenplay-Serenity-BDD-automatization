Feature: Seleccionar fechas en la pagina web
#      | Jorge     | 26/04/2017       | 04/26/2017                 |

  @selectDate
  Scenario Outline: Seleccionar su fecha de nacimiento
    Given "<usuario>" quiere registrar la fecha de nacimiento en la pagina
    When El selecciona la "<fecha>"
    Then La "<fecha registrada>" se muestra en pantalla
    Examples:
      | usuario   | fecha            | fecha registrada         |
      | Ana       | 03/10/1993       | 10/03/1993               |
      | Emma      | 22/04/2017 14:15 | April 22, 2017 2:15 PM   |
      | Celia     | 26/12/1986       | 12/26/1986               |
      | Mayra     | 26/04/1945       | 04/26/1945               |
      | Francisca | 01/01/2025 22:00 | January 1, 2025 10:00 PM |


