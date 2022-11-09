import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Sound {

    public static final Sound music = new Sound("src/main/resources/TK_music.wav");
    public static final Sound victory = new Sound("src/main/resources/TK_highscore_short.wav");
    public static final Sound death = new Sound("src/main/resources/TK_death1.wav");
    public static final Sound gameStart = new Sound("src/main/resources/TK_gamestart1.wav");
    public static final Sound menuClick = new Sound("src/main/resources/TK_menu.wav");
    public static final Sound pickupBasic = new Sound("src/main/resources/TK_pickup_basic.wav");
    public static final Sound pickupPowerup = new Sound("src/main/resources/TK_pickup_powerup.wav");
    public static final Sound powerupAppearing = new Sound("src/main/resources/TK_powerup_appearing1.wav");
    public static final Sound walk = new Sound("src/main/resources/TK_walking1.wav");


    private Clip clip;

    public Sound(String name) {
        try {
            File file = new File(name);
            AudioInputStream sound = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(sound);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void play() {
        try {
            new Thread() {
                public void run() {
                    clip.setFramePosition(0);
                    clip.start();
                }
            }.start();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void playLooped() {
        try {
            new Thread() {
                public void run() {
                    clip.setFramePosition(0);
                    clip.loop(111);
                    clip.start();
                }
            }.start();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
