package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/text-box");
        $("#userName").setValue("Oleg");
        $("#userEmail").setValue("oleg@olegov.ru");
        $("#currentAddress").setValue("Some Str. 1");
        $("#permanentAddress").setValue("Another Str. 1");
        $("#submit").click();

        $("#output #name").shouldHave(text("Oleg"));
        $("#output #email").shouldHave(text("oleg@olegov.ru"));
        $("#output #currentAddress").shouldHave(text("Some Str. 1"));
        $("#output #permanentAddress").shouldHave(text("Another Str. 1"));
    }
}
