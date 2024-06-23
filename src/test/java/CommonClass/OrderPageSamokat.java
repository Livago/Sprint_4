package CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderPageSamokat {
    private WebDriver driver;

    private final By orderNameLocator = By.xpath(".//div[2]/div[2]/div[1]/input");
    private final By orderLastNameLocator = By.xpath(".//div[2]/div[2]/div[2]/input");
    private final By orderAdressLocator = By.xpath(".//div[2]/div[2]/div[3]/input");
    private final By orderMetroLocator = By.xpath(".//div[2]/div[2]/div[4]/div/div/input");
    private final By orderPhoneLocator = By.xpath(".//div[2]/div[2]/div[5]/input");
    private final By orderNextBttnLocator = By.xpath(".//div[2]/div[3]/button");

    public OrderPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void fillElement(By elementLocator, String dataToFill) {
        driver.findElement(elementLocator).sendKeys(dataToFill);
    }

    public void elementClick(By elementLocator) {
        driver.findElement(elementLocator).click();
    }

    public void scrollToElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void fillForm(String orderName, String orderLastName,String orderAdress, By orderMetroSelectLocator,String orderNumber) {
        fillElement(orderNameLocator, orderName);
        fillElement(orderLastNameLocator, orderLastName);
        fillElement(orderAdressLocator, orderAdress);
        elementClick(orderMetroLocator);
        scrollToElement(orderMetroSelectLocator);
        elementClick(orderMetroSelectLocator);
        fillElement(orderPhoneLocator, orderNumber);
        elementClick(orderNextBttnLocator);
    }
}
