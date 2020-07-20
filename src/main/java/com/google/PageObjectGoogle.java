package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGoogle {
    private WebDriver chromeDriver;
    WebElement searchBar;
    WebElement searchButton;
    List<WebElement> results;
    List<WebElement> resultsTitle;

    public List<WebElement> getResults() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"g\"]//*[@class=\"s\"]"));
    }

    public List<WebElement> getResultsTitle() {
        return chromeDriver.findElements(By.xpath("//*[@class=\"g\"]//*[@class=\"r\"]"));
    }

    PageObjectGoogle(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
        searchBar = chromeDriver.findElement(By.xpath("//*[@name=\"q\"]"));
        searchButton = chromeDriver.findElement(By.xpath("//*[@name=\"btnK\"]"));

    }

    public void search(String worldSearch){
        searchBar.click();
        searchBar.sendKeys(worldSearch);
        searchButton.click();
    }


}
