package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(className = "user-info")
    private WebElement userInfo;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        usernameTextField.sendKeys(username);
        loginButton.click();
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getLoggedUser() {
        return driver.findElement(By.className("user-info")).getText();
    }

    public void logout()
    {
        userInfo.click();
        logoutButton.click();
    }

}
