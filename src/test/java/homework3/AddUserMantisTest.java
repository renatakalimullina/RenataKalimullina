package homework3;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.AssertJUnit.assertEquals;


public class AddUserMantisTest {

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
        //Click "Manage Users" button at the top menu on the "Manage MantisBT" page
        POVoid.leftMenuSelection("Manage", "Manage Users");

        //Create New Account
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();
        //Check fields on the "Create New Account" view
        String[] fields = new String[9];
        fields[1] = "Username";
        fields[2] = "Real Name";
        fields[3] = "E-mail";
        fields[4] = "Password";
        fields[5] = "Verify Password";
        fields[6] = "Access Level";
        fields[7] = "Enabled";
        fields[8] = "Protected";
        for(Integer i = 1; i < 9; i++)
            POVoid.checkFields(i, fields[i]);



        //Fill user information
        POVoid.userInformation("user-username", "someone");
        POVoid.userInformation("user-realname", "Renata");
        POVoid.userInformation("email-field", "AnythingAnything@mail.ru");
        POVoid.userInformation("user-password", "qwerty");
        POVoid.userInformation("user-verify-password", "qwerty");
        POVoid.selectButton("user-access-level", "2");

        //Click "Create User" button
        POVoid.clickButtonByXpath("input", "Create User");

        //Logout
        POVoid.clickButtonByClassName("user-info");
        driver.findElement(By.xpath("//a[contains(text(), 'Logout')]")).click();

        //Login under created user
        POVoid.login("someone", "qwerty");

        //Assert User name in the right-top side of screen that user is loggined
        assertEquals(POVoid.getLoggedUser(), "someone");

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
