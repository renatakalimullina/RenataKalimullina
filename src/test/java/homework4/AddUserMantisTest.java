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


// TODO Зачем используется приоритезация?
// TODO В задании было сказанно, что это много тестов?
public class AddUserMantisTest {

    // TODO Должно быть в базовом классе
    private WebDriver driver;
    private LoginPage loginPage;
    private ManagePage managePage;
    private CreatingUsersPage creatingUsersPage;

    // TODO Должно быть в базовом классе
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().setup();
    }

    // TODO Должно быть в базовом классе
    @BeforeMethod(alwaysRun = true)
    public void initDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open test site by URL
        driver.get("https://mantis.tiulp.in/login_page.php");
        loginPage = new LoginPage(driver);
        managePage = new ManagePage(driver);
        creatingUsersPage = new CreatingUsersPage(driver);
    }

    @Test(priority = 1)
    public void login() {
        // Check title
        // TODO Не должно быть захордкоженных данных
        assertEquals(loginPage.getPageTitle(), "MantisBT");

        // Login
        // TODO пользователь должен быть вынесен в проперти файл
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

        //Click "Manage Users" button at the top menu on the "Manage MantisBT" page
        managePage.selectManageUsers();
    }

    @Test(priority = 4)
    public void createNewUsers() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageUsers();

        //Create New Account
        managePage.creatingNewUsers();
    }

    @Test(priority = 5)
    public void checkFields() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageUsers();
        managePage.creatingNewUsers();

        //Check fields on the "Create New Account" view
        //creatingUsersPage.checkFields();
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(), "Username");
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), "Real Name");
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), "E-mail");
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), "Password");
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), "Verify Password");
        assertEquals(driver.findElement(By.xpath("//tr[6]/td[@class='category']")).getText(), "Access Level");
        assertEquals(driver.findElement(By.xpath("//tr[7]/td[@class='category']")).getText(), "Enabled");
        assertEquals(driver.findElement(By.xpath("//tr[8]/td[@class='category']")).getText(), "Protected");
    }

    @Test(priority = 6)
    public void fillUsersInformation() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageUsers();
        managePage.creatingNewUsers();

        //Fill user information
        creatingUsersPage.fillInfo();
    }

    @Test(priority = 7)
    public void addUsers() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageUsers();
        managePage.creatingNewUsers();
        creatingUsersPage.fillInfo();

        //Click "Create User" button
        creatingUsersPage.addUser();
    }

    @Test(priority = 8)
    public void logout() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.MANAGE);
        managePage.selectManageUsers();
        managePage.creatingNewUsers();
        creatingUsersPage.fillInfo();
        creatingUsersPage.addUser();

        //Logout
        managePage.logout();
    }

// TODO Должно быть в базовом классе
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {

        // Close driver
        driver.close();
    }
}
