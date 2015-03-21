package SoundPlayer;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent.Type;

/**
 * Created by andri_000 on 2015.02.24..
 */


/*
    Az osztály feladata, hogy figyelje,
    hogy a lejátszandó file véget ért-e.
    ha igen, akkor ezt a soundOver boolean változó true értékével jelzi.
 */

public class soundListener implements LineListener{
    private boolean soundOver = false;

    @Override
    public synchronized void update(LineEvent event) {

        /* ha a lejátszás befejeződik, vagy valamilyen okból végeszakad,
            a soundOver változó értékét true ba állítjuk */
        Type eventType = event.getType();
        if ( eventType == Type.STOP ||eventType == Type.CLOSE ){
            soundOver = true;
            notifyAll();
        }
    }

    /* Amíg az aktuális clip lejátszás alatt van, addig várjuk a végét */

    public synchronized void waitUntilDone() throws InterruptedException{
        while (!soundOver){
            wait();
        }
    }


    public void setSoundOver (boolean isIt){
        soundOver = isIt;
    }


}
