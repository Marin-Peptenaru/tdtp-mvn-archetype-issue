package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@DefaultUrl("https://lighthouse-demo.evozon.com/")
public class HomePage extends PageObject {

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/button")

    private WebElementFacade usersLink;


    public void goToUsersPage(WebDriverWait wait){
       wait.until(ExpectedConditions.elementToBeClickable(usersLink)).click();
    }

}
