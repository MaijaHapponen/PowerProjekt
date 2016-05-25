package com.crap.game.model;

/**
 * Created by Lisa on 25/04/16.
 */
public class Human extends Character {

    private String informationAboutProgramme;
    private String informationAboutLocation;
    private String informationAboutGreeting;

    public Human(String name){

        super(name);
    }

    public Human(String name, Position position, Game.Worlds world){

        super(name, position, world);
    }

    public String saySomethingAboutProgramme(){

        return this.informationAboutProgramme;
    }

    public String saySomethingAboutLocation(){

        return this.informationAboutLocation;
    }

    public String saySomethingAboutGreeting(){

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
