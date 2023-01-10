package com.denal;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.denal.config.WebDriverProvider;
import com.denal.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider.config();
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.addVideo();
    }
}