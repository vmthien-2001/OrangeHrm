package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class login {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, 10);
    @FindBy(xpath = "//input[@name='username']") WebElement input_user;
    @FindBy(xpath = "//input[@name='password']")  WebElement input_password;
    @FindBy(xpath = "//button[@type='submit']")  WebElement submit_button;
    @FindBy(xpath = "//span[text()='Admin']")  WebElement admin_list;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")  WebElement addAdmin_button;
    @FindBy(xpath = "//label[text()='User Role']//..//..//div[@class='oxd-select-text-input']")  WebElement user_role;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")  WebElement employee_name;
    @FindBy(xpath = "//label[text()='Status']//..//..//div[@class='oxd-select-text-input']")  WebElement status;
    @FindBy(xpath = "//label[text()='Username']//..//..//input[@class='oxd-input oxd-input--active']")  WebElement user_name;
    @FindBy(xpath = "//label[text()='Password']//..//..//input[@class='oxd-input oxd-input--active']")  WebElement password;
    @FindBy(xpath = "//label[text()='Confirm Password']//..//..//input[@class='oxd-input oxd-input--active']")  WebElement confirm_password;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")  WebElement save_button;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./bws/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/");

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testLogin() {
        wait.until(ExpectedConditions.visibilityOf(input_user));
        input_user.sendKeys("Admin");
        input_password.sendKeys("admin123");
        submit_button.click();
        admin_list.click();
        addAdmin_button.click();
        user_role.click();

        employee_name.sendKeys("v");
        driver.findElement(By.xpath("//span[text()='Vo  Minh  Thien']")).click();

        status.click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();

        user_name.sendKeys("test01");
        password.sendKeys("t123456");
        confirm_password.sendKeys("t123456");

        save_button.click();

        boolean success = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast-content--success')]")).isDisplayed();
        Assert.assertTrue(success,"create User Admin fail");
        System.out.println("create account successfully");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
