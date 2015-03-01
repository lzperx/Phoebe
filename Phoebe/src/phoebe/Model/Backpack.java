package phoebe.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brumi on 2015.02.28..
 */


// hátizsák osztály a ragacs és olajmennyiség tárolására

public class Backpack {

    private int ammountofOil;
    private int ammountofGlue;

    public int getAmmountofOil() {
        return  ammountofOil;
    }

    public int getAmmountofGlue() {
        return ammountofGlue;
    }

    public Backpack() {
        this.ammountofOil = 3;
        this.ammountofGlue = 3;
    }

    public void useOil(){
        if(ammountofOil>0)
        ammountofOil--;
    }

    public void useGlue(){
        if(ammountofGlue>0)
        ammountofGlue--;
    }

    public boolean hasMoreOil(){
        return ammountofOil>0;
    }

    public boolean hasMoreGlue(){
        return ammountofGlue>0;
    }

}
