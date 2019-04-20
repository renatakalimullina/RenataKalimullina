package homework4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuePage extends AbstractPage{

    @FindBy(id = "show_priority_filter")
    private WebElement showPriority;

    @FindBy(id = "show_priority_filter_target")
    private WebElement showPrioritySelectFirst;

    @FindBy(xpath = " //*[@id='show_priority_filter_target']/select/option[5]")
    private WebElement showPrioritySelectSecond;




    @FindBy(id = "show_severity_filter")
    private WebElement showSeverityFilter;

    @FindBy(id = "show_severity_filter_target")
    private WebElement showSeveritySelectFirst;

    @FindBy(xpath = "//*[@id='show_severity_filter_target']/select/option[5]")
    private WebElement showSeveritySelectSecond;



    @FindBy(id = "show_status_filter")
    private WebElement showStatusFilter;

    @FindBy(id = "show_status_filter_target")
    private WebElement showStatusSelectFirst;

    @FindBy(xpath = "//*[@id=\"show_status_filter_target\"]/select/option[6]")
    private WebElement showStatusSelectSecond;




    @FindBy(id = "do_filter_by_date_filter")
    private WebElement doFilterByDateFilter;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[1]/td/label/span")
    private WebElement doFilterByDateFilterSpan;


//
    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[3]")
    private WebElement startDateDayFirst;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[3]/option[27]")
    private WebElement startDateDaySecond;
//
    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[2]")
    private WebElement startDateMonthFirst;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[2]/option[3]")
    private WebElement startDateMonthSecond;
//
    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[1]")
    private WebElement startDateYearFirst;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[1]/option[1]")
    private WebElement startDateYearSecond;

////
    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[3]/td[2]/select[3]")
    private WebElement endDateDayFirst;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[3]/option[1]")
    private WebElement endDateDaySecond;
//
    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[3]/td[2]/select[2]")
    private WebElement endDateMonthFirst;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[2]/td[2]/select[2]/option[4]")
    private WebElement endDateMonthSecond;
//
    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[3]/td[2]/select[1]")
    private WebElement endDateYearFirst;

    @FindBy(xpath = "//*[@id='do_filter_by_date_filter_target']/table/tbody/tr[3]/td[2]/select[1]/option[1]")
    private WebElement endDateYearSecond;


    @FindBy(xpath = "//*[@value='Apply Filter' and @name='filter_submit']")
    private WebElement applyFilter;

    @FindBy(className = "badge")
    private WebElement issuesNumber;

    @FindBy(className = "user-info")
    private WebElement userInfo;

    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;


    protected ViewIssuePage(WebDriver driver) {
        super(driver);
    }

    public void setPriority(){

        showPriority.click();
        showPrioritySelectFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        showPrioritySelectSecond
                )).click();
    }

    public void setSeverity()
    {
        showSeverityFilter.click();
        showSeveritySelectFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        showSeveritySelectSecond
                )).click();
    }

    public void setStatus()
    {
        showStatusFilter.click();
        showStatusSelectFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        showStatusSelectSecond
                )).click();
    }

    public void filterByDateSubmitted()
    {
        doFilterByDateFilter.click();
        new WebDriverWait(driver, 10)
             .until(ExpectedConditions.visibilityOf(
                     doFilterByDateFilterSpan)
           ).click();
    }

    public void chooseStartDay()
    {
        startDateDayFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        startDateDaySecond)
                ).click();
    }

    public void chooseStartMonth()
    {
        startDateMonthFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        startDateMonthSecond)
                ).click();
    }

    public void chooseStartYear()
    {
        startDateYearFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        startDateYearSecond)
                ).click();
    }

    public void chooseEndDay()
    {
        endDateDayFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        endDateDaySecond)
                ).click();
    }

    public void chooseEndMonth()
    {
        endDateMonthFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        endDateMonthSecond)
                ).click();
    }

    public void chooseEndYear()
    {
        endDateYearFirst.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(
                        endDateYearSecond)
                ).click();
    }

    public void clickApplyFilter()
    {
        applyFilter.click();
    }

    public String getIssuesNumber()
    {
        return issuesNumber.getText();
    }

    // TODO Зачем в каждом ПО делать метод logout?
    // Исправлено. Вынесла в LoginPage
}
