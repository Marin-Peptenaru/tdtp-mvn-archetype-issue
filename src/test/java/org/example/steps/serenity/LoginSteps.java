package org.example.steps.serenity;


import net.thucydides.core.annotations.Step;
import org.example.pages.LoginPage;

public class LoginSteps {

    private LoginPage loginPage;

    @Step
    public void login(String username, String password){
        loginPage.type_username(username);
        loginPage.type_password(password);
        loginPage.login();
    }
}
