package com.challenge.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = "pretty",
        glue = {"com.challenge.hooks","com.challenge.stepdefinitions"},
        features = "src/test/resources/features/registry/add_registry.feature",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
)
public class AddRegistry {
}