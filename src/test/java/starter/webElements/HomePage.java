package starter.webElements;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://google.com/")
public class HomePage extends PageObject {
    public static By SET_BAR = By.id("L2AGLb");
    public static By SEARCH_BAR = By.cssSelector("input[name='q']");
    public static By SEARCH_BUTTON = By.cssSelector("input[name='btnK']");

    public static By SEARCH_RESULT = By.cssSelector(".GyAeWb");
}
