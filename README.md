# Automatizacion con Serenity BDD, Cucumber y patrón Screenplay

Automatización de pruebas de aceptación con la librería Serenity BDD y, por tanto, con _living documentation_. 
Fue guiado por el patrón de diseño Screenplay y el analizador de lenguaje de Gherkin Cucumber.

Su sistema de carpetas es:

```bash
src
├── main
│   └── java
│       └── com
│           └── challenge
│               ├── exceptions
│               ├── interactions
│               ├── models
│               │   └── UserData.java
│               ├── questions
│               │   ├── StillVisible.java
│               │   ├── ValidateField.java
│               │   └── ValidateText.java
│               ├── tasks
│               │   ├── AddNewRegistry.java
│               │   ├── DeleteRegistry.java
│               │   ├── InteractWithAlerts.java
│               │   ├── NavigateTo.java
│               │   └── SelectNewDate.java
│               ├── userinterfaces
│               │   ├── alerts
│               │   │   └── DemoQaAlertsPage.java
│               │   ├── dates
│               │   │   └── DemoQaDatesPickerPage.java
│               │   ├── DemoQaElementsPage.java
│               │   ├── DemoQaHomePage.java
│               │   └── registry
│               │       └── DemoQaWebTablesPage.java
│               └── utilities
│                   ├── CsvToUsersDataRegistry.java
│                   ├── StringToLocalDate.java
│                   └── WebElementsJsonData.java
└── test
    ├── java
    │   └── com
    │       └── challenge
    │           ├── hooks
    │           │   └── SetTheStage.java
    │           ├── runners
    │           │   ├── AddRegistry.java
    │           │   ├── InteractAlert.java
    │           │   └── SelectDate.java
    │           └── stepdefinitions
    │               ├── AddRegistryStepDefinition.java
    │               ├── InteractAlertsStepDefinition.java
    │               └── SelectDatesStepDefinition.java
    └── resources
        ├── features
        │   ├── alerts
        │   │   └── interact_alert.feature
        │   ├── dates
        │   │   └── select_date.feature
        │   └── registry
        │       └── add_registry.feature
        ├── serenity.conf
        └── testdata
            ├── examples_registry.csv
            └── web_elements.json
```

La automatización consiste en automatizar tres flujos de la página [Demo QA](https://demoqa.com/) con las rutas:

* Elements > Web Tables → Para realizar registros en la tabla
* Widgets > Date Picker → Para ingresar fechas y fechas con hora
* Alerts, Frame & Windows > Alerts → Para interactuar con los tipos de [alertas](https://developer.mozilla.org/en-US/docs/Web/API/Window/alert)

-----
## Características

El flujo de registro está construído con pruebas basadas en datos leídos de archivo externo `csv`. 
Esto lo permite la clase `CsvToUsersDataRegistry.java`, que convierte los datos al modelo `UserData`.

El flujo de fechas usa el `Scenario Outline` para enviar tanto

* fechas en formato ISO como 
* fechas con horas y minutos

El flujo de alertas interactúa con los tres tipos de ventanas de alerta del navegador:

* Alert or dialog
* Confirm
* Prompt

En el caso de la alerta Confirm se maneja el retraso de tiempo de 5 segundos que el botón presenta.

En todos los flujos se le hacen preguntas al sistema con las clases en la carpeta `questions`.