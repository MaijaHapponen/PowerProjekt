package com.crap.game.model;

/**
 * Created by Lisa on 25/04/16.
 */
public class Human extends Character {

    private String informationAboutProgramme;
    private String informationAboutLocation;

    public Human(String name){

        super(name);
    }

    public Human(String name, Position position){

        super(name, position);
    }

    public String saySomethingAboutProgramme(){

        return this.informationAboutProgramme;
    }

    public String saySomethingAboutLocation(){

        return this.informationAboutLocation;
    }

    public void setProgrammeInformation(String information){

        this.informationAboutProgramme = information;
    }

    public void setLocationInformation(String information){

        this.informationAboutLocation = information;
    }
}
