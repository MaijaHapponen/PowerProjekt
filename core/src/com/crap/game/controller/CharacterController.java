package com.crap.game.controller;

import com.crap.game.model.Character;
import com.crap.game.model.Game;
import com.crap.game.view.CharacterView;

import java.util.Random;

public class CharacterController{

    private CharacterView view;
    private Game game;
    private Character character;

    public CharacterController(/*Game game, CharacterView view, */Character character){
        this.character = character;
    }

    //Makes the character walk away a few steps.
    public void walkAway(){
        Random rand = new Random();
        int j = 0;

        while(j<3){
            int i = rand.nextInt(3);

            if(i==0 /* && !collision */){
                this.moveUp();
            }
            else if(i==1 /* && !collision */){
                this.moveDown();
            }
            else if(i==2  /* && !collision */){
                this.moveLeft();
            }
            else if(i==3  /* && !collision */){
                this.moveRight();
            }
            else{
                //TODO avsluta while loopen så den inte blir oändlig.
                //TODO Kommer loopen hit betyder det att character inte kan röra sig åt något håll.
            }
        }


        //Random nummber mellan 0-3. om 0: upp om 1: ner om 2: vänster om 3: höger. Kolla om det går att flytta annars
        // testa annan rikting. varje gång lyckad flyttning ---> lägg till 1 till en int variabel och när den är tex. 3
        // är walkAway klart.
        //TODO fixa sen när Beccis pushad upp senaste CollisionModel.

    }

    public void moveUp() {
        if(this.character.getPosition().getY()<1000){ //TODO should be height of world not 1000
            this.character.getPosition().setPosition(this.character.getPosition().getX(),
                    this.character.getPosition().getY() + 1);
        }
    }
    public void moveDown(){
        if(this.character.getPosition().getY()>0) {
            this.character.getPosition().setPosition(this.character.getPosition().getX(),
                    this.character.getPosition().getY() - 1);
        }
    }

    public void moveLeft(){
        if(this.character.getPosition().getX()>0) {
            this.character.getPosition().setPosition(this.character.getPosition().getX() - 1,
                    this.character.getPosition().getY());
        }
    }

    public void moveRight(){
        if(this.character.getPosition().getX()<1000) { //TODO should be width of world not 1000
            this.character.getPosition().setPosition(this.character.getPosition().getX() + 1,
                    this.character.getPosition().getY());
        }
    }


}

