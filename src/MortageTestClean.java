import static org.junit.Assert.*;
import org.junit.Test;
public class MortageTestClean {
    private static final double DELTA = 0.001;

    @Test
    public void shouldReturn180000ForArchitectWithIncome3000WhenNotMarried() {
        MortgageCalculator mc = new MortgageCalculator();
        double result = mc.computeMaxMortgage(1967, 5, 2, 3000, false, 0, "Architect");
        assertEquals(180000, result, DELTA);
    }

    @Test
    public void shouldReturn0ForArchitectWithIncome3000WhenUnderage() {
        MortgageCalculator mc = new MortgageCalculator();
        double result = mc.computeMaxMortgage(2001, 5, 2, 3000, false, 0, "Architect");
        assertEquals(0, result, DELTA);
    }

    @Test
    public void shouldReturn220000ForDeveloperWithIncome4000WhenMarried() {
        MortgageCalculator mc = new MortgageCalculator();
        double result = mc.computeMaxMortgage(1977, 12, 2, 4000, true, 2000, "Developer");
        assertEquals(220000, result, DELTA);
    }

    @Test
    public void shouldReturn280000ForProfessorWithIncome5500WhenNotMarried() {
        MortgageCalculator mc = new MortgageCalculator();
        double result = mc.computeMaxMortgage(1954, 5, 12, 5500, false, 0, "Professor");
        assertEquals(280000, result, DELTA);
    }
}
