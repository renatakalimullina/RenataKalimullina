package homework4;

import homework4.enums.MenuItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSideBarElement extends AbstractBasePage {

    @FindBy(xpath = "//div[@id='sidebar']//li")
    private List<WebElement> menuItems;

    protected LeftSideBarElement(WebDriver driver) {
        super(driver);
    }

    public void clickMenuItem(MenuItem item) {
        for (WebElement menuItem : menuItems) {
            if (menuItem.getText().trim().equals(item.getItemName())) {
                menuItem.click();
                break;
            }
        }
    }
}
