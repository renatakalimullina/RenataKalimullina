package homework1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTest extends TestBase {


    @Test(groups = "Subtraction")
    public void testSimpleSub() {

        Assert.assertEquals(calculator.sub(0, 678), -678);
        Assert.assertEquals(calculator.sub(287, 2), 285);
        Assert.assertEquals(calculator.sub(-28, 10), -38);
        Assert.assertEquals(calculator.sub(-5, -40), 35);
    }

    @Test(groups = "Subtraction")
    public void testDoubleSub() {

        Assert.assertEquals(calculator.sub(0.1, 10.), -9.9, 0.000001);
        Assert.assertEquals(calculator.sub(5., 12.89), -7.89, 0.000001);
    }
}