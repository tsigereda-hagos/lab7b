import java.time.LocalDate;
import java.time.Period;

public class MortageCalculatorClean {
    private static final double INCOME_LOWER_BOUND_1 = 2000;
    private static final double INCOME_UPPER_BOUND_1 = 3000;
    private static final double INCOME_LOWER_BOUND_2 = 3000;
    private static final double INCOME_UPPER_BOUND_2 = 5000;
    private static final double INCOME_LOWER_BOUND_3 = 5000;

    public double computeMaxMortgage(int yearOfBirth, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
        int age = calculateAge(yearOfBirth, month, day);
        double totalIncome = calculateTotalIncome(monthlyIncome, monthlyIncomePartner, married);

        if (age < 18) {
            return 0;
        }

        return calculateMortgage(totalIncome, profession);
    }

    private int calculateAge(int yearOfBirth, int month, int day) {
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(yearOfBirth, month, day);
        return Period.between(birthday, today).getYears();
    }

    private double calculateTotalIncome(double monthlyIncome, double monthlyIncomePartner, boolean married) {
        return married ? monthlyIncome + monthlyIncomePartner * 0.94 : monthlyIncome;
    }

    private double calculateMortgage(double totalIncome, String profession) {
        if (INCOME_LOWER_BOUND_1 <= totalIncome && totalIncome < INCOME_UPPER_BOUND_1) {
            return getMortgageForIncomeRange1(profession);
        } else if (INCOME_LOWER_BOUND_2 <= totalIncome && totalIncome < INCOME_UPPER_BOUND_2) {
            return getMortgageForIncomeRange2(profession);
        } else if (INCOME_LOWER_BOUND_3 <= totalIncome) {
            return getMortgageForIncomeRange3(profession);
        }
        return 0;
    }

    private double getMortgageForIncomeRange1(String profession) {
        switch (profession) {
            case "Developer":
            case "Architect":
            case "Scrum master":
                return 160000;
            case "Tester":
            case "System Administrator":
            case "Technical writer":
                return 120000;
            case "Department head":
            case "Professor":
                return 220000;
            default:
                return 0;
        }
    }

    private double getMortgageForIncomeRange2(String profession) {
        switch (profession) {
            case "Developer":
            case "Architect":
            case "Scrum master":
                return 180000;
            case "Tester":
            case "System Administrator":
            case "Technical writer":
                return 140000;
            case "Department head":
            case "Professor":
                return 250000;
            default:
                return 0;
        }
    }

    private double getMortgageForIncomeRange3(String profession) {
        switch (profession) {
            case "Developer":
            case "Architect":
            case "Scrum master":
                return 220000;
            case "Tester":
            case "System Administrator":
            case "Technical writer":
                return 160000;
            case "Department head":
            case "Professor":
                return 280000;
            default:
                return 0;
        }
    }
}
