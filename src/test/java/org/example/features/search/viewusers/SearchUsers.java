package org.example.features.search.viewusers;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.HomePageSteps;
import org.example.steps.serenity.SearchSteps;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class SearchUsers {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public HomePageSteps homeSteps;

    @Steps
    public SearchSteps searchSteps;

    public WebDriverWait wait;

    @BeforeEach
    public void doLogIn() {
        String URL = "https://" +"lhdemo" +":" +"LH@Evozon!2022" +"@"+ "lighthouse-demo.evozon.com/login";
        webdriver.get(URL);
        wait = new WebDriverWait(webdriver, 100);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("MuiButton-label")));
        webdriver.findElement(By.xpath("/html/body/div/div[2]/main/div/div/form/div[1]/div/input")).sendKeys("marin.peptenaru@protonmail.com");
        webdriver.findElement(By.name("password")).sendKeys("parolaEvozon0!");
        webdriver.findElement(By.className("MuiButton-label")).click();
        webdriver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
    }


    @Test
    public void search_for_keyword_in_users_and_assure_only_matching_users_are_displayed(){
        String keyword = "UBB";
        wait = new WebDriverWait(webdriver, 100);
        homeSteps.goToUsersPage(wait);
        searchSteps.search_for_keyword(keyword);
        searchSteps.assert_only_matching_users_are_displayed(keyword);
    }

}
