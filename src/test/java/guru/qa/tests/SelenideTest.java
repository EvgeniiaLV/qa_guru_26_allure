package guru.qa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.pages.GitHubPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelenideTest extends TestBase {
    @Test
    @Feature("Check workflow runs")
    @Story("Workflow search")
    @Owner("Evgeniia Liasheva")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Search for workflow number on the Actions tab of the 'selenide-puzzles' repository using Selenide")
    public void testWorkflowSearch() {
        GitHubPage gitHubPage = new GitHubPage();
        SelenideLogger.addListener("allure", new AllureSelenide());

        gitHubPage.openPage()
                .clickOnSearchButton()
                .setSearchValue()
                .clickOnRepositoryLink()
                .clickOnActionsTab();

        gitHubPage.workflowNumberShouldExist();
    }

}
