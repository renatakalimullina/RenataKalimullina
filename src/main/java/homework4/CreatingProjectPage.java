package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatingProjectPage extends AbstractPage {

    @FindBy(xpath = "//button[contains(text(),'Create New Project')]")
    private WebElement newProjects;


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

    public void creatingNewProject()
    {
        newProjects.click();
    }

    public void fillInfo(String name, String Description)
    {
        projectName.sendKeys(name);

        projectStatusFirst.click();
        projectStatusSecond.click();

        inheritGlobalCategories.click();

        projectViewStateFirst.click();
        projectViewStateSecond.click();

        projectDescription.sendKeys(Description);
    }

    public void addProject()
    {
        addProject.click();
    }
}
