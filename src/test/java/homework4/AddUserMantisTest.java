package homework4;

import homework4.enums.MenuItem;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static homework4.enums.ManageMenuItem.MANAGE_USERS;
import static org.testng.AssertJUnit.assertEquals;


// TODO Зачем используется приоритезация?
// TODO В задании было сказанно, что это много тестов?
// Исправлено

public class AddUserMantisTest extends BaseClassForTests{

    // TODO Должно быть в базовом классе
    // Исправлено все, что должно быть в базвом классе

    @Test
    public void addUser() {
        // Check title
        // TODO Не должно быть захордкоженных данных
        // Исправлено
        assertEquals(loginPage.getPageTitle(), properties.getProperty("mainTitleName"));

        // Login
        // TODO пользователь должен быть вынесен в проперти файл
        // Исправлено
        loginPage.login(properties.getProperty("adminName"), properties.getProperty("adminPassword"));

        // Check login
        assertEquals(driver.getTitle(), properties.getProperty("titleName"));
        assertEquals(loginPage.getLoggedUser(), properties.getProperty("adminName"));

         //Assert left side menu & Click "Manage" button at the left side menu
        loginPage.selectMenu(MenuItem.MANAGE);

        //Click "Manage Users" button at the top menu on the "Manage MantisBT" page
        managePage.clickManageMenuItem(MANAGE_USERS);

        //Create New Account
        creatingUsersPage.creatingNewUsers();

        //Check fields on the "Create New Account" view
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(),  properties.getProperty("newUserNameForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), properties.getProperty("newUserRealNameForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), properties.getProperty("newUserEmailForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), properties.getProperty("newUserPasswordForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), properties.getProperty("newUSerVerifyPasswordForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[6]/td[@class='category']")).getText(), properties.getProperty("newUserAccesLevelForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[7]/td[@class='category']")).getText(), properties.getProperty("newUserEnabledForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[8]/td[@class='category']")).getText(), properties.getProperty("newUserProtectedForCheck"));

        //Fill user information
        creatingUsersPage.fillInfo(properties.getProperty("newUserName"), properties.getProperty("newUserRealName"), properties.getProperty("newUserEmail"), properties.getProperty("newUserPassword"));

        //Click "Create User" button
        creatingUsersPage.addUser();

        //Logout
        loginPage.logout();
    }
}
