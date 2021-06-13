package tests;

import io.qameta.allure.Step;
import pageObgect.GitHub;

import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    GitHub gitHub = new GitHub();

    @Step("Открываем главную страницу {url}")
    public void openMainPage(String url) {
        open(url);
        gitHub.makeScreenshot();
    }

    @Step("Ищем репозиторий {repository}")
    public void toSearchRepository(String repository) {
        gitHub.toSearchRepository(repository);
        gitHub.makeScreenshot();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        gitHub.selectRepository(repository);
        gitHub.makeScreenshot();
    }

    @Step("Открываем таб Issues в репозитории")
    public void openTabIssuesInRepository() {
        gitHub.openTabIssuesInRepository();
        gitHub.makeScreenshot();
    }

    @Step("Проверяем наличие Issue {issue} в репозитории")
    public void checkIssueInRepository(String issue) {
        gitHub.checkIssueInRepository(issue);
        gitHub.makeScreenshot();
    }
}
