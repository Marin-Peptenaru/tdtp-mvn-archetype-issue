package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("https://lighthouse-demo.evozon.com/users")
public class UsersPage extends PageObject {

    @FindBy(name = "setSearchKey")
    private WebElementFacade searchField;

    public void search_users(String searchKey) {
        searchField.type(searchKey);
    }

    public void search_key_must_be_in_displayed_rows(String searchKey){
        List<WebElementFacade> tableRows = findAll("tr");

        String lowerCaseSearchKey = searchKey.toLowerCase();

        // iterate the table rows displayed
        for(WebElementFacade row: tableRows){
            // get the cells contained in each row
            List<WebElement> cells = row.findElements(By.tagName("td"));
            boolean containsSearchKey = false;

            // make sure that at least one cell from each row contains the search key, case-insensitive
            for(WebElement cell: cells){
                if(cell.getText().toLowerCase().contains(lowerCaseSearchKey)){
                    containsSearchKey = true;
                    break;
                }
            }

            Assert.assertTrue(containsSearchKey);
        }
    }



}
