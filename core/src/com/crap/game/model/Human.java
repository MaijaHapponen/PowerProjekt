package com.crap.game.model;

public class Human extends Character {

    private String informationAboutProgramme;
    private String informationAboutLocation;
    private String informationAboutGreeting;

    public Human(String name){
        super(name);
    }

    public Human(String name, Position position, CRAP.Worlds world){
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
