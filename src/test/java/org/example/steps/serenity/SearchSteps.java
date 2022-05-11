package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.UsersPage;

public class SearchSteps {

    private UsersPage usersPage;

    @Step
    public void search_for_keyword(String keyword){
        usersPage.search_users(keyword);
    }

    @Step
    public void assert_only_matching_users_are_displayed(String keyword){
        usersPage.search_key_must_be_in_displayed_rows(keyword);
    }


}
