package SoundPlayer;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent.Type;

/**
 * Created by andri_000 on 2015.02.24..
 */
public class soundListener implements LineListener{
    private boolean soundOver = false;
    @Override
    public synchronized void update(LineEvent event) {
        Type eventType = event.getType();
        if ( eventType == Type.STOP ||eventType == Type.CLOSE ){
            soundOver = true;
            notifyAll();
        }
    }

    public synchronized void waitUntilDone() throws InterruptedException{
        while (!soundOver){
            wait();
        }
    }


}
