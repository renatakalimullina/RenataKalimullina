package homework4;

import homework4.enums.MenuItem;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends AbstractBasePage {

    protected LeftSideBarElement leftSideBar;

    protected AbstractPage(WebDriver driver) {
        super(driver);
        this.leftSideBar = new LeftSideBarElement(driver);
    }

    public void selectMenu(MenuItem item) {
        this.leftSideBar.clickMenuItem(item);
    }

    public LeftSideBarElement getLeftSideBar() {
        return leftSideBar;
    }
}