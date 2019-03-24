package homework1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumTest extends TestBase {

    @Test(groups = "Sum")
    public void testSumZero() {
        Assert.assertEquals(calculator.sum(0, 678), 678);
    }

    @Test(groups = "Sum")
    public void testSimpleSum() {
        Assert.assertEquals(calculator.sum(287, 2), 289);
    }

    @Test(groups = "Sum")
    public void testSumOneNegative() {
        Assert.assertEquals(calculator.sum(-28, 10), -18);
    }

    @Test(groups = "Sum")
    public void testSumTwoNegatives() {
        Assert.assertEquals(calculator.sum(-5, -40), -45);
    }

    @Test(groups = "Sum")
    public void testDoubleSum() {
        Assert.assertEquals(calculator.sum(5., 12.89), 17.89, 0.000001);
    }
}