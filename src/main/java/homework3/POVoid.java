package homework3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.testng.AssertJUnit.assertEquals;

// TODO Для каждой страницы должен быть свой PageObject
// TODO Периписать в HW4
public class POVoid {

    private WebDriver driver;
    private WebElement userName;
    private WebElement userPassword;
    private WebElement button;
    private WebElement leftMenu;
    private WebElement selectedButton;
    private WebElement field;


    public POVoid(WebDriver driver) {
        this.driver = driver;
    }


    public void login(String name, String password) {
        userName = driver.findElement(By.id("username"));
        userName.sendKeys(name);

        button = driver.findElement(By.xpath("//input[@value='Login']"));
        button.click();

        userPassword = driver.findElement(By.id("password"));
        userPassword.sendKeys(password);

        button = driver.findElement(By.xpath("//input[@value='Login']"));
        button.click();
    }

    public String getLoggedUser() {
        return driver.findElement(By.className("user-info")).getText();
    }

    public void leftMenuSelection(String selection1, String selection2) {

        driver.findElement(By.xpath("//*[@id='sidebar']"));

        //Click "selection1" button at the left side menu
        leftMenu = driver.findElement(By.partialLinkText(selection1));
        leftMenu.click();


        selectedButton = driver.findElement(By.partialLinkText(selection2));
        selectedButton.click();
    }

    public void checkFields(Integer numberOfFields, String info) {

        field = driver.findElement(By.xpath("//tr["+numberOfFields.toString()+"]/td[@class='category']"));
        // TODO лишний assert
        assertEquals(field.getText(), info);
    }

    public void userInformation(String id, String info) {

        button = driver.findElement(By.id(id));
        button.sendKeys(info);
    }

    public void selectButton(String id, String value){

        button = driver.findElement(By.xpath("//*[@id='" + id + "']"));
        button.click();
        button = driver.findElement(By.xpath("//*[@id='" + id + "']/option[" + value + "]"));
        button.click();
    }

    public void clickButtonByXpath(String cl, String name) {

        button = driver.findElement(By.xpath("//"+ cl +"[@value='" + name + "']"));
        button.click();
    }

    public void clickButtonByClassName(String ClassName) {

        button = driver.findElement(By.className(ClassName));
        button.click();
    }
}
