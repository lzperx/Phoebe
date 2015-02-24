package SoundPlayer;


import javax.sound.sampled.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by andri_000 on 2015.02.24..
 */
public class soundPlayer {


    Clip actualSound;
    ArrayList<clipHandler> gameSounds = new ArrayList<clipHandler>();
    //ArrayList<Clip> gameSounds = new ArrayList<Clip>();
    String workingDirectory; //A program indulási mappája
    String fileNames; //A zenék mappája
    File soundFolder;
    soundListener listener = new soundListener(); // Figyel, hogy a lejátszandó file véget ért e.
    boolean running = false;

    //Beállítja a hangok mappjának a program indítási mappáját.
    public soundPlayer() {
        Path currentRelativePath = Paths.get("");
        workingDirectory = currentRelativePath.toAbsolutePath().toString();
        fileNames = (workingDirectory + File.separator + "Sounds" + File.separator);
        soundFolder = new File(fileNames);
    }

    public void loadSounds() { //Betölt minden hang file-t a mappából
        for (File sounds : soundFolder.listFiles()) {
            if (sounds.isFile() && sounds.getName().contains(".wav")) {
                try {

                    actualSound = AudioSystem.getClip();
                    actualSound.open(AudioSystem.getAudioInputStream(new File(fileNames + sounds.getName())));
                    clipHandler handler = new clipHandler(actualSound, sounds.getName());
                    gameSounds.add(handler);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void playSounds(String soundName) { //Lejátsza a megfelelő számot a listából
        for (clipHandler actualHandler : gameSounds) {
            if (actualHandler.getNameOfClip().contains(soundName)) {
                Clip playingClip = actualHandler.getClip();
                //System.out.println(actualHandler.getNameOfClip()); Csak ellenőrzés képp, de tényleg bennevan a listában a kért 2 elem.
                playingClip.addLineListener(listener);
                playingClip.start();
                try {
                    listener.setSoundOver(false);
                    listener.waitUntilDone();
                    playingClip.setFramePosition(0);
                } catch (InterruptedException e) {
                    System.out.println("Megszakadt a lejátszás");
                }
            }
        }
    }
}
/* Először ezt írtam meg, ezt általánosítottam amikor működött
    //Beállítja a Highscore file-t.
    public void setHighscore() throws IOException, UnsupportedAudioFileException {
        try {
            actualSound = AudioSystem.getClip();
            actualSound.open(AudioSystem.getAudioInputStream(new File(fileNames + "highscore.wav" )));
            actualSound.addLineListener(listener);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(fileNames);
    }
    //Lejátsza a beállított Highscore file-t
    public void playHighscore (){
        actualSound.addLineListener(listener);
        actualSound.start();
        try {
            listener.waitUntilDone();
        } catch (InterruptedException e) {
            System.out.println("Megszakadt a lejátszás");
        }
    }
*/

