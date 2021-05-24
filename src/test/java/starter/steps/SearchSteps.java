package starter.steps;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import starter.webElements.HomePage;

import java.util.List;
import java.util.stream.Collectors;

import static starter.webElements.HomePage.*;

public class SearchSteps extends PageObject {

    HomePage homePage;

    @Step("Navigate to google Home page")
    public void navigateToHomePage() {
        homePage.open();
        $(SET_BAR).click();
    }

    @Step("Enter Search criteria")
    public void enterSearchCriteria(String searchCriteria) {
        $(SEARCH_BAR).clear();
        $(SEARCH_BAR).sendKeys(searchCriteria);
    }

    @Step("Click on Search button")
    public void clickSearchButton() {
       $(SEARCH_BUTTON).click();
    }

    @Step("GetResultList")
    public List<String> getResultList(){
        homePage.waitForRenderedElements(SEARCH_RESULT);
        return findAll(SEARCH_RESULT)
                .stream()
                .map(WebElementFacade::getTextContent)
                .map(String::toLowerCase)
                .collect(Collectors.toList());

    }

}