# Automatizacion con Serenity BDD, Cucumber y patrón Screenplay

[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=dzarkV_Screenplay-Serenity-BDD-automatization&metric=bugs)](https://sonarcloud.io/summary/new_code?id=dzarkV_Screenplay-Serenity-BDD-automatization)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=dzarkV_Screenplay-Serenity-BDD-automatization&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=dzarkV_Screenplay-Serenity-BDD-automatization)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=dzarkV_Screenplay-Serenity-BDD-automatization&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=dzarkV_Screenplay-Serenity-BDD-automatization)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=dzarkV_Screenplay-Serenity-BDD-automatization&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=dzarkV_Screenplay-Serenity-BDD-automatization)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=dzarkV_Screenplay-Serenity-BDD-automatization&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=dzarkV_Screenplay-Serenity-BDD-automatization)

[![Run test and publish living doc](https://github.com/dzarkV/Screenplay-Serenity-BDD-automatization/actions/workflows/gradle_test_publish_docs.yml/badge.svg)](https://github.com/dzarkV/Screenplay-Serenity-BDD-automatization/actions/workflows/gradle_test_publish_docs.yml)

Automatización de pruebas con la librería Serenity BDD y, por tanto, con _living documentation_. 
Fue guiado por el patrón de diseño Screenplay y el analizador de lenguaje de Gherkin Cucumber.

La automatización consiste en automatizar tres flujos de la página [Demo QA](https://demoqa.com/) con las rutas:

* Elements > Web Tables → Para realizar registros en la tabla
* Widgets > Date Picker → Para ingresar fechas y fechas con hora
* Alerts, Frame & Windows > Alerts → Para interactuar con los tipos de [alertas](https://developer.mozilla.org/en-US/docs/Web/API/Window/alert)

El resultado de los test se puede consultar [aquí](https://serenity-living-doc.azurewebsites.net/). 

El sistema de archivos es:

```bash
src
├── main
│   └── java
│       └── com
│           └── challenge
│               ├── exceptions
│               │   └── ExcepcionGeneral.java
│               ├── interactions
│               ├── models
│               │   └── UserData.java
│               ├── questions
│               │   ├── IsVisibleThe.java
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
│               │   ├── dates
│               │   ├── DemoQaHomePage.java
│               │   ├── DemoQaMenuPage.java
│               │   └── registry
│               └── utilities
│                   ├── CsvToUsersDataRegistry.java
│                   ├── ErrorMessage.java
│                   ├── StringToLocalDate.java
│                   └── WebMenuFromJsonData.java
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
        ├── logback-test.xml
        ├── serenity.conf
        └── testdata
            ├── examples_registry.csv
            └── web_menu.json
```
-----
## Características

Como la estructura de la página es `Menu > Submenu` (por ejemplo, Elements > Web Tables), para simplificar la navegación se parametrizó esta estructura con [web_menu.json](src/test/resources/testdata/web_menu.json),
que es leído por la clase [WebMenuFromJsonData](src/main/java/com/challenge/utilities/WebMenuFromJsonData.java) y permite definir el flujo como un objeto, así:

```json
{
  "Flow <#>": {
    "<Menu>": "<Submenu>"
  }
}
```

El llamado al flujo se realiza desde cada _Step definition_ y se le pasa al método para navegar [theDemoQaSubPage](src/main/java/com/challenge/tasks/NavigateTo.java).

![Captura desde 2022-12-15 17-04-00](https://user-images.githubusercontent.com/91356068/207978857-4f45e680-2713-4f60-ab15-65bbc870eb13.png)

El flujo de registro está construído con pruebas basadas en datos leídos de archivo externo `csv`.
Esto lo permite la clase [CsvToUsersDataRegistry](src/main/java/com/challenge/utilities/CsvToUsersDataRegistry.java), que convierte los datos al modelo `UserData` y así manejar el registro ingresado en la _web table_.


El flujo de fechas usa el `Scenario Outline` para enviar tanto

* fechas en formato ISO como 
* fechas con horas y minutos

El flujo de alertas interactúa con los tres tipos de ventanas de alerta del navegador:

* Alert or dialog
* Confirm
* Prompt

En el caso de la alerta Confirm se maneja el retraso de tiempo de 5 segundos que el botón presenta.

En todos los flujos se le hacen preguntas al sistema con las clases en la carpeta `questions`.

## Requisitos

Para correr el proyecto se necesita Java JDK 1.8 u 11 y Gradle, preferiblemente con la versión 7.2.

Para lanzar las pruebas y generar la _living documentation_ en la carpeta `/target/site/serenity/`:

```bash
./gradlew clean build test
```

## CI/CD

Se usa archivo `.yml` [gradle_test_publish_docs](.github/workflows/gradle_test_publish_docs.yml) para definir los _jobs_ de Github Actions de construcción, ejecución de test y despliegue a Azure.
