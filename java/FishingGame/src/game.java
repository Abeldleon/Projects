import java.awt.Component;
import javax.swing.JFrame;

public class game {
    public game() {
    }

    public static void gameWindow() {
        JFrame frame = new JFrame();
        GamePlay gamew = new GamePlay();
        frame.setTitle("Abel");
        frame.setDefaultCloseOperation(3);
        frame.add(gamew);
        frame.setLocationRelativeTo((Component)null);
        frame.setVisible(true);
        frame.pack();
    }
}
