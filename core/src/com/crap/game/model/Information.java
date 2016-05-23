package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 17/05/16.
 */
public class Information {

    public Information(ArrayList<Human> humans){
        setInformation(humans);
    }

    public void setInformation(ArrayList<Human> humans) {

        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getName() == "kalleAnka") {
                humans.get(i).setInformation("Kalle Ankas love interest is called Kajsa");
            }
            else if(humans.get(i).getName() == "hackeHackspett") {
                humans.get(i).setInformation("Hacke Hackspetts favorite color is Orange");
            }
            else if(humans.get(i).getName() == "iTSmurfen") {
                humans.get(i).setInformation("IT stands for Informationsteknik");
            }
            else if(humans.get(i).getName() == "luckyluke") {
                humans.get(i).setInformation("Lucky Lukes horse is called Jolly Jumper");
            }
        }
    }
}
