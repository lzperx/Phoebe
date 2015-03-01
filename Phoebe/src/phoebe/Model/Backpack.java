package phoebe.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brumi on 2015.02.28..
 */


// hátizsák osztály a ragacs és olajmennyiség tárolására

public class Backpack extends Throwable {

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
       try{
           if(ammountofOil==0) throw new Exception();
           else
               ammountofOil--;
       }catch (Exception e){
            System.out.println("Kifogytál az olajból!");
       }
    }

    public void useGlue(){
        try{
            if(ammountofGlue==0) throw new Exception();
            else
                ammountofGlue--;
        }catch (Exception e){
            System.out.println("Kifogytál a ragacsból!");
        }
    }

    public boolean hasMoreOil(){
        return ammountofOil>0;
    }

    public boolean hasMoreGlue(){
        return ammountofGlue>0;
    }

}
