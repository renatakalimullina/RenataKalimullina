package homework4;

import homework4.enums.MenuItem;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertEquals;


public class CreationIssuesTest extends BaseClassForTests{

    @Test
    public void setFilter() {
        // Check title
        assertEquals(loginPage.getPageTitle(), properties.getProperty("mainTitleName"));

        // Login
        loginPage.login(properties.getProperty("adminName"), properties.getProperty("adminPassword"));

        // Check login
        assertEquals(driver.getTitle(), properties.getProperty("titleName"));
        assertEquals(loginPage.getLoggedUser(), properties.getProperty("adminName"));

        //Assert left side menu & Click "view_issues" button at the left side menu
        loginPage.selectMenu(MenuItem.VIEW_ISSUES);

        //set filter values
        viewIssuePage.setPriority();
        viewIssuePage.setSeverity();
        viewIssuePage.setStatus();
        viewIssuePage.filterByDateSubmitted();
        viewIssuePage.chooseStartDay();
        viewIssuePage.chooseStartMonth();
        viewIssuePage.chooseStartYear();
        viewIssuePage.chooseEndDay();
        viewIssuePage.chooseEndMonth();
        viewIssuePage.chooseEndYear();

        //Click Apply Filter
        viewIssuePage.clickApplyFilter();

        //Check results
        assertEquals(viewIssuePage.getIssuesNumber(), properties.getProperty("viewIssueResults"));

        //Logout
        loginPage.logout();
    }
}
