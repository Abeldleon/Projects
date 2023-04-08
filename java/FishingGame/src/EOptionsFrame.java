import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class EOptionsFrame extends JFrameL {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 1000;
    private JMenu fileMenu;
    private JMenu accountMenu;
    private JMenu transactionsMenu;
    private JMenu playGameMenu;
    private JMenuItem readFile;
    private JMenuItem writeFile;
    private JMenuItem addAccount;
    private JMenuItem listAccountsTransaction;
    private JMenuItem listAllChecks;
    private JMenuItem listAllDeposits;
    private JMenuItem findAccount;
    private JMenuItem addTransactions;
    private JMenuItem listServiceCharges;
    private JMenuItem listAccounts;
    private JMenuItem play;
    private JMenuBar bar;

    public EOptionsFrame(String title) {
        super(title);
        this.setSize(700, 1000);
        this.setDefaultCloseOperation(3);
        MenuListener ml = new MenuListener();
        this.fileMenu = new JMenu("File");
        this.readFile = new JMenuItem("Read from file");
        this.readFile.addActionListener(ml);
        this.fileMenu.add(this.readFile);
        this.writeFile = new JMenuItem("Write to file");
        this.writeFile.addActionListener(ml);
        this.fileMenu.add(this.writeFile);
        this.accountMenu = new JMenu("Account");
        this.addAccount = new JMenuItem("Add new account");
        this.addAccount.addActionListener(ml);
        this.accountMenu.add(this.addAccount);
        this.listAccountsTransaction = new JMenuItem("List accounts transaction");
        this.listAccountsTransaction.addActionListener(ml);
        this.accountMenu.add(this.listAccountsTransaction);
        this.listAllChecks = new JMenuItem("List all checks");
        this.listAllChecks.addActionListener(ml);
        this.accountMenu.add(this.listAllChecks);
        this.listAllDeposits = new JMenuItem("List all deposits");
        this.listAllDeposits.addActionListener(ml);
        this.accountMenu.add(this.listAllDeposits);
        this.findAccount = new JMenuItem("Find an account");
        this.findAccount.addActionListener(ml);
        this.accountMenu.add(this.findAccount);
        this.listServiceCharges = new JMenuItem("List Service Charges");
        this.listServiceCharges.addActionListener(ml);
        this.accountMenu.add(this.listServiceCharges);
        this.listAccounts = new JMenuItem("List Accoutns");
        this.listAccounts.addActionListener(ml);
        this.accountMenu.add(this.listAccounts);
        this.transactionsMenu = new JMenu("Transactions");
        this.addTransactions = new JMenuItem("Add Transactions");
        this.addTransactions.addActionListener(ml);
        this.transactionsMenu.add(this.addTransactions);
        this.playGameMenu = new JMenu("Game");
        this.play = new JMenuItem("Play Game");
        this.play.addActionListener(ml);
        this.playGameMenu.add(this.play);
        this.bar = new JMenuBar();
        this.bar.add(this.fileMenu);
        this.bar.add(this.accountMenu);
        this.bar.add(this.transactionsMenu);
        this.bar.add(this.playGameMenu);
        this.setJMenuBar(this.bar);
    }

    private class MenuListener implements ActionListener {
        private MenuListener() {
        }

        public void actionPerformed(ActionEvent event) {
            String source = event.getActionCommand();
            if (source.equals("Add new account")) {
                Main.addAccount();
            } else if (source.equals("List accounts transaction")) {
                Main.getTransList();
            } else if (source.equals("List all checks")) {
                Main.getChecks();
            } else if (source.equals("List all deposits")) {
                Main.getDeposits();
            } else if (source.equals("Find an account")) {
                Main.findAccount();
            } else if (source.equals("Read from file")) {
                Main.readfromfile();
            } else if (source.equals("Write to file")) {
                Main.writeFile();
            } else if (source.equals("Add Transactions")) {
                Main.setTransactions();
            } else if (source.equals("List Service Charges")) {
                Main.getServiceCharges();
            } else if (source.equals("List Accoutns")) {
                Main.listAccounts();
            } else if (source.equals("Play Game")) {
                game.gameWindow();
            }

        }
    }
}