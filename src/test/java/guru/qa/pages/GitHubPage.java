package guru.qa.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import guru.qa.utils.TestData;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class GitHubPage {
    private final SelenideElement searchButton = $(".header-search-button"),
            searchInputField = $("input#query-builder-test"),
            actionsTab = $("#actions-tab"),
            foundLink = $(linkText(TestData.REPOSITORY_NAME)),
            foundWorkflow = $(withText(TestData.WORKFLOW_NUMBER));

    public GitHubPage openPage() {
        open("/");

        return this;
    }

    public GitHubPage clickOnSearchButton() {
        searchButton.click();

        return this;
    }

    public GitHubPage setSearchValue() {
        searchInputField.setValue(TestData.REPOSITORY_NAME).pressEnter();

        return this;
    }

    public GitHubPage clickOnRepositoryLink() {
        foundLink.click();

        return this;
    }

    public GitHubPage clickOnActionsTab() {
        actionsTab.click();

        return this;
    }

    public GitHubPage workflowNumberShouldExist() {
        foundWorkflow.should(Condition.exist);

        return this;
    }
}
