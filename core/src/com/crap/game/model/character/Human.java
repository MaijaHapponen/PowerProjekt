package com.crap.game.model.character;

import com.crap.game.model.information.enums.Worlds;
import com.crap.game.model.primary.Position;

import java.lang.*;

public class Human extends Character {

    private String informationAboutProgramme;
    private String informationAboutLocation;
    private String informationAboutGreeting;

    public Human(String name){
        super(name);
    }

    public Human(String name, Position position, Worlds world){
        super(name, position, world);
    }

    public String getInformationAboutProgramme(){
        return this.informationAboutProgramme;
    }

    public String getInformationAboutLocation(){
        return this.informationAboutLocation;
    }

    public String getInformationAboutGreeting(){
        return this.informationAboutGreeting;
    }

    public void setProgrammeInformation(String information){
        this.informationAboutProgramme = information;
    }

    public void setLocationInformation(String information){
        this.informationAboutLocation = information;
    }

    public void setGreetingInformation(String information){
        this.informationAboutGreeting = information;
    }
}
