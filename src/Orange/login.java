package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./bws/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(2000);
        WebElement user= driver.findElement(By.xpath("//input[@name='username']"));
        user.sendKeys("Admin");
        WebElement pass= driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement admin = driver.findElement(By.xpath("//span[text()='Admin']"));
        admin.click();Thread.sleep(2000);
        WebElement add=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
        add.click();
    }
}
