public class Check extends Transactions {
    private int checkNumber;

    public Check(int number, int id, double amount, int checkNumber) {
        super(number, id, amount);
        this.checkNumber = checkNumber;
    }

    public int getCheckNumber() {
        return this.checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }
}