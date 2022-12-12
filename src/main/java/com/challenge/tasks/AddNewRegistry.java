package com.challenge.tasks;

import com.challenge.models.UserData;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.challenge.userinterfaces.registry.DemoQaWebTablesPage.*;

public class AddNewRegistry {

    public static Performable withDataUser(UserData user){
        return Task.where("{0} enter new registries",
                WaitUntil.the(ADD_BUTTON, WebElementStateMatchers.isCurrentlyVisible())
                        .forNoMoreThan(2).seconds(),
                Click.on(ADD_BUTTON),
                Enter.theValue(user.getName()).into(NAME_FIELD),
                Enter.theValue(user.getLastName()).into(LAST_NAME_FIELD),
                Enter.theValue(user.getEmail()).into(EMAIL_FIELD),
                Enter.theValue(user.getAge()).into(AGE_FIELD),
                Enter.theValue(user.getSalary()).into(SALARY_FIELD),
                Enter.theValue(user.getDepartment()).into(DEPARTMENT_FIELD),
                Click.on(SUBMIT_BUTTON)
        );
    }
}
