package Main;

import SoundPlayer.soundPlayer;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

/**
 * Created by andri_000 on 2015.02.23..
 */
public class Main {
    public static void main(String[] args) {
        soundPlayer player1 = new soundPlayer();
        try {
            player1.loadSounds();
        } catch (Exception e) {
            e.printStackTrace();
        }
        player1.playSounds("hogyne");
        player1.playSounds("highscore");
        player1.playSounds("hogyne");

//        most én ide betrollkodok hogy tudok e commitelni
        
    }
}
