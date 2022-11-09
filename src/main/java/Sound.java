import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {

    public static final Sound music = new Sound("/TK_music.wav");
    public static final Sound victory = new Sound("/TK_highscore_short.wav");
    public static final Sound death = new Sound("/TK_death1.wav");
    public static final Sound gameStart = new Sound("/TK_gamestart1.wav");
    public static final Sound menuClick = new Sound("/TK_menu.wav");
    public static final Sound pickupBasic = new Sound("/TK_pickup_basic.wav");
    public static final Sound pickupPowerup = new Sound("/TK_pickup_powerup.wav");
    public static final Sound powerupAppearing = new Sound("/TK_powerup_appearing1.wav");
    public static final Sound walk = new Sound("/TK_walking1.wav");



    private AudioClip clip;

    public Sound(String name) {
        try {
            clip = Applet.newAudioClip(Sound.class.getResource(name));
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            new Thread() {
                public void run() {
                    clip.loop();
                }
            }.start();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
