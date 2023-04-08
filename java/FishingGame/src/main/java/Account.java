import java.io.Serializable;

public class Account implements Serializable {
    String name;
    Double balance;

    public Account(String n, Double b) {
        this.name = n;
        this.balance = b;
    }

    String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getBalance() {
        return this.balance;
    }

    public void setBalance(double transAmt, int tCode) {
        if (tCode != 1 && tCode != 3) {
            if (tCode == 2) {
                this.balance = this.balance + transAmt;
            }
        } else {
            this.balance = this.balance - transAmt;
        }

    }
}