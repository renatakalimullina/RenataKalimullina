package homework4;

import homework4.enums.MenuItem;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static homework4.enums.ManageMenuItem.MANAGE_PROJECTS;
import static org.testng.AssertJUnit.assertEquals;


public class MantisProjectTest extends BaseClassForTests{

    @Test
    public void addProject() {
        // Check title
        assertEquals(loginPage.getPageTitle(), properties.getProperty("mainTitleName"));

        // Login
        loginPage.login(properties.getProperty("adminName"), properties.getProperty("adminPassword"));

        // Check login
        assertEquals(driver.getTitle(), properties.getProperty("titleName"));
        assertEquals(loginPage.getLoggedUser(), properties.getProperty("adminName"));

        //Assert left side menu & Click "Manage" button at the left side menu
        loginPage.selectMenu(MenuItem.MANAGE);

        //Click "Manage Projects" button at the top menu on the "Manage MantisBT" page
        managePage.clickManageMenuItem(MANAGE_PROJECTS);//managePage.selectManageProject();

        //Create New Project
        creatingProjectPage.creatingNewProject();
        //managePage.creatingNewProject();

        //Check fields on the "Create New Project" view
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(), properties.getProperty("newProjectNameForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), properties.getProperty("newProjectStatusForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), properties.getProperty("newProjectCategoriesForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), properties.getProperty("newProjectViewStatusForCheck"));
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), properties.getProperty("newProjectDescriptionForCheck"));

        //Fill project information
        creatingProjectPage.fillInfo(properties.getProperty("newProjectName"), properties.getProperty("newProjectDescription"));

        //Click "Add Project" button
        creatingProjectPage.addProject();

        //Logout
        loginPage.logout();
    }
}
