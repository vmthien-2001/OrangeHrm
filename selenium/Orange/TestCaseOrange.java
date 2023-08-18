package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCaseOrange extends Before_Affter {
    @Test
    public void tc1_add_employee() throws InterruptedException {
        System.out.println("test case 1");
        addEmployee();
        System.out.println("done testcase 1");

    }

    @Test
    public void tc2_add_admin() throws InterruptedException {
        System.out.println("testcase 2");
        System.out.println("check clicking to pim ");
        isElementVisible(PIM);
        PIM.click();
        System.out.println("PIM ele is displayed");

        System.out.println("check clicking to input employee name");
        employeeName_textbox.sendKeys(name);
        System.out.println("input employee name is displayed");

        System.out.println("check that after entering the name, the name just entered is displayed");
        try {
            boolean check =driver.findElement(By.xpath("//span[text()='"+name+"']")).isDisplayed();
            if (check){
                create_newAdmin();
                System.out.println("done testcase 2");
            }
        }catch (NoSuchElementException e){
            addEmployee();
            create_newAdmin();
            System.out.println("done testcase 2");
        }

    }

    @Test
    public void tc3_post() throws InterruptedException {
        System.out.println("testcase 3");
        System.out.println("check clicking to buzz list");
        isElementVisible(buzz_list);
        buzz_list.click();
        System.out.println("buzz list is displayed");

        System.out.println("clicking to input post");
        isElementVisible(input_post);
        input_post.sendKeys("new post 2");
        System.out.println("input post is displayed");

        System.out.println("check clicking to post button");
        isElementVisible2(post_button);
        post_button.click();
        System.out.println("post button is displayed");


        System.out.println("check clicking to like_post button");
        isElementVisible(like_post);
        like_post.click();
        System.out.println("like post is displayed");


        System.out.println("check clicking to comment post");
        isElementVisible(comment_post);
        comment_post.click();
        comment_post_textBox.sendKeys("good");
        comment_post_textBox.sendKeys(Keys.RETURN);
        System.out.println("comment post is displayed");

        checkNotification();
        Thread.sleep(3000);
        System.out.println("done testcase 3");


    }

    @Test
    public void tc4_changePassword() throws InterruptedException {
        System.out.println("testcase 4");
        System.out.println("check clicking to admin list");
        isElementVisible(admin_list);
        admin_list.click();
        System.out.println("admin list is displayed");

        System.out.println("check clicking to user_name");
        isElementVisible(userName_textbox);
        userName_textbox.sendKeys(userName);
        System.out.println("user_name is displayed");

        System.out.println("check clicking to search button");
        isElementVisible2(search_button);
        search_button.click();
        System.out.println("search button is displayed");

        System.out.println("check clicking to edit user");
        driver.findElement(By.xpath("//div[text()='" + userName +
                "']//..//..//i[@class='oxd-icon bi-pencil-fill']")).click();
        System.out.println("edit user is displayed");
        checkNotification();

        System.out.println("check clicking to yes_checkbox");
        isElementVisible3(yes_checkbox);
        yes_checkbox.click();
        System.out.println(" yes_checkbox is displayed");

        System.out.println("check clicking to change pass");
        input_changePass();
        System.out.println("change pass is displayed");

        System.out.println("check clicking to save change pass button");
        saveChangePass_button.click();
        System.out.println("save change pass button is displayed");

        checkNotification();
        logout();
        login(userName,pass_change);
        System.out.println("done testcase 4");


    }

    @Test
    public void tc5_delete_account() throws InterruptedException {

        logout();login(userName_DF,pass_DF);Thread.sleep(1000);
        admin_list.click();
        try{
            System.out.println("check clicking to textbox username");
            username_textbox.sendKeys(userName);
            searchAdmin_button.click();
            System.out.println("textbox username is displayed");
            driver.findElement(By.xpath("//div[text()='"+userName+"']//..//..//i[@class='oxd-icon bi-trash']")).click();
            driver.findElement(By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']")).click();
            System.out.println("delete account success");
       }catch (NoSuchElementException e){
            System.out.println("Can't find the account to delete");
        }


}}
