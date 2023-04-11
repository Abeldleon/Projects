package soccer;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author De Leon
 */
public class SOCCER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setResizable(false);
        game g = new game();
        frame.setTitle("Abel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(g);
        frame.setVisible(true);
        frame.pack();
    }
    
}
