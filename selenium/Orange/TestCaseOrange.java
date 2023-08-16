package Orange;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCaseOrange extends Before_Affter {
    @Test
    public void tc1_add_employee() throws InterruptedException {
        System.out.println("test case 1");
        System.out.println("ckeck clicking to pim ");
        isElementVisible(PIM);
        PIM.click();
        System.out.println("PIM ele is dislay");

        System.out.println("ckeck add PIM button");
        isElementVisible2(add_PIM_button);
        add_PIM_button.click();
        System.out.println("click pim button success");

        System.out.println("ckeck input add employee");
        input_add_employee();
        Thread.sleep(3000);
        System.out.println("input add employee success");

        System.out.println("ckeck saveAddEmployee_button");
        isElementVisible2(saveAddEmployee_button);
        saveAddEmployee_button.click();
        System.out.println("create new employee success");


        ckeckNotification();
        System.out.println("done testcase 1");

    }

    @Test
    public void tc2_add_admin() {
        System.out.println("testcase 2");
        System.out.println("ckeck admin list");
        isElementVisible(admin_list);
        admin_list.click();
        System.out.println("click admin list success");

        System.out.println("ckeck addAdmin button");
        isElementVisible2(addAdmin_button);
        addAdmin_button.click();
        System.out.println("click admin button success");

        System.out.println("check user role display");
        isElementVisible(user_role);
        user_role.click();
        driver.findElement(By.xpath("//div[@class='oxd-select-wrapper']//span[text()='Admin']")).click();
        System.out.println("click admin success");

        System.out.println("ckeck employee name dislay");
        employee_name.sendKeys(name);
        driver.findElement(By.xpath("//span[text()='Vo Minh Thien']")).click();
        System.out.println("click employee name success");

        System.out.println("ckeck status dislay");
        isElementVisible(status);
        status.click();
        driver.findElement(By.xpath("//span[text()='Enabled']")).click();
        System.out.println("click driver success");


        System.out.println("ckeck input add admin");
        input_add_admin();
        System.out.println("input add admin success");



        System.out.println("ckeck save_button");
        isElementVisible2(save_button);
        save_button.click();
        System.out.println("create account successfully");
        ckeckNotification();

        System.out.println("done testcase 2");
    }

    @Test
    public void tc3_post() throws InterruptedException {
        System.out.println("testcase 3");
        System.out.println("ckeck buzz list");
        isElementVisible(buzz_list);
        buzz_list.click();
        System.out.println("click buzz list success");

        System.out.println("ckeck input post dislay");
        isElementVisible(input_post);
        input_post.sendKeys("new post 2");
        System.out.println("input post success");

        System.out.println("ckeck post button");
        isElementVisible2(post_button);
        post_button.click();
        System.out.println("click post button and create new post success");


        System.out.println("ckeck like_post button");
        isElementVisible(like_post);
        like_post.click();
        System.out.println("like post success");

        System.out.println("ckeck comment post dislay");
        isElementVisible(comment_post);
        comment_post.click();
        comment_post_textBox.sendKeys("good");
        comment_post_textBox.sendKeys(Keys.RETURN);
        System.out.println("comment post success");


        ckeckNotification();Thread.sleep(3000);
        System.out.println("done testcase 3");



    }

    @Test
    public void tc4_changePassword(){
        System.out.println("testcase 4");
        System.out.println("ckeck admin list");
        isElementVisible(admin_list);
        admin_list.click();
        System.out.println("click admin list success");

        System.out.println("ckeck user_name textbox dislay");
        isElementVisible(userName_textbox);
        userName_textbox.sendKeys(userName);
        System.out.println("input user_name success");

        System.out.println("ckeck search button");
        isElementVisible2(search_button);
        search_button.click();
        System.out.println("click search button success");

        System.out.println("ckeck edit user");
        isElementVisible2(editUser);
        editUser.click();
        System.out.println("click edit user success");
        ckeckNotification();

        System.out.println("ckeck yes_ckeckbox");
        isElementVisible3(yes_ckeckbox);
        yes_ckeckbox.click();
        System.out.println("ckeck yes_ckeckbox success");

        System.out.println("ckeck input change pass");
        input_changePass();
        System.out.println("input change pass success");

        System.out.println("ckeck save change pass button");
        saveChangePass_button.click();
        System.out.println("click save change pass success");

        ckeckNotification();
        System.out.println("done testcase 4");


    }
}
