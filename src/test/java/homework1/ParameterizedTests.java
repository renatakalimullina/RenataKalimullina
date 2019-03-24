package homework1;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import static org.testng.Assert.*;


public class ParameterizedTests extends TestBase {

    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void SignPositiveTest(long positive) {

        assertTrue(calculator.isPositive(8));
        assertFalse(calculator.isPositive(-186));

        assertTrue(calculator.isPositive(positive));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value= "negative")
    public void SignNegativeTest(long negative) {

        assertTrue(calculator.isNegative(-98));
        assertFalse(calculator.isNegative(186));

        assertTrue(calculator.isNegative(negative));
    }

}
