package soccer;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
public class game extends JPanel implements KeyListener
{
    private int WIDTH = 1300;
    private int HEIGHT = 800;
    private final Image goal = new ImageIcon("goal.jpg").getImage();
    private final Image goalie = new ImageIcon("goalie.png").getImage();
    private final ImageIcon ball = new ImageIcon("soccer_ball.png");
    private final Image scale_goalie = goalie.getScaledInstance(80,100,Image.SCALE_DEFAULT);
    private final Image scale_ball = ball.getImage().getScaledInstance(60, 60,Image.SCALE_DEFAULT);
    private int goaliePosX = 400;
    private int goaliePosY = 350;
    private int goaliesSpeedX = 15;
    private int ballPosX = 400;
    private int ballPosY = 700;
    private int ballSpeedX = 30;
    private int ballSpeedY = -5;
    private Timer timer;
    private int DELAY = 15;  
    private boolean kick = false;
    private boolean caught = false;
    public game()
    {      
        timer = new Timer(DELAY, new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                goaliePosX += goaliesSpeedX;
                if (goaliePosX > 800)
                    goaliesSpeedX = -goaliesSpeedX;
                if (goaliePosX < 400)
                    goaliesSpeedX  = -goaliesSpeedX;
                if(kick)
                    ballPosY += ballSpeedY;
                if(ballPosY == 400)
                {
                    kick = false;
                    checkCollision();
                    if(caught)
                    {
                        ballPosY = 700;                       
                    }
                    else
                    {
                    String url;
                    url = "file:coin.wav";
                    try {
                        //PlaySound.myPlay(url);
                        AudioClip clip = Applet.newAudioClip(new URL(url));
                        clip.play();
                        System.out.println("sound?");
                    } catch (MalformedURLException murle) {
                        System.out.println(murle);
                    }
                        System.out.println("goal");
                        timer.stop();
                    }                 
                }
                repaint();
            }
        }
        );
        addKeyListener(this);
        setFocusable(true);     
    } 
       @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(WIDTH,HEIGHT);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(goal, 0, 0,WIDTH,HEIGHT, this);  
        g.drawImage(scale_goalie,goaliePosX,goaliePosY, this);
        g.setColor(new Color(255, 255, 255, 150));
        g.fillRect(goaliePosX, goaliePosY, 80,  100);
        g.drawImage(scale_ball, ballPosX, ballPosY, this);
        //ball.paintIcon(this, g, 200, 200);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_ENTER:
            {
                timer.start();
                System.out.println("press enterd");
                break;
            }
            case KeyEvent.VK_SPACE:
            {
                kick = true;
                break;
            }
            case KeyEvent.VK_RIGHT:
            {
                ballPosX += ballSpeedX;
                break;
            }
            case KeyEvent.VK_LEFT:
            {
                ballPosX -= ballSpeedX;
                break;
            }
                
        }
    }  
    public void checkCollision()
    {
        if (ballPosX < goaliePosX + goalie.getWidth(this) && ballPosX + scale_ball.getWidth(this) > goaliePosX ||
              ballPosX < 350 || ballPosX > 800  )
            caught = true;
        else
            caught = false;
    }
    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}