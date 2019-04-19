package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.AssertJUnit.assertEquals;

public class CreatingProjectPage extends AbstractPage {

    @FindBy(xpath = "//tr[1]/td[@class='category']")
    private WebElement name;

    @FindBy(xpath = "//tr[2]/td[@class='category']")
    private WebElement status;

    @FindBy(xpath = "//tr[3]/td[@class='category']")
    private WebElement category;

    @FindBy(xpath = "//tr[4]/td[@class='category']")
    private WebElement viewStatus;

    @FindBy(xpath = "//tr[5]/td[@class='category']")
    private WebElement description;



    @FindBy(id = "project-name")
    private WebElement projectName;

    @FindBy(xpath =  "//*[@id='project-status']")
    private WebElement projectStatusFirst;

    @FindBy(xpath = "//*[@id='project-status']/option[1]")
    private WebElement projectStatusSecond;

    @FindBy(className = "lbl")
    private WebElement inheritGlobalCategories;


    @FindBy(xpath =  "//*[@id='project-view-state']")
    private WebElement projectViewStateFirst;

    @FindBy(xpath = "//*[@id='project-view-state']/option[1]")
    private WebElement projectViewStateSecond;

    @FindBy(id = "project-description")
    private WebElement projectDescription;


    @FindBy(xpath =  "//input[@value='Add Project']")
    private WebElement addProject;




    protected CreatingProjectPage(WebDriver driver) {
        super(driver);
    }

    //Так как все asserts должны быть на уровне тестов
    /*public void checkFields() {

        assertEquals("* Project Name", name.getText());
        assertEquals("Status", status.getText());
        assertEquals("Inherit Global Categories", category.getText());
        assertEquals("View Status", viewStatus.getText());
        assertEquals("Description", description.getText());
    }*/

    public void fillInfo()
    {
        // TODO не должно быть данных на уровне PageObjects
        projectName.sendKeys("Anything");

        projectStatusFirst.click();
        projectStatusSecond.click();

        inheritGlobalCategories.click();

        projectViewStateFirst.click();
        projectViewStateSecond.click();

        // TODO не должно быть данных на уровне PageObjects
        projectDescription.sendKeys("AnythingAnything");
    }

    public void addProject()
    {
        addProject.click();
    }

}
