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

                humans.get(i).setGreetingInformation("Hello! I study the programme of Elektroteknik. " +
                        "Can I help you with some information? " + "What would you like to know more about?");

                humans.get(i).setProgrammeInformation("Kalle Ankas love interest is called Kajsa");
                humans.get(i).setLocationInformation("Kalle Anka likes to hang out in the sandbox");
            }
            else if(humans.get(i).getName() == "DHuman") {

                humans.get(i).setGreetingInformation("Hello! I study the programme of Datateknik. " +
                        "Can I help you with some information? " + "What would you like to know more about?");

                humans.get(i).setProgrammeInformation("Hacke Hackspetts favorite color is Orange");
                humans.get(i).setLocationInformation("Hacke Hackspett is fascinated by cars");
            }
            else if(humans.get(i).getName() == "ITHuman") {

                humans.get(i).setGreetingInformation("Hello! I study the programme of IT. " +
                        "Can I help you with some information? " + "What would you like to know more about?");

                humans.get(i).setProgrammeInformation("IT stands for Informationsteknik");
                humans.get(i).setLocationInformation("ITSmurfen is with his friends in Hubben");
            }
            else if(humans.get(i).getName() == "ZHuman") {

                humans.get(i).setGreetingInformation("Hello! I study the programme of Automation and Mekatronik. " +
                        "Can I help you with some information? " + "What would you like to know more about?");

                humans.get(i).setProgrammeInformation("Lucky Lukes horse is called Jolly Jumper");
                humans.get(i).setLocationInformation("Lucky Luke is ready to draw his pistols in the Zaloon");
            }
        }
    }
}
