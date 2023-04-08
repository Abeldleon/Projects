import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class JFrameL extends JFrame {
    public JFrameL(String title) {
        super(title);
        FrameListener listener = new FrameListener();
        this.addWindowListener(listener);
    }

    private class FrameListener extends WindowAdapter {
        private FrameListener() {
        }

        public void windowClosing(WindowEvent e) {
            if (!Main.save()) {
                int confirm = JOptionPane.showConfirmDialog((Component)null, "Do you want to save your data?", "close", 0);
                if (confirm == 0) {
                    Main.writeFile();
                }
            }

            System.exit(0);
        }
    }
}
