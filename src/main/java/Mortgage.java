// Class for mortgage database & calculating monthly payments
public class Mortgage {
    private String customer;
    private double totalLoan;
    private double interest;
    private int years;
    private double monthlyPayment;

    // Constructor
    public Mortgage(String customer, float totalLoan, float interest, int years) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    // Formula for calculating monthly payments for the given loan
    public void calculatePaymentFormula() {
        double U = totalLoan;                    // customer's total loan
        double b = (interest / 100) / 12;       // monthly interest rate
        int p = years * 12;                     // # years the customer wants to pay off the mortgage

        double monthlyPayment = U * ((b * powerOf(1+b, p)) / (powerOf(1+b, p) -1));     // uses given formula for interest calculation
        this.monthlyPayment = monthlyPayment;   // applies calculation to instance variable
    }

    // java.math is not allowed -> my own powerOf() function
    private double powerOf(double base, int power) {
        double num = 1;
        for (int i = 0; i < power; i++) {
            num = num * base;
        }
        return num;
    }

    // TODO: method for rounding number to two decimal places
    private double roundTwoDecimals(double num) {
        return num;
    }

    // Getters and setters for each instance variable
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String newCustomer) {
        this.customer = newCustomer;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(double newTotalLoan) {
        this.totalLoan = newTotalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double newInterest) {
        this.interest = newInterest;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int newYears) {
        this.years = newYears;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }
}
