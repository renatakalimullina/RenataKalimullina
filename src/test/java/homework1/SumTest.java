package homework1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumTest extends TestBase {

    @Test(groups = "Sum")
    public void testSimpleSub() {

        Assert.assertEquals(calculator.sum(0, 678), 678);
        Assert.assertEquals(calculator.sum(287, 2), 289);
        Assert.assertEquals(calculator.sum(-28, 10), -18);
        Assert.assertEquals(calculator.sum(-5, -40), -45);
    }

    @Test(groups = "Sum")
    public void testDoubleSub() {

        Assert.assertEquals(calculator.sum(0.1, 10.), 10.1, 0.000001);
        Assert.assertEquals(calculator.sum(5., 12.89), 17.89, 0.000001);
    }
}