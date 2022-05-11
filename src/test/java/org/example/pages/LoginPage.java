package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://" +"lhdemo" +":" +"LH@Evozon!2022" +"@"+ "lighthouse-demo.evozon.com/login")
public class LoginPage extends PageObject {

    @FindBy(name="username")
    private WebElementFacade usernameInput;

    @FindBy(name="password")
    private WebElementFacade passwordField;

    @FindBy(xpath ="/html/body/div/div[2]/main/div/div/form/button")
    private WebElementFacade loginButton;

    public void type_username(String username) {
        usernameInput.type(username);
    }

    public void type_password(String password) {
        passwordField.type(password);
    }

    public void login() {
        loginButton.click();
    }
}
