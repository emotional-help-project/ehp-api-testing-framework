package com.epam.rd.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/epam/rd/features",
        glue = {"com.epam.rd"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

