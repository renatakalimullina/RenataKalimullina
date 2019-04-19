package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ManagePage extends AbstractPage {

    // TODO Должно быть сделанно по аналогии с Меню в LeftSideBarElement
    @FindBy(partialLinkText = "Manage Projects")
    private WebElement manageProjects;

    @FindBy(xpath = "//button[contains(text(),'Create New Project')]")
    private WebElement newProjects;

    @FindBy(className = "user-info")
    private WebElement userInfo;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;

    @FindBy(partialLinkText = "Manage Users")
    private WebElement manageUsers;

    @FindBy(xpath = "//div[@class='pull-left']")
    private WebElement newUsers;


    protected ManagePage(WebDriver driver) {
        super(driver);
    }

    public void selectManageProject() {

        manageProjects.click();
    }

    public void selectManageUsers() {

        manageUsers.click();
    }

    public void creatingNewProject() {

        newProjects.click();
    }

    public void creatingNewUsers() {

        newUsers.click();
    }

    public void logout()
    {
        userInfo.click();
        logoutButton.click();
    }


}
