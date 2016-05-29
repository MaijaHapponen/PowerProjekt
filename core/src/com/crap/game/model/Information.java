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
            if (humans.get(i).getName() == "EHuman") {

                humans.get(i).setGreetingInformation("Hello! I study the programme \n of Elektroteknik. " +
                        "Can I\n help you with some\n information? " + "What would \nyou like to know more about?");

                humans.get(i).setProgrammeInformation("Kalle Ankas love interest is called Kajsa");
                humans.get(i).setLocationInformation("Kalle Anka likes to \n hang out in the sandbox");
            }
            else if(humans.get(i).getName() == "DHuman") {  

                humans.get(i).setGreetingInformation("Hello! I study the programme \n of Datateknik. " +
                        "Can I help you\n with some information? " + "What\n would you like to know\n more about?");

                humans.get(i).setProgrammeInformation("Hacke Hackspetts favorite \n color is Orange");
                humans.get(i).setLocationInformation("Hacke Hackspett is \n fascinated by cars");
            }
            else if(humans.get(i).getName() == "ITHuman") {

                humans.get(i).setGreetingInformation("Hello! I study the programme \n of IT. " +
                        "\n Can I help you with some \n information? " + "What would \n you like to know more about?");

                humans.get(i).setProgrammeInformation("IT stands for Informationsteknik");
                humans.get(i).setLocationInformation("ITSmurfen is with his friends \n in Hubben");
            }
            else if(humans.get(i).getName() == "ZHuman") {

                humans.get(i).setGreetingInformation("Hello! I study the programme \n of Automation and\n Mekatronik. " +
                        "Can I help you \n with some information? " + "What\n would you like to know\n more about?");

                humans.get(i).setProgrammeInformation("Lucky Lukes horse is called\n Jolly Jumper");
                humans.get(i).setLocationInformation("Lucky Luke is ready to draw \n his pistols in the Zaloon");
            }
        }
    }
}
