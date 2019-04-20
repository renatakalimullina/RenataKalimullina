package homework4;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClassForTests {

    static  WebDriver driver;
    static  LoginPage loginPage;
    static  ManagePage managePage;
    static  CreatingUsersPage creatingUsersPage;
    static ViewIssuePage viewIssuePage;
    static CreatingProjectPage creatingProjectPage;

    FileInputStream propertiesFile;
    Properties properties = new Properties();

    BaseClassForTests()
    {
        try {
            propertiesFile = new FileInputStream("src/test/resources/homework4.properties");
            properties.load(propertiesFile);

        } catch (IOException e) {
            System.err.println("Файл свойств отсуствует");
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void initDriver() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open test site by URL
        driver.get(properties.getProperty("url"));
        loginPage = new LoginPage(driver);
        managePage = new ManagePage(driver);
        creatingUsersPage = new CreatingUsersPage(driver);
        viewIssuePage = new ViewIssuePage(driver);
        creatingProjectPage = new CreatingProjectPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        // Close driver
        driver.close();
    }
}
