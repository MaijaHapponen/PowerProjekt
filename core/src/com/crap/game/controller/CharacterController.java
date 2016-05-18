package com.crap.game.controller;

import com.crap.game.model.Character;
import com.crap.game.view.CharacterView;
import com.crap.game.view.PlayerView;

import java.util.Random;

public class CharacterController{

    private Character character;
    private CharacterView characterView;
    private CollisionController collisionController;

    public CharacterController(Character character, CharacterView characterView,
                               CollisionController collisionController){
        this.character = character;
        this.characterView = characterView;
        this.collisionController = collisionController;
    }

    //Makes the character walk away a few steps.
    public void walkAway(){
        Random rand = new Random();
        int j = 0;

        while(j<5){
            int i = rand.nextInt(3);

            if(i==0 && collisionController.isCollison(character.getPosition().getX(),
                    character.getPosition().getY()+1) && this.character.getPosition().getY()<1000){ //TODO should be height of world not 1000
                this.moveUp();
                this.updateAnimation(PlayerView.AnimationState.WALKING_BACK); //TODO set repeat to false when the animation is called.
            }
            else if(i==1 && collisionController.isCollison(character.getPosition().getX(),
                    character.getPosition().getY()-1) && this.character.getPosition().getY()>0){
                this.moveDown();
                this.updateAnimation(PlayerView.AnimationState.WALKING_FRONT);
            }
            else if(i==2 && collisionController.isCollison(character.getPosition().getX()-1,
                    character.getPosition().getY()) && this.character.getPosition().getX()>0){
                this.moveLeft();
                this.updateAnimation(PlayerView.AnimationState.WALKING_LEFT);
            }
            else if(i==3 && collisionController.isCollison(character.getPosition().getX()+1,
                    character.getPosition().getY()+1) && this.character.getPosition().getX()<1000){ //TODO should be width of world not 1000
                this.moveRight();
                this.updateAnimation(PlayerView.AnimationState.WALKING_RIGHT);
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

    public void updateAnimation(PlayerView.AnimationState animationState){
        characterView.setAnimationState(animationState);
        characterView.updateAnimation();
    }

}

