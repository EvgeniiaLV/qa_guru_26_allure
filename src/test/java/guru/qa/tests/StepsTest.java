package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubPage;
import guru.qa.utils.TestData;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class StepsTest extends TestBase {
    @Test
    @Feature("Check workflow runs")
    @Story("Workflow search")
    @Owner("Evgeniia Liasheva")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Search for workflow number on the actions tab of the 'selenide-puzzles' repository with lambda functions")
    public void testWorkflowSearchWithLambda() {
        GitHubPage gitHubPage = new GitHubPage();
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main github page", () -> {
            gitHubPage.openPage();
        });
        step("Search for the repository " + TestData.REPOSITORY_NAME, () -> {
            gitHubPage.clickOnSearchButton()
                    .setSearchValue();
        });
        step("Click on the repository link " + TestData.REPOSITORY_NAME, () -> {
            gitHubPage.clickOnRepositoryLink();
        });
        step("Open Actions tab", () -> {
            gitHubPage.clickOnActionsTab();
        });
        step("Check whether workflow number exists " + TestData.WORKFLOW_NUMBER, () -> {
            gitHubPage.workflowNumberShouldExist();
        });
    }

    @Test
    @Feature("Check workflow runs")
    @Story("Workflow search")
    @Owner("Evgeniia Liasheva")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Search for workflow number on the actions tab of the 'selenide-puzzles' repository with annotated steps")
    public void testWorkflowSearchWithAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository();
        steps.clickOnRepositoryLink();
        steps.openActionsTab();
        steps.workflowNumberShouldExist();

    }
}
