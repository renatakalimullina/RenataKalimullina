package homework4;

import homework4.enums.MenuItem;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CreationIssuesTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ViewIssuePage viewIssuePage;

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
        viewIssuePage = new ViewIssuePage(driver);
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

        //Assert left side menu & Click "view_issues" button at the left side menu
        loginPage.selectMenu(MenuItem.VIEW_ISSUES);
    }

    @Test(priority = 3)
    public void filterSelection() {

        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.VIEW_ISSUES);

        //set filter values
        viewIssuePage.setPriority();
        viewIssuePage.setSeverity();
        viewIssuePage.setStatus();
        viewIssuePage.filterByDateSubmitted();
        viewIssuePage.chooseStartDay();
        viewIssuePage.chooseStartMonth();
        viewIssuePage.chooseStartYear();
        viewIssuePage.chooseEndDay();
        viewIssuePage.chooseEndMonth();
        viewIssuePage.chooseEndYear();
    }

    @Test(priority = 4)
    public void clickApplyFilter() {

        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.VIEW_ISSUES);

        viewIssuePage.setPriority();
        viewIssuePage.setSeverity();
        viewIssuePage.setStatus();
        viewIssuePage.filterByDateSubmitted();
        viewIssuePage.chooseStartDay();
        viewIssuePage.chooseStartMonth();
        viewIssuePage.chooseStartYear();
        viewIssuePage.chooseEndDay();
        viewIssuePage.chooseEndMonth();
        viewIssuePage.chooseEndYear();

        //Click Apply Filter
        viewIssuePage.clickApplyFilter();
    }

    @Test(priority = 5)
    public void checkResults() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.VIEW_ISSUES);
        viewIssuePage.setPriority();
        viewIssuePage.setSeverity();
        viewIssuePage.setStatus();
        viewIssuePage.filterByDateSubmitted();
        viewIssuePage.chooseStartDay();
        viewIssuePage.chooseStartMonth();
        viewIssuePage.chooseStartYear();
        viewIssuePage.chooseEndDay();
        viewIssuePage.chooseEndMonth();
        viewIssuePage.chooseEndYear();
        viewIssuePage.clickApplyFilter();

        //Check results
        assertEquals(viewIssuePage.getIssuesNumber(), "1 - 2 / 2");
    }

    @Test(priority = 6)
    public void logout() {
        loginPage.login("administrator", "rootroot");
        loginPage.selectMenu(MenuItem.VIEW_ISSUES);
        viewIssuePage.setPriority();
        viewIssuePage.setSeverity();
        viewIssuePage.setStatus();
        viewIssuePage.filterByDateSubmitted();
        viewIssuePage.chooseStartDay();
        viewIssuePage.chooseStartMonth();
        viewIssuePage.chooseStartYear();
        viewIssuePage.chooseEndDay();
        viewIssuePage.chooseEndMonth();
        viewIssuePage.chooseEndYear();
        viewIssuePage.clickApplyFilter();
        assertEquals(viewIssuePage.getIssuesNumber(), "1 - 2 / 2");


        //Logout
        viewIssuePage.logout();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {

        // Close driver
        driver.close();
    }


}
