import CommonClass.MainPageSamokat;
import CommonClass.OrderPageSamokat;
import CommonClass.OrderSuccessPageSamokat;
import CommonClass.RentPageSamokat;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;
    private final String orderName;
    private final String orderLastName;
    private final String orderAdress;
    private final By orderMetroSelectLocator;
    private final String orderNumber;
    private final By orderButton;

    public OrderTest(By orderButton, String orderName, String orderLastName, String orderAdress, By orderMetroSelectLocator, String orderNumber) {
        this.orderButton = orderButton;
        this.orderName = orderName;
        this.orderLastName = orderLastName;
        this.orderAdress = orderAdress;
        this.orderMetroSelectLocator = orderMetroSelectLocator;
        this.orderNumber = orderNumber;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {By.xpath(".//div[1]/div[2]/button[1]"), "Иван", "Иванович", "Москва, Пушкина 24, 4", By.xpath(".//li[72]/button"), "+7916123456"},
                {By.xpath(".//div[4]/div[2]/div[5]/button"), "Петр", "Петрович", "Москва, Ломоносова 15, 243", By.xpath(".//li[116]/button"), "+7940654321"},
        };
    }

    @Test
    public void TestClassChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageSamokat objMainPageChrome = new MainPageSamokat(driver);
        OrderPageSamokat objOrderPageChrome = new OrderPageSamokat(driver);
        RentPageSamokat objRentPageChrome = new RentPageSamokat(driver);
        OrderSuccessPageSamokat objOrderSuccessChrome = new OrderSuccessPageSamokat(driver);

        //Нажатие на кнопку заказа
        objMainPageChrome.scrollToElement(orderButton);
        objMainPageChrome.elementClick(orderButton);

        //Заполнение формы "для кого".
        objOrderPageChrome.fillForm(orderName, orderLastName, orderAdress, orderMetroSelectLocator, orderNumber);

        //Заполнение формы "про аренду".
        objRentPageChrome.fillForm();

        //Проверка попапа с сообщением об успешном создании заказа.
        objOrderSuccessChrome.PopupCheck();
    }

    @Test
    public void TestClassFox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");

        driver = new FirefoxDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageSamokat objMainPageFox = new MainPageSamokat(driver);
        OrderPageSamokat objOrderPageFox = new OrderPageSamokat(driver);
        RentPageSamokat objRentPageFox = new RentPageSamokat(driver);
        OrderSuccessPageSamokat objOrderSuccessFox = new OrderSuccessPageSamokat(driver);

        //Нажатие на кнопку заказа.
        objMainPageFox.scrollToElement(orderButton);
        objMainPageFox.elementClick(orderButton);

        //Заполнение формы "для кого".
        objOrderPageFox.fillForm(orderName, orderLastName, orderAdress, orderMetroSelectLocator, orderNumber);

        //Заполнение формы "про аренду".
        objRentPageFox.fillForm();

        //Проверка попапа с сообщением об успешном создании заказа.
        objOrderSuccessFox.PopupCheck();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}