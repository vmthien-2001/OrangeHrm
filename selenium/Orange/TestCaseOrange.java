package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseOrange extends Before_Affter {
    @Test
    public void tc1_add_employee() throws InterruptedException {
        boolean ckeck_PIM_list = driver.findElement(By.xpath("//span[text()='PIM']")).isDisplayed();
        if (ckeck_PIM_list) {
            System.out.println("verify success");
            PIM_list.click();
        } else {
            System.out.println("verify fail");
        }

        boolean ckeck_PIM_button = driver.findElement(By.xpath("//div[@class='orangehrm-header-container']//button[@type='button']")).isEnabled();
        if (ckeck_PIM_button) {
            System.out.println("verify success");
            add_PIM_button.click();
        } else {
            System.out.println("verify fail");
        }

        firstName_textbox.sendKeys("Vo");
        middleName_textbox.sendKeys("Minh");
        lastName_textbox.sendKeys("Thien");
        Thread.sleep(3000);

        boolean ckeck_saveAddEmployee_button = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
        if (ckeck_saveAddEmployee_button) {
            System.out.println("verify success");
            saveAddEmployee_button.click();
        } else {
            System.out.println("verify fail");
        }
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
    public void tc3_post(){
        buzz_list.click();
        input_post.sendKeys("new post 2");
        boolean status = post_button.isEnabled();
        if (status) {
            post_button.click();
            boolean ckeck_success = driver.findElement(By.xpath("//div[contains(@class,'oxd-toast-content--success')]")).isDisplayed();
            Assert.assertTrue(ckeck_success, "create new post fail");
            System.out.println("create new post successfully");
        } else {
            System.out.println("create new post fail");
        }
        boolean ckeck_like_post = like_post.isEnabled();
        if (ckeck_like_post) {
            like_post.click();
        }
        boolean ckeck_comment_post = comment_post.isEnabled();
        if (ckeck_comment_post) {
            comment_post.click();
            comment_post_textBox.sendKeys("good");
            comment_post_textBox.sendKeys(Keys.RETURN);
        }
    }


}
