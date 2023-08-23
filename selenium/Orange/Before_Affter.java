package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Before_Affter extends Xpath_InputData {
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./bws/chromedriver2.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(input_user));
        login(userName_DF,pass_DF);

    }

    @AfterClass
    public void afterClass() throws InterruptedException {
       logout();
       driver.quit();
    }
}
