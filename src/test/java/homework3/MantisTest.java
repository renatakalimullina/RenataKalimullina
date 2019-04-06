package homework3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Objects;


public class MantisTest extends Assert {


    private WebDriver driver;
    private POVoid POVoid;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(this.getClass().getClassLoader()
                        .getResource("webdriver/chrome/chromedriver.exe")).getPath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open test site by URL
        driver.get("https://mantis.tiulp.in/login_page.php");
        POVoid = new POVoid(driver);
    }

    @Test
    public void addUser() {

        //Assert Browser title
        assertEquals(driver.getTitle(), "MantisBT");

        //Perform login
        POVoid.login("administrator", "rootroot");

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals(POVoid.getLoggedUser(), "administrator");


        //Assert left side menu & Click "Manage" button at the left side menu
        //Click "Manage Projects" button at the top menu on the "Manage MantisBT" page
        POVoid.leftMenuSelection("Manage", "Manage Projects");

        //Create New Project
        driver.findElement(By.xpath("//button[contains(text(),'Create New Project')]")).click();
        //Check fields on the "Create New Project" view
        String[] fields = new String[6];
        fields[1] = "* Project Name";
        fields[2] = "Status";
        fields[3] = "Inherit Global Categories";
        fields[4] = "View Status";
        fields[5] = "Description";
        for(Integer i = 1; i < 6; i++)
            POVoid.checkFields(i, fields[i]);


        //Fill project information
        POVoid.userInformation("project-name", "Anything");
        POVoid.selectButton("project-status", "1");
        POVoid.clickButtonByClassName("lbl");
        POVoid.selectButton("project-view-state", "1");
        POVoid.userInformation("project-description", "AnythingAnything");

        //Click "Add Project" button
        POVoid.clickButtonByXpath("input", "Add Project");

        //Logout
        POVoid.clickButtonByClassName("user-info");
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        // Close driver
         driver.close();
    }
}
