package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;


@Feature("Issue")
@Owner("eropkinpyu")
public class TestIssueAnnotatedStep extends TestBase {

    WebSteps steps = new WebSteps();

    @Test
    @Story("Проверка issue")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "https://github.com/")
    @DisplayName("Проверка наличия issue в репозитории")
    public void checkIssue() {
        steps.openMainPage(BASE_URL);
        steps.toSearchRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openTabIssuesInRepository();
        steps.checkIssueInRepository(NUMBER_ISSUE);
    }
}
