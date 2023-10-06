package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
    @Test
    void googleTest(){
        Configuration.pageLoadTimeout = 120_000; //Задание таймаута чтобы не отваливался рендер из-за того что комп плохо тянет
        open("https://google.com");
        $("[name = 'q']").sendKeys("selenide");
        $("[name = 'q']").pressEnter();
        $("#search").shouldHave(Condition.text("selenide.org"));
    }
}
