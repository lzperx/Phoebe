package SoundPlayer;


import javax.sound.sampled.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


/**
 * Created by andri_000 on 2015.02.24..
 */


/* Zenelejátszó osztály a játékban használt hangeffektek lejátszásához.
   A clipeket .wav kiterjesztésben kell tárolni,
   mivel csak ehhez a fájlformátumhoz van támogatás */

public class soundPlayer {


    Clip actualSound;
    ArrayList<clipHandler> gameSounds = new ArrayList<clipHandler>();
    String workingDirectory;                                         //A program indulási mappája
    String fileNames;                                                //A zenék mappája
    File soundFolder;
    soundListener listener = new soundListener();                    // Figyel, hogy a lejátszandó file véget ért e.
    boolean running = false;

    /*Beállítja a hangok mappjának a program indítási mappáját.
    * A .vav file okat a megfelelő névvel
    * ide kell elhelyezni.*/
    public soundPlayer() {
        Path currentRelativePath = Paths.get("");
        workingDirectory = currentRelativePath.toAbsolutePath().toString();
        fileNames = (workingDirectory + File.separator + "Sounds" + File.separator);
        soundFolder = new File(fileNames);
    }


    /* Betölt minden hang file-t a
     * mappából a gameSounds listába,
     *  és lejátszásra késszé teszi őket
     *  */
    public void loadSounds() {
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

    /*Lejátsza a megfelelő számot a listából.
    * A szám kiválasztása a clipHandler nameOfClip attribútuma
    * alapján történik*/
    public void playSounds(String soundName) {
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


