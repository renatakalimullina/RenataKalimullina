package homework1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeMethod;


public class TestBase {
    Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

}