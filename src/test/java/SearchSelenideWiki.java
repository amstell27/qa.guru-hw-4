import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideWiki {
    @Test
    void shouldFindSelenideGithub() {
        // открыть страницу github.com
        open("https://github.com/");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();

        // нажимаем на линк от первого результата поиска
        $$("ul.repo-list").first().$("a").click();
        // check: в заголовке встречаются selenide/selenide
        $("h1").shouldHave(text("selenide / selenide"));
        // перейти в раздел wiki
        $("#wiki-tab").click();
        // Проверка наличия SortAssertions в Pages
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").$("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        // Проверка перехода на страницу SortAssertions
        $("#wiki-wrapper").shouldHave(text("SoftAssertions"));
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}


