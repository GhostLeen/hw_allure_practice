package com.denal;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotationStepsTest {

    public static final String REPOSITORY = "GhostLeen/hw_allure_practice";
    public static final int ISSUE_NUMBER = 1;

    @Test
    void issueSearchAnnotatedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide()); //Отображает методы в отчете allure
        WebSteps step = new WebSteps();

        step.openGitLink();
        step.searchForRepository(REPOSITORY);
        step.clickOnRepositoryLink(REPOSITORY);
        step.clickOnIssueTab();
        step.checkIssueExistence(ISSUE_NUMBER);
    }
}