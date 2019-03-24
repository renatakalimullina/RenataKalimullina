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
    public void testSimpleDiv() {

        Assert.assertEquals(calculator.div(0, 678), 0);
        Assert.assertEquals(calculator.div(287, 287), 1);
        Assert.assertEquals(calculator.div(300, 5), 60);

        Assert.assertEquals(calculator.div(-413, 7), -59);
        Assert.assertEquals(calculator.div(-552, -69), 8);
    }


    @Test(groups = "Division")
    public void testDoubleDiv() {

        Assert.assertEquals(calculator.div(5., 100.), 0.05);
        Assert.assertEquals(calculator.div(0., 100.), 0.);
        Assert.assertEquals(calculator.div(650., 8.), 81.25);

    }
}