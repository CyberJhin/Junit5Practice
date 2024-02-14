package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    private final SelenideElement pageTitle = $((byAttribute("data-marker", "page-title/text")));
    public final ElementsCollection catalog = $((byAttribute("data-marker", "catalog-serp"))).$$((byAttribute("data-marker", "item")));

    public SearchPage CheckPageTitle (String searchText) {
        pageTitle.shouldHave(text(searchText));

        return this;
    }

    public SearchPage CheckCatalog () {
        catalog.shouldHave(sizeGreaterThan(0));

        return this;
    }
}
