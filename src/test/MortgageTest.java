import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MortgageTest {
    Mortgage mortgage = new Mortgage("Alvar Blomqvist", 10000, 5, 8);

    @Test
    public void testPaymentCalculator() {
        float totalLoan = mortgage.getTotalLoan();
        float interest = mortgage.getInterest();
        int years = mortgage.getYears();

        mortgage.calculatePaymentFormula();

        Assertions.assertEquals(126.60, mortgage.getMonthlyPayment());
    }

    @Test
    public void testpowerOf() {
        double base = 2;
        double numSquared = mortgage.powerOf(base, 4);
        double numCubed = mortgage.powerOf(base, 8);

        Assertions.assertEquals(16, numSquared);
        Assertions.assertEquals(256, numCubed);
    }

    @Test
    public void testRoundTwoDecimals() {
        double roundedDecimal = mortgage.roundTwoDecimals(5.368);
        Assertions.assertEquals(5.37, roundedDecimal);
    }
}