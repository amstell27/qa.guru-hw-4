import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {

    @Test
    void dragAndDropRectangle() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        //проверка открытия страницы
        $("#content").shouldHave(text("Drag and Drop"));
        //перенос прямоугольника А
        $("#column-a").dragAndDropTo("#column-b");
        //Проверка переноса прямоугольника А
        $("#column-b").shouldHave(text("A"));

    }


}
