package homework1;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import static org.testng.Assert.*;

// TODO Java naming convention for methods name
public class ParameterizedTests extends TestBase {

    // TODO для чего здесь используется параметризация, если папаметров нету??
    @Test(groups = {"Parameterized"})
    @Parameters(value = "positive")
    public void SignPositiveSimpleTest() {
        assertTrue(calculator.isPositive(8));
    }

    // TODO для чего здесь используется параметризация, если папаметров нету??
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

    // TODO для чего здесь используется параметризация, если папаметров нету??
    @Test(groups = {"Parameterized"})
    @Parameters(value= "negative")
    public void SignNegativeSimpleTest() {
        assertTrue(calculator.isNegative(-98));
    }

    // TODO для чего здесь используется параметризация, если папаметров нету??
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
