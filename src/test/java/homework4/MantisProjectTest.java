package homework4;

import homework4.enums.MenuItem;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;


public class MantisProjectTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ManagePage managePage;
    private CreatingProjectPage creatingProjectPage;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open test site by URL
        driver.get("https://mantis.tiulp.in/login_page.php");
        loginPage = new LoginPage(driver);
        managePage = new ManagePage(driver);
        creatingProjectPage = new CreatingProjectPage(driver);
    }

    @Test(priority = 1)
    public void login() {
        // Check title
        assertEquals(loginPage.getPageTitle(), "MantisBT");

        // Login
        loginPage.login("administrator", "rootroot");

        // Check login
        assertEquals(driver.getTitle(), "My View - MantisBT");
        assertEquals(loginPage.getLoggedUser(), "administrator");
    }

    @Test(priority = 2)
    public void leftSideBar() {
        loginPage.login("administrator", "rootroot");

        //Assert left side menu & Click "Manage" button at the left side menu
        loginPage.selectMenu(MenuItem.MANAGE);
    }

    @Test(priority = 3)
    public void selectionManage() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);

        //Click "Manage Projects" button at the top menu on the "Manage MantisBT" page
        managePage.selectManageProject();
    }

    @Test(priority = 4)
    public void createNewProject() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageProject();

        //Create New Project
        managePage.creatingNewProject();
    }

    @Test(priority = 5)
    public void checkFields() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageProject();
        managePage.creatingNewProject();

        //Check fields on the "Create New Project" view
        //creatingProjectPage.checkFields();
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(), "* Project Name");
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), "Status");
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), "Inherit Global Categories");
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), "View Status");
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), "Description");
    }

    @Test(priority = 6)
    public void fillProjectInformation() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageProject();
        managePage.creatingNewProject();

        //Fill project information
        creatingProjectPage.fillInfo();
    }


    @Test(priority = 7)
    public void addProject() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageProject();
        managePage.creatingNewProject();
        creatingProjectPage.fillInfo();

        //Click "Add Project" button
        creatingProjectPage.addProject();
    }

    @Test(priority = 8)
    public void logout() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageProject();
        managePage.creatingNewProject();
        creatingProjectPage.fillInfo();
        creatingProjectPage.addProject();

        //Logout
        managePage.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {

        // Close driver
        driver.close();
    }
}
