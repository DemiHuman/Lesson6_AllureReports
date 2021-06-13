package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static public final String BASE_URL = Configuration.baseUrl = "https://github.com/";
    static public final String REPOSITORY = "allure-framework/allure2";
    static public final String NUMBER_ISSUE = "#1303";

    @BeforeAll
    public static void setup() {
        Configuration.startMaximized = true;
    }
}
