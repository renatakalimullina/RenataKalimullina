package homework1;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;

import static org.testng.Assert.*;

public class ParameterizedTests extends TestBase {

    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void positiveSignTest(long positive) {
        assertTrue(calculator.isPositive(positive));
    }


    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void notPositiveSignTest(long positive) {
        assertFalse(calculator.isNegative(positive));
    }

    @Test(groups = {"Parameterized"})
    @Parameters(value = "negative")
    public void negativeSignTest(long negative) {
        assertTrue(calculator.isNegative(negative));
    }

}
