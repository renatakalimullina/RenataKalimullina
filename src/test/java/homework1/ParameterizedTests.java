package homework1;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import static org.testng.Assert.*;


public class ParameterizedTests extends TestBase {

    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void SignPositiveSimpleTest() {
        assertTrue(calculator.isPositive(8));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void SignPositiveTestWithNegative() {
        assertFalse(calculator.isPositive(-186));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void SignPositiveTest(long positive) {
        assertTrue(calculator.isPositive(positive));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value= "negative")
    public void SignNegativeSimpleTest() {
        assertTrue(calculator.isNegative(-98));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value= "negative")
    public void SignSimpleTest() {
        assertFalse(calculator.isNegative(186));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value= "negative")
    public void SignNegativeTest(long negative) {
        assertTrue(calculator.isNegative(negative));
    }

}
