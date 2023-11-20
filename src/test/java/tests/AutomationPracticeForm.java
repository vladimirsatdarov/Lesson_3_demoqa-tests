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
        $("#firstName").setValue("Oleg");
        $("#lastName").setValue("Olegov");
        $("#userEmail").setValue("oleg@olegov.ru");
        $("#gender-radio-1").click();
        //$("#gender-radio-2").click();
        //$("#gender-radio-3").click();
        $("#userNumber").setValue("88005553535");
        $("#dateOfBirthInput").setValue("01 March 1990");
        $("#subjectsContainer").setValue("Physics, English");
        $("#hobbies-checkbox-1").click();
        $("#uploadPicture").click(); //доделать
        $("#currentAddress").setValue("Some Str. 1");
        $("#state").click(); // доделать Uttar Pradesh значение
        $("#city").click();

        $("#output #name").shouldHave(text("Oleg"));
        $("#output #email").shouldHave(text("oleg@olegov.ru"));
        $("#output #currentAddress").shouldHave(text("Some Str. 1"));
        $("#output #permanentAddress").shouldHave(text("Another Str. 1"));
    }
}
