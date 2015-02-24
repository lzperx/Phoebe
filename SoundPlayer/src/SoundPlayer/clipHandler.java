package SoundPlayer;

import javax.sound.sampled.Clip;

/**
 * Created by andri_000 on 2015.02.24..
 */
public class clipHandler {

    Clip actualSound;
    String nameOfClip;

    clipHandler(Clip input, String desiredName){
        actualSound = input;
        nameOfClip = desiredName;
    }

    public void setActualSound (Clip input){
        actualSound = input;
    }

    public void setNameOfClip (String desiredName){
        nameOfClip = desiredName;
    }

    public Clip getClip (){
        return  actualSound;
    }

    public String getNameOfClip(){
        return nameOfClip;
    }

}
