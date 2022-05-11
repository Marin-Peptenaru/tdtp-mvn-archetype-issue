package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSteps {

    HomePage homePage;

    @Step
    public void goToUsersPage(WebDriverWait wait){
        homePage.goToUsersPage(wait);
    }
}
