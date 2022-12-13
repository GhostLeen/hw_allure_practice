package com.denal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @Test
    void issueSearchTest(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("GhostLeen/hw_allure_practice");
        $(".header-search-input").pressEnter();
        $(linkText("GhostLeen/hw_allure_practice")).click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}