import java.io.Serializable;

public class Transactions implements Serializable {
    private int transNumber;
    private int transId;
    private double transAmt;

    public Transactions(int number, int id, double amount) {
        this.transNumber = number;
        this.transId = id;
        this.transAmt = amount;
    }

    public int getTransNumber() {
        return this.transNumber;
    }

    public int getTransId() {
        return this.transId;
    }

    public double getTransAmount() {
        return this.transAmt;
    }
}
