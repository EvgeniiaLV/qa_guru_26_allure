package guru.qa.tests;

import com.codeborne.selenide.WebDriverRunner;
import guru.qa.pages.GitHubPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebSteps {
    GitHubPage gitHubPage = new GitHubPage();

    @Step("Open the main github page")
    public void openMainPage() {
        gitHubPage.openPage();
    }

    @Step("Search for the repository {TestData.REPOSITORY_NAME}")
    public void searchForRepository() {
        gitHubPage.clickOnSearchButton()
                .setSearchValue();
    }

    @Step("Click on the repository link {TestData.REPOSITORY_NAME}")
    public void clickOnRepositoryLink() {
        gitHubPage.clickOnRepositoryLink();
    }

    @Step("Open Actions tab")
    public void openActionsTab() {
        gitHubPage.clickOnActionsTab();
    }

    @Step("Check whether workflow number exists {TestData.WORKFLOW_NUMBER}")
    public void workflowNumberShouldExist() {
        gitHubPage.workflowNumberShouldExist();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
