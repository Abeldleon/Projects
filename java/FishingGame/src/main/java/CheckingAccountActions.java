import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CheckingAccountActions extends JPanel {
    public double initialBalance = 0.0;
    public double transAmount = 0.0;
    public int firstTime = 0;
    DecimalFormat dollar = new DecimalFormat("#,###.00");
    Transactions t;
    Account Acc;
    Check ch;
    Deposit de;
    public int check = 1;
    public int deposit = 2;
    public int serviceCharge = 3;
    private JLabel message;
    JRadioButton transaction;
    JRadioButton listTrans;
    JRadioButton checks;
    JRadioButton deposits;
    JRadioButton servicecharge;
    JRadioButton writeFile;
    JRadioButton readFromFile;

    public CheckingAccountActions() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        this.message = new JLabel("Choose an action:", 0);
        this.message.setFont(new Font("Helvetica", 1, 36));
        c.gridwidth = 2;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 40;
        this.add(this.message, c);
        this.transaction = new JRadioButton("Entering a Transaction");
        this.transaction.setBackground(Color.yellow);
        c.ipady = 0;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 1.0;
        this.add(this.transaction, c);
        this.listTrans = new JRadioButton("Listing All Transactions");
        this.listTrans.setBackground(Color.yellow);
        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        this.add(this.listTrans, c);
        this.checks = new JRadioButton("Listing All Checks");
        this.checks.setBackground(Color.yellow);
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        this.add(this.checks, c);
        this.deposits = new JRadioButton("Listing All Deposits");
        this.deposits.setBackground(Color.yellow);
        c.gridx = 1;
        c.gridy = 3;
        c.weightx = 1.0;
        this.add(this.deposits, c);
        this.servicecharge = new JRadioButton("Service Chargers");
        this.servicecharge.setBackground(Color.yellow);
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        this.add(this.servicecharge, c);
        this.readFromFile = new JRadioButton("read from file");
        this.readFromFile.setBackground(Color.yellow);
        c.gridx = 1;
        c.gridy = 4;
        c.weightx = 1.0;
        this.add(this.readFromFile, c);
        this.writeFile = new JRadioButton("write to the file");
        this.writeFile.setBackground(Color.yellow);
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        this.add(this.writeFile, c);
        ButtonGroup group = new ButtonGroup();
        group.add(this.transaction);
        group.add(this.listTrans);
        group.add(this.checks);
        group.add(this.deposits);
        group.add(this.servicecharge);
        group.add(this.readFromFile);
        group.add(this.writeFile);
        CheckingAccountListener2 listener = new CheckingAccountListener2();
        this.transaction.addActionListener(listener);
        this.listTrans.addActionListener(listener);
        this.checks.addActionListener(listener);
        this.deposits.addActionListener(listener);
        this.servicecharge.addActionListener(listener);
        this.readFromFile.addActionListener(listener);
        this.writeFile.addActionListener(listener);
        this.setBackground(Color.YELLOW);
        this.setPreferredSize(new Dimension(400, 200));
    }

    public class CheckingAccountListener2 implements ActionListener {
        public JFrame frame;

        public CheckingAccountListener2() {
        }

        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == CheckingAccountActions.this.transaction) {
                Main.setTransactions();
            }

            if (source == CheckingAccountActions.this.listTrans) {
                Main.getTransList();
            }

            if (source == CheckingAccountActions.this.checks) {
                Main.getChecks();
            }

            if (source == CheckingAccountActions.this.deposits) {
                Main.getDeposits();
            }

            if (source == CheckingAccountActions.this.servicecharge) {
                Main.getServiceCharges();
            }

            if (source == CheckingAccountActions.this.readFromFile) {
                Main.readfromfile();
            }

            if (source == CheckingAccountActions.this.writeFile) {
                Main.writeFile();
            }

        }
    }
}
