import java.applet.Applet;
import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

public class PlaySound {
    public PlaySound() {
    }

    public static void myPlay(String url) throws InterruptedException {
        try {
            AudioClip clip = Applet.newAudioClip(new URL(url));
            clip.play();
        } catch (MalformedURLException var2) {
            System.out.println(var2);
        }

    }
}
