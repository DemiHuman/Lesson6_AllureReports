package pageObgect;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class GitHub {

    private SelenideElement search = $("[name=q]");
    private SelenideElement tabIssues = $("[data-content=Issues]");

    public void toSearchRepository(String value) {
        search.val(value).pressEnter();
    }

    public void selectRepository(String repository) {
        $(byLinkText(repository)).click();
    }

    public void openTabIssuesInRepository() {
        tabIssues.click();
    }

    public void checkIssueInRepository(String numberIssue) {
        $(withText(numberIssue)).should(Condition.visible);
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }
}
