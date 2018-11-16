package idt.custcare.ui.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Executes the features.
 */
@CucumberOptions(
        monochrome = true,
        format = {"pretty"},
        features = {"src/test/resources/features/"},
        glue = {"idt.custcare.ui"})

public class Runner extends AbstractTestNGCucumberTests {
}

