

public class Deposit extends Transactions {
    private double totalDeposit;
    private Double cash = 0.0;
    private Double checks = 0.0;

    public Deposit(int number, int id, double cash, double checks) {
        super(number, id, cash + checks);
        this.cash = cash;
        this.checks = checks;
        this.totalDeposit = cash + checks;
    }

    public double getCheck() {
        return this.checks;
    }

    public double getCash() {
        return this.cash;
    }

    public double getTotalDeposit() {
        return this.totalDeposit;
    }
}
