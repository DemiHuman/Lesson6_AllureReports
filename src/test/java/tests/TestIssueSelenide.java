package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import pageObgect.GitHub;

import static com.codeborne.selenide.Selenide.*;

public class TestIssueSelenide extends TestBase {

    GitHub gitHub = new GitHub();

    @Test
    public void checkIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open(BASE_URL);
        gitHub.toSearchRepository(REPOSITORY);
        gitHub.selectRepository(REPOSITORY);
        gitHub.openTabIssuesInRepository();
        gitHub.checkIssueInRepository(NUMBER_ISSUE);
    }
}