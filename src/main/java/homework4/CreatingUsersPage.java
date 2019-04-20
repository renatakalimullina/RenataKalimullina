package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatingUsersPage extends AbstractPage  {

    @FindBy(xpath = "//div[@class='pull-left']")
    private WebElement newUsers;


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

    public void creatingNewUsers()
    {
        newUsers.click();
    }

    // TODO не должно быть данных на уровне PageObjects
    // Исправлено
    public void fillInfo(String name, String realName, String email, String password)
    {
        userNameInfo.sendKeys(name);
        userRealname.sendKeys(realName);
        emailField.sendKeys(email);
        userPassword.sendKeys(password);
        userVerifyPassword.sendKeys(password);

        userAccessLevelFirst.click();
        userAccessLevelSecond.click();
    }

    public void addUser()
    {
        addUser.click();
    }
}
