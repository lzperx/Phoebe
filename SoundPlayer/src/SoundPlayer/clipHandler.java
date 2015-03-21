package SoundPlayer;

import javax.sound.sampled.Clip;

/**
 * Created by andri_000 on 2015.02.24..
 */


// csomagolóosztály a clipeknek (sound file ok)
// névvel ellátott tárolás

public class clipHandler {

    Clip actualSound;
    String nameOfClip;



    /* input : clip
       desiredName : hang neve
     */
    clipHandler(Clip input, String desiredName){
        actualSound = input;
        nameOfClip = desiredName;
    }


    /* setterek*/

    public void setActualSound (Clip input){
        actualSound = input;
    }

    public void setNameOfClip (String desiredName){
        nameOfClip = desiredName;
    }

    /* getterek */

    public Clip getClip (){
        return  actualSound;
    }

    public String getNameOfClip(){
        return nameOfClip;
    }

}
