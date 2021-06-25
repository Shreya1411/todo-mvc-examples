package core.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseWebPage extends PageObject {

    public WebDriver getWebDriver() {
        return Serenity.getWebdriverManager().getCurrentDriver();
    }
    public void waitUntilElementDisappear(By locator, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), timeInSec);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitUntilElementIsVisible(By locator, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), timeInSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilElementIsClickable(WebElementFacade element, int timeInSec) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), timeInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element.getElement()));
    }
}
