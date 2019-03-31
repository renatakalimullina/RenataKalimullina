package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class MantisTest extends Assert {
    @Test
    public void openMantisBt() {

        //Init driver
        System.setProperty("webdriver.chrome.driver",
                Objects.requireNonNull(this.getClass().getClassLoader()
                        .getResource("webdriver/chrome/chromedriver.exe")).getPath());
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        //Open test site by URL
        driver.get("https://mantis.tiulp.in/login_page.php");
        assertEquals(driver.getTitle(), "MantisBT");



        //Assert Browser title
        assertEquals(driver.getTitle(), "MantisBT");



        //Perform login
        driver.findElement(By.id("username")).sendKeys("administrator");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.id("password")).sendKeys("rootroot");
        driver.findElement(By.xpath("//input[@value='Login']")).click();



        //Assert User name in the right-top side of screen that user is loggined
        assertEquals(driver.findElement(By.className("user-info")).getText(),
                "administrator");



        //Assert left side menu
        driver.findElement(By.xpath("//*[@id='sidebar']"));



        //Click "Manage" button at the left side menu
        driver.findElement(By.partialLinkText("Manage")).click();



        //Click "Manage Projects" button at the top menu on the "Manage MantisBT" page
        driver.findElement(By.partialLinkText("Manage Projects")).click();



        //Check "Create New Project" button
        driver.findElement(By.xpath("//button[contains(text(),'Create New Project')]"));



        //Click "Create New Projects" button
        driver.findElement(By.xpath("//button[contains(text(),'Create New Project')]")).click();



        //Check fields on the "Add Project" view
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(), "* Project Name");
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), "Status");
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), "Inherit Global Categories");
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), "View Status");
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), "Description");



        //Fill Project inforamtion
        driver.findElement(By.id("project-name")).sendKeys("Anything");

        Select dropdown1 = new Select(driver.findElement(By.id("project-status")));
        dropdown1.selectByValue("10");

        driver.findElement(By.className("lbl")).click();

        Select dropdown2 = new Select(driver.findElement(By.id("project-view-state")));
        dropdown2.selectByValue("10");

        driver.findElement(By.id("project-description")).sendKeys("AnythingAnything");



        //Click "Add Project" button
        driver.findElement(By.xpath("//input[@value='Add Project']")).click();



        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[@href='/logout_page.php']")).click();

        //Close driver
        driver.close();
    }
}
