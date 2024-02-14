package org.example;

import org.example.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

@DisplayName("Параметризованный тест")
public class AvitoSearchTest {

    MainPage MainPage = new MainPage();

    @ValueSource(strings = {
            "Bmw", "mercedes"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой каталог")
    @Tag("WEB")
    void searchResultsShouldNotBeEmptyVer1(String value) {
        MainPage.openPage()
                .Search(value)
                .CheckPageTitle(value)
                .CheckCatalog();
    }

    @CsvSource(value = {
            "Bmw",
            "Audi"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой каталог")
    @Tag("BLOCKER")
    void searchResultsShouldNotBeEmptyVer2(String value) {
        MainPage.openPage()
                .Search(value)
                .CheckPageTitle(value)
                .CheckCatalog();
    }

    static Stream<Arguments> searchResultsShouldNotBeEmptyVer3() {
        return Stream.of(
                Arguments.of(
                        "Bmw"
                ),
                Arguments.of(
                        "Mercedes"
                )
        );
    }

    @MethodSource ()
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой каталог")
    @Tag("SMOKE")
    void searchResultsShouldNotBeEmptyVer3(String value) {
        MainPage.openPage()
                .Search(value)
                .CheckPageTitle(value)
                .CheckCatalog();
    }

}