package com.crap.game.controller;

import com.crap.game.model.Character;
import com.crap.game.model.Game;
import com.crap.game.view.CharacterView;

import java.util.Random;

public class CharacterController{

    private CharacterView view;
    private Game game;
    private Character character;
    private CollisionController collisionController;

    public CharacterController(/*Game game, CharacterView view, */Character character,
                               CollisionController collisionController){
        this.character = character;
        this.collisionController = collisionController;
    }

    //Makes the character walk away a few steps.
    public void walkAway(){
        Random rand = new Random();
        int j = 0;

        while(j<3){
            int i = rand.nextInt(3);

            if(i==0 && collisionController.isCollison(character.getPosition().getX(),
                    character.getPosition().getY()+1) && this.character.getPosition().getY()<1000){ //TODO should be height of world not 1000
                this.moveUp();
            }
            else if(i==1 && collisionController.isCollison(character.getPosition().getX(),
                    character.getPosition().getY()-1) && this.character.getPosition().getY()>0){
                this.moveDown();
            }
            else if(i==2 && collisionController.isCollison(character.getPosition().getX()-1,
                    character.getPosition().getY()) && this.character.getPosition().getX()>0){
                this.moveLeft();
            }
            else if(i==3 && collisionController.isCollison(character.getPosition().getX()+1,
                    character.getPosition().getY()+1) && this.character.getPosition().getX()<1000){ //TODO should be width of world not 1000
                this.moveRight();
            }
            j++;
        }
    }

    public void moveUp() {
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY() + 1);
    }
    public void moveDown(){
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY() - 1);
    }

    public void moveLeft(){
        this.character.getPosition().setPosition(this.character.getPosition().getX() - 1,
                this.character.getPosition().getY());
    }

    public void moveRight(){
        this.character.getPosition().setPosition(this.character.getPosition().getX() + 1,
                this.character.getPosition().getY());
    }


}

