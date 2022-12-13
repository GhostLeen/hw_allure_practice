package com.denal;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу GitHub")
    public void openGitLink() {
        open("https://github.com/");
        makeScreenshot();
    }

    @Step("Ищем репозиторий {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").pressEnter();
    }

    @Step("Кликаем по репозиторию с именем {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
        makeScreenshot();
    }

    @Step("Открываем таб Issue")
    public void clickOnIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие репозитория с номером {issueNum}")
    public void checkIssueExistence(int issueNum) {
        $(withText("#" + issueNum)).should(Condition.exist);
        makeScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}