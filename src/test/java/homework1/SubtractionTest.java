package homework1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTest extends TestBase {

    @Test(groups = "Subtraction")
    public void testSubZero() {
        Assert.assertEquals(calculator.sub(0, 678), -678);
    }

    @Test(groups = "Subtraction")
    public void testSimpleSub() {
        Assert.assertEquals(calculator.sub(287, 2), 285);
    }

    @Test(groups = "Subtraction")
    public void testSubOneNegative() {
        Assert.assertEquals(calculator.sub(-28, 10), -38);
    }

    @Test(groups = "Subtraction")
    public void testSubTwoNegatives() {
        Assert.assertEquals(calculator.sub(-5, -40), 35);
    }

    @Test(groups = "Subtraction")
    public void testDoubleSimpleSub() {
        Assert.assertEquals(calculator.sub(0.1, 10.), -9.9, 0.000001);
    }
}