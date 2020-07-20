package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings {

    @Test
    public void checkTitle(){
        chromeDriver.get("https://www.google.com/");
        String titleGoogle = chromeDriver.getTitle();
        System.out.println(titleGoogle);
        Assertions.assertTrue(titleGoogle.contains("Google"),"Название страницы не соответствует искомому");
    }

    @Test
    public void findGladiolus(){
        chromeDriver.get("https://www.google.com/");
        PageObjectGoogle google = new PageObjectGoogle(chromeDriver);
        google.search("Гладиолус");

        //Ищем значения Гладиолус
        Assertions.assertTrue(
                google.getResults().stream().anyMatch(x->x.getText().contains("Гладиолус")),"Потому, что гладиолус :)"
        );

        //Ищем, что их больше или равно 3
        int r = google.getResults().size();
        Assertions.assertTrue(
                r>=3,"Вывод поиска меньше 3х"
        );

        //Ищем, что есть ссылка на википедию
        Assertions.assertTrue(
                google.getResultsTitle().stream().anyMatch(x->x.getText().contains("ru.wikipedia.org")),"Ссылка на википедию не найдена"
        );

    }
}
