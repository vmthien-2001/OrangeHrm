package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class loginPage {
    WebDriver driver = new WebDriver() {
        @Override
        public void get(String s) {
        }

        @Override
        public String getCurrentUrl() {
            return null;
        }

        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public List<WebElement> findElements(By by) {
            return null;
        }

        @Override
        public WebElement findElement(By by) {
            return null;
        }

        @Override
        public String getPageSource() {
            return null;
        }

        @Override
        public void close() {

        }

        @Override
        public void quit() {

        }

        @Override
        public Set<String> getWindowHandles() {
            return null;
        }

        @Override
        public String getWindowHandle() {
            return null;
        }

        @Override
        public TargetLocator switchTo() {
            return null;
        }

        @Override
        public Navigation navigate() {
            return null;
        }

        @Override
        public Options manage() {
            return null;
        }
    };
    WebDriverWait wait = new WebDriverWait(driver, 10);
    //xpath for login
    @FindBy(xpath = "//input[@name='username']")
    WebElement input_user;
    @FindBy(xpath = "//input[@name='password']")
    WebElement input_password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit_button;
    //xpath for PIM
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement PIM_list;
    @FindBy(xpath = "//div[@class='orangehrm-header-container']//button[@type='button']")
    WebElement add_PIM_button;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName_textbox;
    @FindBy(xpath = "//input[@name='middleName']")
    WebElement middleName_textbox;
    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName_textbox;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveAddEmployee_button;

    //xpath for admin
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement admin_list;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addAdmin_button;
    @FindBy(xpath = "//label[text()='User Role']//..//..//div[@class='oxd-select-text-input']")
    WebElement user_role;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employee_name;
    @FindBy(xpath = "//label[text()='Status']//..//..//div[@class='oxd-select-text-input']")
    WebElement status;
    @FindBy(xpath = "//label[text()='Username']//..//..//input[@class='oxd-input oxd-input--active']")
    WebElement user_name;
    @FindBy(xpath = "//label[text()='Password']//..//..//input[@class='oxd-input oxd-input--active']")
    WebElement password;
    @FindBy(xpath = "//label[text()='Confirm Password']//..//..//input[@class='oxd-input oxd-input--active']")
    WebElement confirm_password;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement save_button;



    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./bws/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    @Test
    public void testLogin() {
        wait.until(ExpectedConditions.visibilityOf(input_user));
        input_user.sendKeys("Admin");
        input_password.sendKeys("admin123");
        submit_button.click();



        PIM_list.click();
        add_PIM_button.click();
        firstName_textbox.sendKeys("Vo");
        middleName_textbox.sendKeys("Minh");
        lastName_textbox.sendKeys("Thien");
        saveAddEmployee_button.click();




        admin_list.click();
        addAdmin_button.click();
        user_role.click();
        driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']//span[text()='Admin']")).click();

        employee_name.sendKeys("thien");
        driver.findElement(By.xpath("//span[text()='Vo Minh Thien']")).click();

        status.click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();

        user_name.sendKeys("test02");
        password.sendKeys("t123456");
        confirm_password.sendKeys("t123456");

        save_button.click();

        boolean success = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast-content--success')]")).isDisplayed();
        Assert.assertTrue(success, "create User Admin fail");
        System.out.println("create account successfully");
    }

    /*@Test
    public void PIM() {


    }

    @Test
    public void admin() {

    }*/

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
