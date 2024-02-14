package org.example.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement searchInput = $((byAttribute("data-marker", "search-form/suggest"))),
            searchButton = $((byAttribute("data-marker", "search-form/submit-button")));

    public MainPage openPage() {
        open("https://www.avito.ru/");
        return this;
    }
    public SearchPage Search (String searchText) {
        searchInput.setValue(searchText);
        searchButton.click();

        return new SearchPage();
    }
}
