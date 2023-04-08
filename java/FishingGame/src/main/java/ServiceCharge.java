
import java.io.Serializable;

public class ServiceCharge extends Transactions implements Serializable {
    private int associatedTransNumber;

    public ServiceCharge(int number, int id, double amount, int associatedTransNumber) {
        super(number, id, amount);
        this.associatedTransNumber = associatedTransNumber;
    }

    public int getAssociatedTransNumber() {
        return this.associatedTransNumber;
    }
}
