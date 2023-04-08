import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class Main extends JPanel implements Serializable {
    static boolean saved = false;
    static CheckingAccount c;
    static DecimalFormat dollar = new DecimalFormat("#,##0.00;(#,##0.00)");
    static String filename = "D:\\Documents\\2018 Spring\\hihi.dat";
    static Check ch;
    static Deposit de;
    public static EOptionsFrame frame;
    public static JTextArea ta;
    public static ArrayList<CheckingAccount> dataStore;

    public Main() {
    }

    public static void main(String[] args) {
        dataStore = new ArrayList();
        frame = new EOptionsFrame("Checking Account Menu");
        ta = new JTextArea(20, 60);
        ta.setFont(new Font("Monospaced", 0, 12));
        frame.getContentPane().add(ta);
        frame.pack();
        frame.setVisible(true);
    }

    public static boolean save() {
        return saved;
    }

    public static void addAccount() {
        String userInputName = JOptionPane.showInputDialog("Enter the account name:");
        String userInputBal = JOptionPane.showInputDialog("Enter initial account balance :");
        double initialBal = Double.parseDouble(userInputBal);
        c = new CheckingAccount(userInputName, initialBal);
        dataStore.add(c);
    }

    public static void findAccount() {
        String name = JOptionPane.showInputDialog("Enter the Account name: ");
        Collections.sort(dataStore);
        int index = Collections.binarySearch(dataStore, new CheckingAccount(name, (Double)null));
        if (index != -1) {
            CheckingAccount ca = (CheckingAccount)dataStore.get(index);
            System.out.println(ca.getName());
            if (name.equals(ca.getName())) {
                c = ca;
                String message = "Found account for: " + c.getName();
                ta.setText(message);
            }
        }

    }

    public static void readfromfile() {
        chooseFile(1);
        saved = true;

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fis);
            dataStore = (ArrayList)in.readObject();
            fis.close();
        } catch (ClassNotFoundException var2) {
            System.out.println(var2);
        } catch (IOException var3) {
            System.out.println(var3);
        }

    }

    public static void writeFile() {
        chooseFile(2);
        saved = true;

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(dataStore);
            fos.close();
        } catch (IOException var2) {
            System.out.println(var2);
        }

    }

    public static void chooseFile(int ioOption) {
        String message = "Would you like to use the current default file: \n" + filename;
        int confirm = JOptionPane.showConfirmDialog((Component)null, message);
        if (confirm != 0) {
            JFileChooser chooser = new JFileChooser();
            int status;
            if (ioOption == 1) {
                status = chooser.showOpenDialog((Component)null);
            } else {
                status = chooser.showSaveDialog((Component)null);
            }

            if (status == 0) {
                File file = chooser.getSelectedFile();
                filename = file.getPath();
            }

        }
    }

    static void getDeposits() {
        double totalDeposits = 0.0;
        String line = "Listing all Deposits for " + c.getName() + "\n" + String.format("%-8s %-8s %8s %8s %8s", "ID", "Type", "Checks", "Cash", "Amount") + "\n";

        for(int j = 0; j < c.getSize(); ++j) {
            if (c.getTrans(j).getTransId() == 2) {
                line = line + String.format("%-8s %-8s %8s %8s %8s", c.getTrans(j).getTransNumber(), "Deposit", dollar.format(c.getDeposit(j).getCheck()), dollar.format(c.getDeposit(j).getCash()), dollar.format(c.getTrans(j).getTransAmount())) + "\n";
                totalDeposits += c.getTrans(j).getTransAmount();
            }
        }

        line = line + String.format("---------------------------------------------") + "\n";
        line = line + String.format("%-10s %33s", "Total", dollar.format(totalDeposits)) + "\n";
        ta.setText(line);
    }

    static void getChecks() {
        double totalChecks = 0.0;
        String line = "Listing all checks for " + c.getName() + "\n" + String.format("%-10s %8s %10s", "ID", "Check", "Amount") + "\n";

        for(int i = 0; i < c.getSize(); ++i) {
            if (c.getTrans(i).getTransId() == 1) {
                line = line + String.format("%-10s %8s %10s", c.getTrans(i).getTransNumber(), c.getCheck(i).getCheckNumber(), dollar.format(c.getTrans(i).getTransAmount())) + "\n";
                totalChecks += c.getTrans(i).getTransAmount();
            }
        }

        line = line + String.format("------------------------------") + "\n";
        line = line + String.format("%-10s %19s", "Total", dollar.format(totalChecks)) + "\n";
        ta.setText(line);
    }

    public static void setTransactions() {
        int transCode = c.getTransCode();
        double transAmount;
        switch (transCode) {
            case 0:
                JOptionPane.showMessageDialog((Component)null, "Transaction: End\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nTotal Service Charge: " + dollar.format(c.getTotalServiceCharge()) + "\nFinal Balance: " + dollar.format(c.getBalance() - c.getTotalServiceCharge()));
                break;
            case 1:
                String userInput = JOptionPane.showInputDialog("Enter the check Number :");
                Integer CheckN = Integer.parseInt(userInput);
                transAmount = c.getTransAmt();
                ch = new Check(c.getTransCount(), 1, transAmount, CheckN);
                c.addTrans(ch);
                processCheck(transAmount);
                break;
            case 2:
                double cash = 0.0;
                double checks = 0.0;
                JTextField field1 = new JTextField();
                JTextField field2 = new JTextField();
                JPanel panel = new JPanel(new GridLayout(0, 1));
                panel.add(new JLabel("Cash"));
                panel.add(field1);
                panel.add(new JLabel("Checks"));
                panel.add(field2);
                field1.addAncestorListener(new SetFocus());
                int result = JOptionPane.showConfirmDialog((Component)null, panel, "Deposit", 2, -1);
                if (result == 2) {
                    System.out.println("Canceled");
                    System.exit(0);
                } else {
                    String Cash = field1.getText();
                    cash = Double.parseDouble(Cash);
                    String Checks = field2.getText();
                    checks = Double.parseDouble(Checks);
                }

                de = new Deposit(c.getTransCount(), 2, cash, checks);
                transAmount = de.getTotalDeposit();
                c.addTrans(de);
                processDeposit(transAmount);
                break;
            default:
                JOptionPane.showMessageDialog((Component)null, "Invalid!");
        }

    }

    public static void getTransList() {
        DecimalFormat dollar = new DecimalFormat("$#,##0.00;($#,##0.00)");
        //int types = false;
        double amount = 0.0;
        String s = "";
        String line = "Account: " + c.getName() + "\nBalance: " + dollar.format(c.getBalance()) + "\nTotal Service Charge: " + dollar.format(c.getServiceCharge()) + "\n\n";
        line = line + "List of all transactions:\n\n" + String.format("%-10s %-15s %10s", "ID", "Type", "Amount") + "\n";

        for(int index = 0; index < c.getSize(); ++index) {
            int types = c.getTrans(index).getTransId();
            amount = c.getTrans(index).getTransAmount();
            if (types == 1) {
                s = "Check";
            }

            if (types == 2) {
                s = "Deposit";
            }

            if (types == 3) {
                s = "Svc. Chrg.";
            }

            line = line + String.format("%-10s %-15s %10s", index, s, dollar.format(amount)) + "\n";
        }

        ta.setText(line);
    }

    public static void getServiceCharges() {
        String s = "";
        DecimalFormat dollar = new DecimalFormat("$#,##0.00;($#,##0.00)");
        double totalsc = 0.0;
        String line = "List of Charges for " + c.getName() + "\n" + String.format("%14s", "Assoc") + "\n" + String.format("%-8s %-8s %-16s %8s", "ID", "Trans", "Service Charge", "Amount") + "\n";

        for(int j = 0; j < c.getSize(); ++j) {
            if (c.getTrans(j).getTransId() == 3) {
                if (c.getTrans(j).getTransAmount() == 0.15) {
                    s = "Withdraw Charge";
                }

                if (c.getTrans(j).getTransAmount() == 5.0) {
                    s = "Under $500.00";
                }

                if (c.getTrans(j).getTransAmount() == 0.1) {
                    s = "Deposit Charge";
                }

                if (c.getTrans(j).getTransAmount() == 10.0) {
                    s = "Under $0.00";
                }

                line = line + String.format("%-8s %-8s %-16s %8s", c.getTrans(j).getTransNumber(), c.getSerChar(j).getAssociatedTransNumber(), s, dollar.format(c.getTrans(j).getTransAmount())) + "\n";
                totalsc += c.getTrans(j).getTransAmount();
            }
        }

        line = line + String.format("%43s", "----------") + "\n";
        line = line + String.format("%-10s %32s", "Total", dollar.format(totalsc)) + "\n";
        ta.setText(line);
    }

    public static double processCheck(double transAmt) {
        DecimalFormat dollar = new DecimalFormat("$#,##0.00;($#,##0.00)");
        c.setBalance(transAmt, 1);
        int w;
        ServiceCharge sg;
        if (c.getBalance() < 500.0 && c.getBalance() >= 50.0) {
            if (c.getCount() == 0) {
                c.setBalance(5.15, 3);
                c.setServiceCharge(5.15);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nService Charge: Below $500 --- charge $5.00\nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                c.setCount(1);
                w = c.getTransCount();
                sg = new ServiceCharge(w, 3, 0.15, w - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 5.0, w - 1);
                c.addTrans(sg);
            } else {
                c.setBalance(0.15, 3);
                c.setServiceCharge(0.15);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                w = c.getTransCount();
                sg = new ServiceCharge(w, 3, 0.15, w - 1);
                c.addTrans(sg);
            }
        } else if (c.getBalance() >= 500.0) {
            c.setBalance(0.15, 3);
            c.setServiceCharge(0.15);
            JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
            w = c.getTransCount();
            sg = new ServiceCharge(w, 3, 5.15, w - 1);
            c.addTrans(sg);
        } else if (c.getBalance() < 50.0 && c.getBalance() >= 0.0) {
            if (c.getCount() == 0) {
                c.setBalance(5.15, 3);
                c.setServiceCharge(5.15);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nService Charge: Below $500 --- charge $5.00\nSWarning: Your balance is under $50. \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                c.setCount(1);
                w = c.getTransCount();
                sg = new ServiceCharge(w, 3, 0.15, w - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 5.0, w - 1);
                c.addTrans(sg);
            } else {
                c.setBalance(0.15, 3);
                c.setServiceCharge(0.15);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nWarning: Your balance is under $50. \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                w = c.getTransCount();
                sg = new ServiceCharge(w, 3, 0.15, w - 1);
                c.addTrans(sg);
            }
        } else if (c.getBalance() < 0.0) {
            if (c.getCount() == 0) {
                c.setBalance(15.15, 3);
                c.setServiceCharge(15.15);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount:Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nService Charge: Below $500 --- charge $5.00\nWarning: Your balance is under $50. \nService Charge: Below $0 ---charge $10.00.\nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                w = c.getTransCount();
                sg = new ServiceCharge(w, 3, 0.15, w - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 5.0, w - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 10.0, w - 1);
                c.addTrans(sg);
                c.setCount(1);
            } else {
                c.setBalance(10.15, 3);
                c.setServiceCharge(10.15);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check #" + ch.getCheckNumber() + " in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Check --- charge $0.15 \nWarning: Your balance is under $50. \nService Charge: Below $0 ---charge $10.00.\nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                w = c.getTransCount();
                sg = new ServiceCharge(w, 3, 0.15, w - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 10.0, w - 1);
                c.addTrans(sg);
            }
        }

        return transAmt;
    }

    public static void processDepositFromGame(double b) {
        c.setBalance(b, 2);
    }

    public static double processDeposit(double transAmt) {
        DecimalFormat dollar = new DecimalFormat("$#,##0.00;($#,##0.00)");
        c.setBalance(transAmt, 2);
        int i;
        ServiceCharge sg;
        if (c.getBalance() < 500.0 && c.getBalance() >= 50.0) {
            if (c.getCount() == 0) {
                c.setBalance(5.1, 3);
                c.setServiceCharge(5.1);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Deposit in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nService Charge: Below $500 --- charge $5.00\nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                c.setCount(1);
                i = c.getTransCount();
                sg = new ServiceCharge(i, 3, 0.1, i - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 5.0, i - 1);
                c.addTrans(sg);
            } else {
                c.setBalance(0.1, 3);
                c.setServiceCharge(0.1);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Deposit in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                i = c.getTransCount();
                sg = new ServiceCharge(i, 3, 0.1, i - 1);
                c.addTrans(sg);
            }
        } else if (c.getBalance() >= 500.0) {
            c.setBalance(0.1, 3);
            c.setServiceCharge(0.1);
            JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Deposit in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
            i = c.getTransCount();
            sg = new ServiceCharge(i, 3, 0.1, i - 1);
            c.addTrans(sg);
        } else if (c.getBalance() < 50.0 && c.getBalance() >= 0.0) {
            if (c.getCount() == 0) {
                c.setBalance(5.1, 3);
                c.setServiceCharge(5.1);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nService Charge: Below $500 --- charge $5.00 \nWarning: Your balance is under $50. \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                c.setCount(1);
                i = c.getTransCount();
                sg = new ServiceCharge(i, 3, 0.1, i - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 5.0, i - 1);
                c.addTrans(sg);
            } else {
                c.setBalance(0.1, 3);
                c.setServiceCharge(0.1);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Deposit in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nWarning: Your balance is under $50. \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                i = c.getTransCount();
                sg = new ServiceCharge(i, 3, 0.1, i - 1);
                c.addTrans(sg);
            }
        } else if (c.getBalance() < 0.0) {
            if (c.getCount() == 0) {
                c.setBalance(15.1, 3);
                c.setServiceCharge(15.1);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nService Charge: Below $500 --- charge $5.00\nWarning: Your balance is under $50. \nService Charge: Below $0 ---charge $10.00 \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                c.setCount(1);
                i = c.getTransCount();
                sg = new ServiceCharge(i, 3, 0.1, i - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 5.0, i - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 10.0, i - 1);
                c.addTrans(sg);
            } else {
                c.setBalance(10.1, 3);
                c.setServiceCharge(10.1);
                JOptionPane.showMessageDialog((Component)null, c.getName() + "'s account- \nTransaction Amount: Check in Amount of " + dollar.format(transAmt) + "\nCurrent Balance: " + dollar.format(c.getBalance()) + "\nService Charge: Deposit --- charge $0.10 \nWarning: Your balance is under $50 \nService Charge: Below $0 ---charge $10.00 \nTotal Service Charge: " + dollar.format(c.getServiceCharge()));
                i = c.getTransCount();
                sg = new ServiceCharge(i, 3, 0.1, i - 1);
                c.addTrans(sg);
                sg = new ServiceCharge(c.getTransCount(), 3, 10.0, i - 1);
                c.addTrans(sg);
            }
        }

        return transAmt;
    }

    public static void listAccounts() {
        String line = "List of Accounts: \n\n";
        Collections.sort(dataStore);

        CheckingAccount c;
        for(Iterator var1 = dataStore.iterator(); var1.hasNext(); line = line + c.getName() + "\n") {
            c = (CheckingAccount)var1.next();
        }

        ta.setText(line);
    }

    private static class SetFocus implements AncestorListener {
        private SetFocus() {
        }

        public void ancestorAdded(AncestorEvent e) {
            JComponent component = e.getComponent();
            component.requestFocusInWindow();
        }

        public void ancestorMoved(AncestorEvent e) {
        }

        public void ancestorRemoved(AncestorEvent e) {
        }
    }
}