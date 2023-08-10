package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./bws/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        WebElement user = driver.findElement(By.xpath("//input[@name='username']"));
        user.sendKeys("Admin");
        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement admin = driver.findElement(By.xpath("//span[text()='Admin']"));
        admin.click();
        Thread.sleep(2000);
        WebElement add = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
        add.click();
        Thread.sleep(2000);
        WebElement user_role = driver.findElement(By.xpath("//label[text()='User Role']//..//..//div[@class='oxd-select-text-input']"));
        user_role.click();
        driver.findElement(By.xpath("//div[@role='listbox']//span[text()='Admin']")).click();
        WebElement employee_name=driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        employee_name.sendKeys("t");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Vo Minh Thien']")).click();

        WebElement status = driver.findElement(By.xpath("//label[text()='Status']//..//..//div[@class='oxd-select-text-input']"));
        status.click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();

        WebElement user_name = driver.findElement(By.xpath("//label[text()='Username']//..//..//input[@class='oxd-input oxd-input--active']"));
        user_name.sendKeys("test03");
        WebElement password_add = driver.findElement(By.xpath("//label[text()='Password']//..//..//input[@class='oxd-input oxd-input--active']"));
        password_add.sendKeys("t123456");
        WebElement confirm_password_add = driver.findElement(By.xpath("//label[text()='Confirm Password']//..//..//input[@class='oxd-input oxd-input--active']"));
        confirm_password_add.sendKeys("t123456");

        WebElement save = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        save.click();

        boolean success = driver.findElement(By.xpath("//p[text()='Success']")).isDisplayed();
        if(success == true){
            System.out.println("create account successfully");
        }        driver.quit();

    }
}
