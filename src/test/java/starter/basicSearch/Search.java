package starter.basicSearch;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import starter.steps.SearchSteps;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class Search {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    SearchSteps searchSteps;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
    }

   @After
   public void closeDriver() {
   if (driver !=null) {
       driver.quit();
       }
   }
    @Test
    public void basicSearch() {
        final String searchCriteria = "hello";
        searchSteps.navigateToHomePage();

        searchSteps.enterSearchCriteria(searchCriteria);
        searchSteps.clickSearchButton();
        assertThat(searchSteps.getResultList())
                .matches(results -> results.size() > 0, "Result list size not to be zero")
                .allMatch(title -> title.contains(searchCriteria));


    }
}
