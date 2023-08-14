package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCaseOrange extends Xpath {
    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "./bws/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(input_user));
        input_user.sendKeys("Admin");
        input_password.sendKeys("admin123");
        submit_button.click();
    }

    @Test
    public void tc1_add_employee() throws InterruptedException {
        PIM_list.click();
        add_PIM_button.click();
        firstName_textbox.sendKeys("Vo");
        middleName_textbox.sendKeys("Minh");
        lastName_textbox.sendKeys("Thien");
        Thread.sleep(3000);
        saveAddEmployee_button.click();
    }

    @Test
    public void tc2_add_admin() {
        admin_list.click();
        addAdmin_button.click();
        user_role.click();
        driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']//span[text()='Admin']")).click();

        employee_name.sendKeys("thien");
        driver.findElement(By.xpath("//span[text()='Vo Minh Thien']")).click();

        status.click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();

        user_name.sendKeys("test01");
        password.sendKeys("t123456");
        confirm_password.sendKeys("t123456");

        save_button.click();

        boolean success = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast-content--success')]")).isDisplayed();
        Assert.assertTrue(success, "create User Admin fail");

        System.out.println("create account successfully");
    }

    @Test
    public void tc3_post() throws InterruptedException {
        buzz_list.click();
        input_post.sendKeys("new post 2");
        boolean status = post_button.isEnabled();
        if (status == true){
            post_button.click();
            boolean ckeck_success = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast-content--success')]")).isDisplayed();
            Assert.assertTrue(ckeck_success, "create new post fail");
            System.out.println("create new post successfully");
        }else {
            System.out.println("create new post fail");
        }

        like_post.click();
        comment_post.click();
        comment_post_textBox.sendKeys("good");
        comment_post_textBox.sendKeys(Keys.RETURN);

    }


    @AfterClass
    public void afterClass() throws InterruptedException {
        name_dropdown.click();
        logout.click();
        Thread.sleep(1000);
        driver.quit();
    }

}
