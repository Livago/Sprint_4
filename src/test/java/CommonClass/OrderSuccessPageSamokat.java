package CommonClass;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderSuccessPageSamokat {

    private WebDriver driver;

    private final By orderSuccessFormLocator = By.className("Order_ModalHeader__3FDaJ");

    public OrderSuccessPageSamokat(WebDriver driver) {
        this.driver = driver;
    }

    public void OrderPopupWaitSamokat() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("Order_ModalHeader__3FDaJ")));
    }

    public void CheckForm() {
        Assert.assertTrue(driver.findElement(orderSuccessFormLocator).isEnabled());
    }

    public void CheckFormText() {
        Assert.assertEquals("Заказ оформлен",driver.findElement(orderSuccessFormLocator).getText());
    }

    public void PopupCheck(){
        OrderPopupWaitSamokat();
        CheckForm();
        CheckFormText();
    }

}
