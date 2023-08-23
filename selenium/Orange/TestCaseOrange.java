package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCaseOrange extends Before_Affter {
    @Test
    public void tc1_add_employee() throws InterruptedException {
        navigateToPIMTab();
        searchEmployee();
        if (checkTheEmployeeIsExist()){
            deleteEmployee();
            addEmployee();
        }else {
            addEmployee();
        }
        navigateToPIMTab();
        searchEmployee();
        if (checkTheEmployeeIsExist()){
            System.out.println("create new employee success");
        }else {
            System.out.println("create new employee fail");
        }
    }

    @Test
    public void tc2_add_admin() throws InterruptedException {
        System.out.println("testcase 2");
       // inputEmployee();
        System.out.println("check that after entering the name, the name just entered is displayed");
        try {
            boolean check = driver.findElement(By.xpath("//span[text()='" + name + "']")).isDisplayed();
            if (check) {
                create_newAdmin();
                System.out.println("done testcase 2");
            }
        } catch (NoSuchElementException e) {
            addEmployee();
            create_newAdmin();
            System.out.println("done testcase 2");
        }

    }

    @Test
    public void tc3_post() throws InterruptedException {
        System.out.println("testcase 3");
        isElementVisible(buzz_list);
        buzz_list.click();

        isElementVisible(input_post);
        input_post.sendKeys("new post 2");

        isElementEnableToBeClick(post_button);
        post_button.click();


        isElementVisible(like_post);
        like_post.click();


        isElementVisible(comment_post);
        comment_post.click();
        comment_post_textBox.sendKeys("good");
        comment_post_textBox.sendKeys(Keys.RETURN);

        checkNotification();
        Thread.sleep(3000);
        System.out.println("done testcase 3");


    }

    @Test
    public void tc4_changePassword() throws InterruptedException {
        System.out.println("testcase 4");

        isElementVisible(admin_list);
        admin_list.click();

        isElementVisible(userName_textbox);
        userName_textbox.sendKeys(userName);

        isElementEnableToBeClick(search_button);
        search_button.click();

        System.out.println("check clicking to edit user");
        driver.findElement(By.xpath("//div[text()='" + userName +
                "']//..//..//i[@class='oxd-icon bi-pencil-fill']")).click();
        System.out.println("edit user is displayed");
        checkNotification();

        isElementVisible3(yes_checkbox);
        yes_checkbox.click();

        input_changePass();
        saveChangePass_button.click();

        checkNotification();
        logout();
        login(userName, pass_change);
        System.out.println("done testcase 4");
    }

    @Test
    public void tc5_delete_account() throws InterruptedException {
        System.out.println("testcase 5");
        logout();
        login(userName_DF, pass_DF);
        Thread.sleep(1000);
        admin_list.click();
        try {
            System.out.println("check clicking to textbox username");
            username_textbox.sendKeys(userName);
            searchAdmin_button.click();
            System.out.println("textbox username is displayed");
            driver.findElement(By.xpath("//div[text()='" + userName + "']//..//..//i[@class='oxd-icon bi-trash']")).click();
            driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();
            System.out.println("delete account success");
        } catch (NoSuchElementException e) {
            System.out.println("Can't find the account to delete");
        }
        System.out.println("done testcase 5");

    }
}
