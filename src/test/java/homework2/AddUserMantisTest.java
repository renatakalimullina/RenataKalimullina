package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.testng.AssertJUnit.assertEquals;

// TODO Обязетельно ли данное наследование?
public class AddUserMantisTest {

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
        assertEquals(driver.findElement(By.className("user-info")).getText(), "administrator");



        //Assert left side menu
        driver.findElement(By.xpath("//*[@id='sidebar']"));



        //Click "Manage" button at the left side menu
        driver.findElement(By.partialLinkText("Manage")).click();



        //Click "Manage Users" button at the top menuon the "Manage MantisBT" page
        driver.findElement(By.partialLinkText("Manage Users")).click();



        //Check "Create New Account" button
        // TODO не совсем понятно у какая это кнопка
        driver.findElement(By.xpath("//div[@class='pull-left']"));



        //Click "Create New Account" button
        // TODO не совсем понятно у какая это кнопка
        driver.findElement(By.xpath("//div[@class='pull-left']")).click();



        //Check fields on the "Create New Account" view
        assertEquals(driver.findElement(By.xpath("//tr[1]/td[@class='category']")).getText(), "Username");
        assertEquals(driver.findElement(By.xpath("//tr[2]/td[@class='category']")).getText(), "Real Name");
        assertEquals(driver.findElement(By.xpath("//tr[3]/td[@class='category']")).getText(), "E-mail");
        assertEquals(driver.findElement(By.xpath("//tr[4]/td[@class='category']")).getText(), "Password");
        assertEquals(driver.findElement(By.xpath("//tr[5]/td[@class='category']")).getText(), "Verify Password");
        assertEquals(driver.findElement(By.xpath("//tr[6]/td[@class='category']")).getText(), "Access Level");
        assertEquals(driver.findElement(By.xpath("//tr[7]/td[@class='category']")).getText(), "Enabled");
        assertEquals(driver.findElement(By.xpath("//tr[8]/td[@class='category']")).getText(), "Protected");



        //Fill user inforamtion
        driver.findElement(By.id("user-username")).sendKeys("someone");

        driver.findElement(By.id("user-realname")).sendKeys("Renata");

        driver.findElement(By.id("email-field")).sendKeys("AnythingAnything@mail.ru");

        driver.findElement(By.id("user-password")).sendKeys("qwerty");

        driver.findElement(By.id("user-verify-password")).sendKeys("qwerty");

        Select dropdown1 = new Select(driver.findElement(By.id("user-access-level")));
        dropdown1.selectByValue("25");


        //Click "Create User" button
        driver.findElement(By.xpath("//input[@value='Create User']")).click();


        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[@href='/logout_page.php']")).click();



        //Login under created user
        driver.findElement(By.id("username")).sendKeys("someone");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.id("password")).sendKeys("qwerty");
        driver.findElement(By.xpath("//input[@value='Login']")).click();



        //Assert User name in the right-top side of screen that user is loggined
        assertEquals(driver.findElement(By.className("user-info")).getText(), "someone");



        //Logout
        driver.findElement(By.className("user-info")).click();
        driver.findElement(By.xpath("//a[@href='/logout_page.php']")).click();



        //Close driver
        driver.close();
    }
}
