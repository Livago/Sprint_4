package CommonClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageSamokat {
    private WebDriver driver;


    public MainPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void elementClick(By elementLocator) {
        driver.findElement(elementLocator).click();
    }

    public void waitTextToAppear(By textLocator) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(driver.findElement(textLocator)));
    }
    public void checkQuestionText(By elementLocator, String expectedText) {
        String actualText = driver.findElement(elementLocator).getText();
        Assert.assertEquals(expectedText, actualText);
    }

}
