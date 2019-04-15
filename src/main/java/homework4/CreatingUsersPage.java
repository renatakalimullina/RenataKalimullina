package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class CreatingUsersPage extends AbstractPage  {

    @FindBy(xpath = "//tr[1]/td[@class='category']")
    private WebElement userName;

    @FindBy(xpath = "//tr[2]/td[@class='category']")
    private WebElement realName;

    @FindBy(xpath = "//tr[3]/td[@class='category']")
    private WebElement Email;

    @FindBy(xpath = "//tr[4]/td[@class='category']")
    private WebElement password;

    @FindBy(xpath = "//tr[5]/td[@class='category']")
    private WebElement verifyPassword;

    @FindBy(xpath = "//tr[6]/td[@class='category']")
    private WebElement accessLevel;

    @FindBy(xpath = "//tr[7]/td[@class='category']")
    private WebElement enabled;

    @FindBy(xpath = "//tr[8]/td[@class='category']")
    private WebElement Protected;



    @FindBy(id = "user-username")
    private WebElement userNameInfo;

    @FindBy(id = "user-realname")
    private WebElement userRealname;

    @FindBy(id = "email-field")
    private WebElement emailField;

    @FindBy(id = "user-password")
    private WebElement userPassword;

    @FindBy(id = "user-verify-password")
    private WebElement userVerifyPassword;

    @FindBy(xpath = "//*[@id='user-access-level']")
    private WebElement userAccessLevelFirst;

    @FindBy(xpath = "//*[@id='user-access-level']/option[2]")
    private WebElement userAccessLevelSecond;

    @FindBy(xpath = "//input[@value='Create User']")
    private WebElement addUser;


    protected CreatingUsersPage(WebDriver driver) {
        super(driver);
    }

    //Так как все asserts должны быть на уровне тестов
    /*public void checkFields() {
        assertEquals("Username", userName.getText());
        assertEquals("Real Name", realName.getText());
        assertEquals("E-mail", Email.getText());
        assertEquals("Password", password.getText());
        assertEquals("Verify Password", verifyPassword.getText());
        assertEquals("Access Level", accessLevel.getText());
        assertEquals("Enabled", enabled.getText());
        assertEquals("Protected", Protected.getText());
    }*/

    public void fillInfo()
    {
        userNameInfo.sendKeys("someone");
        userRealname.sendKeys("Renata");
        emailField.sendKeys("AnythingAnything@mail.ru");
        userPassword.sendKeys("qwerty");
        userVerifyPassword.sendKeys("qwerty");

        userAccessLevelFirst.click();
        userAccessLevelSecond.click();
    }

    public void addUser()
    {
        addUser.click();
    }
}
