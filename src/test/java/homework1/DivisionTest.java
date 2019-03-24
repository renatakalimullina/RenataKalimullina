package homework1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest extends TestBase {

    @Test(groups = "Division", expectedExceptions = NumberFormatException.class)
    public void testDivByZero() throws NumberFormatException {
        calculator.div(2, 0);
        calculator.div(-54, 0);
    }

    @Test(groups = "Division")
    public void testDivideZero() {
        Assert.assertEquals(calculator.div(0, 678), 0);
    }

    @Test(groups = "Division")
    public void testDivideEqualsOne() {
        Assert.assertEquals(calculator.div(287, 287), 1);
    }

    @Test(groups = "Division")
    public void testSimpleDivide() {
        Assert.assertEquals(calculator.div(300, 5), 60);
    }

    @Test(groups = "Division")
    public void testDivideOneNegative() {
        Assert.assertEquals(calculator.div(-413, 7), -59);
    }

    @Test(groups = "Division")
    public void testDivideTwoNegatives() {
        Assert.assertEquals(calculator.div(-552, -69), 8);
    }

    @Test(groups = "Division")
    public void testDoubleSimpleDivide() {
        Assert.assertEquals(calculator.div(5., 100.), 0.05);
    }

    @Test(groups = "Division")
    public void testDoubleDivideZero() {
        Assert.assertEquals(calculator.div(0., 100.), 0.);
    }
}