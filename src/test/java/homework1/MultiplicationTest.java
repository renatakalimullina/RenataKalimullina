package homework1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends TestBase {


    @Test(groups = "Multiplication")
    public void testMultiZero() {
        Assert.assertEquals(calculator.mult(0, 678), 0);
    }

    @Test(groups = "Multiplication")
    public void testSimpleMulti() {
        Assert.assertEquals(calculator.mult(287, 2), 574);
    }

    @Test(groups = "Multiplication")
    public void testMultiOneNegative() {
        Assert.assertEquals(calculator.mult(-28, 10), -280);
    }


    @Test(groups = "Multiplication")
    public void testMultiTwoNegatives() {
        Assert.assertEquals(calculator.mult(-5, -40), 200);
    }

    @Test(groups = "Multiplication")
    public void testDoubleMultiOneNegative() {
        Assert.assertEquals(calculator.mult(-0.25, 4), -1, 0.000001);
    }

    @Test(groups = "Multiplication")
    public void testDoubleMulti() {
        Assert.assertEquals(calculator.mult(0.1, 10.), 1.);
    }


}