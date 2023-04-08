import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CheckingAccount extends Account implements Serializable, Comparable<CheckingAccount> {
    private int count = 0;
    private double totalServiceCharge = 0.0;
    private ArrayList<Transactions> transList = new ArrayList();
    private int transCount = 0;
    private int transSize = 0;
    private int transCode;
    private int i = 0;
    DecimalFormat dollar = new DecimalFormat("$#,##0.00;($#,##0.00)");
    private double transAmount;
    public String filename = "D:\\Documents\\2018 Spring\\hihi.dat";
    private static boolean saved;
    private int currentCheck = 0;

    public CheckingAccount(String n, Double initialBalance) {
        super(n, initialBalance);
        this.balance = initialBalance;
        this.totalServiceCharge = 0.0;
    }

    int getCount() {
        return this.count;
    }

    void setCount(int c) {
        this.count = c;
    }

    public double getServiceCharge() {
        return this.totalServiceCharge;
    }

    public double getTotalServiceCharge() {
        double totalsc = 0.0;

        for(int j = 0; j < this.getSize(); ++j) {
            if (this.getTrans(j).getTransId() == 3) {
                totalsc += this.getTrans(j).getTransAmount();
            }
        }

        return totalsc;
    }

    public void setServiceCharge(double currentServiceCharge) {
        this.totalServiceCharge = currentServiceCharge;
    }

    public void addTrans(Transactions newTrans) {
        this.transList.add(newTrans);
    }

    public int getTransCount() {
        ++this.transCount;
        return this.transCount - 1;
    }

    public int getCurrentTransCount() {
        return this.transCount;
    }

    public Transactions getTrans(int i) {
        return (Transactions)this.transList.get(i);
    }

    public Deposit getDeposit(int i) {
        return (Deposit)this.transList.get(i);
    }

    public Check getCheck(int i) {
        return (Check)this.transList.get(i);
    }

    public int getSize() {
        this.transSize = this.transList.size();
        return this.transSize;
    }

    public ServiceCharge getSerChar(int i) {
        return (ServiceCharge)this.transList.get(i);
    }

    public int getTransCode() {
        String userInput = JOptionPane.showInputDialog("Enter the transaction code:\n[1] Check \n[2] Deposit \n[0] Exit");
        int code = Integer.parseInt(userInput);
        return code;
    }

    public double initialBalance() {
        String userInput = JOptionPane.showInputDialog("Enter initial account balance :");
        double initialBal = Double.parseDouble(userInput);
        return initialBal;
    }

    public double getTransAmt() {
        String userInput = JOptionPane.showInputDialog("Enter the transaction amount: ");
        double amount = Double.parseDouble(userInput);
        return amount;
    }

    public static boolean saved() {
        return saved;
    }

    public int compareTo(CheckingAccount o) {
        return this.getName().compareTo(o.getName());
    }
}
