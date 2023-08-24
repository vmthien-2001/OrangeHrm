package Orange;

import org.testng.annotations.Test;


public class TestCaseOrange extends Before_Affter {
    @Test
    public void tc1_AddEmployee() throws InterruptedException {
        navigateToPIMTab();
        searchEmployee();
        if (checkTheUserIsExist()) {
            deleteEmployee();
            addEmployee();
        }else {
            addEmployee();
        }
        navigateToPIMTab();
        searchEmployee();
        if (checkTheUserIsExist()) {
            System.out.println("create new employee success");
        }else {
            System.out.println("create new employee fail");
        }
    }

    @Test
    public void tc2_AddAdmin() throws InterruptedException {
        navigateToAdminTab();
        searchAdminUser();
        if(checkTheUserIsExist())
        {
            System.out.println("Admin user is existed, will delete");
            deleteUser();
            createAdminUser();
        }else{
            createAdminUser();
        }
        System.out.println("verify User admin created -- start");
        logout();
        isAdminUserCreated();
        System.out.println("verify User admin created -- success");
    }

    @Test
    public void tc3_changePassword() throws InterruptedException {
        navigateToAdminTab();
        searchAdminUser();
        if (checkTheUserIsExist()) {
            System.out.println("the user is existed, will change the password");
            editUser();
            changePass();
        } else {
            System.out.println("the user is not existed, create user admin");
            tc2_AddAdmin();
            navigateToAdminTab();
            searchAdminUser();
            editUser();
            changePass();
        }
        System.out.println("verify User changed pass -- start");
        logout();
        isUserChangedPasswordSuccess();
        System.out.println("verify User changed pass -- success");
    }

    @Test
    public void tc4_deleteUser() throws InterruptedException {
        navigateToAdminTab();
        searchAdminUser();
        if(checkTheUserIsExist())
        {
            System.out.println("Admin user is existed, will delete");
            deleteUser();
        }else{
            System.out.println("Admin user is not existed, create new user");
            createAdminUser();
            /*System.out.println("verify User admin created -- start");
            logout();
            isAdminUserCreated();
            System.out.println("verify User admin created -- success");
            logout();
            login(userName_DF,pass_DF);*/
            navigateToAdminTab();
            searchAdminUser();
            checkTheUserIsExist();Thread.sleep(2000);
            deleteUser();
        }
        System.out.println("verify User delete -- start");
        navigateToAdminTab();
        searchAdminUser();
        if (checkTheUserIsExist()){
            System.out.println("delete fail");
        }else {
            System.out.println("delete true");
        }
        System.out.println("verify User delete -- success");
    }
}
