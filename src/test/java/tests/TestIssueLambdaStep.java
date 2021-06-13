package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import pageObgect.GitHub;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Issue")
@Owner("eropkinpyu")
public class TestIssueLambdaStep extends TestBase {

    GitHub gitHub = new GitHub();

    @Test
    @Story("Проверка issue")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Github", url = "{BASE_URL}")
    @DisplayName("Проверка наличия issue в репозитории")
    public void checkIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", (s) -> {
            s.parameter("url", BASE_URL);
            open(BASE_URL);
        });
        step("Ищем репозиторий", (s) -> {
            s.parameter("Repository", REPOSITORY);
            gitHub.toSearchRepository(REPOSITORY);
        });
        step("Переходим в репозиторий", (s) -> {
            s.parameter("Repository", REPOSITORY);
            gitHub.selectRepository(REPOSITORY);
        });
        step("Открываем таб Issues в репозитории", () -> {
            gitHub.openTabIssuesInRepository();
        });
        step("Проверяем наличие Issue " + NUMBER_ISSUE + " в репозитории", (s) -> {
            s.parameter("Issue", NUMBER_ISSUE);
            gitHub.checkIssueInRepository(NUMBER_ISSUE);
        });
        step("Делаем screenshot", () -> {
            gitHub.makeScreenshot();
        });
    }
}
