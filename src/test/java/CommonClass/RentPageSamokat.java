package CommonClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentPageSamokat {
    private WebDriver driver;

    private final By rentCalendarLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[1]/div/input");
    private final By rentCalendarDateLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[7]");
    private final By rentDurationLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[1]/div[1]");
    private final By rentDurationPickLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[2]/div[2]/div[1]");
    private final By rentColorLocator = By.xpath("//*[@id=\"black\"]");
    private final By rentCommentLocator = By.xpath("/html/body/div/div/div[2]/div[2]/div[4]/input");
    private final By rentNextLocator = By.xpath("/html/body/div/div/div[2]/div[3]/button[2]");

    public RentPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void fillElement(By elementLocator, String dataToFill) {
        driver.findElement(elementLocator).sendKeys(dataToFill);
    }

    public void elementClick(By elementLocator) {
        driver.findElement(elementLocator).click();
    }

    public void fillForm() {
        elementClick(rentCalendarLocator);
        elementClick(rentCalendarDateLocator);
        elementClick(rentDurationLocator);
        elementClick(rentDurationPickLocator);
        elementClick(rentColorLocator);
        fillElement(rentCommentLocator, "Бла-Бла-Бла");
        elementClick(rentNextLocator);
    }
}
