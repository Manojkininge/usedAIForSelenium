package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

    private WebDriver driver;

    private By accountSections = By.cssSelector("div.list-group a.list-group-item");



    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAccountsPageTitle() {
        return driver.getTitle();
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountSections).size();
    }

    public List<String> getAccountsSectionsList() {

        List<String> accountsList = new ArrayList<>();
        List<WebElement> accountsHeaderList = driver.findElements(accountSections);

        for (WebElement e : accountsHeaderList) {
            String text = e.getText().trim();
            System.out.println(text);
            accountsList.add(text);
        }
        System.out.println("returning account list is : "+accountsList);
        return accountsList;

    }

}