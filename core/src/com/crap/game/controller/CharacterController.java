package com.crap.game.controller;

import com.crap.game.model.Character;
import com.crap.game.model.Human;
import com.crap.game.model.Mascot;
import com.crap.game.view.CharacterView;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;

import java.util.ArrayList;
import java.util.Random;

public class CharacterController{

    public enum Direction{UP, DOWN, LEFT, RIGHT}

    private Character character;
    private CharacterView characterView;
    private GameView gameView;
    private CollisionController collisionController;
    private ArrayList<Human> humansList = new ArrayList<Human>();
    private ArrayList<Mascot> mascotsList = new ArrayList<Mascot>();
    private ArrayList<CharacterView> humanViews = new ArrayList<CharacterView>();
    private ArrayList<CharacterView> mascotViews = new ArrayList<CharacterView>();
    private int walkAwayLength = 60;
    private int walkAwayState = walkAwayLength;
    private Direction walkAwayDirection;



    public CharacterController(GameView gameView, ArrayList<Human> humansList, ArrayList<Mascot> mascotsList,
                               ArrayList<CharacterView> humanViews, ArrayList<CharacterView> mascotViews){
        this.gameView = gameView;
        this.humansList = humansList;
        this.mascotsList = mascotsList;
        this.humanViews = humanViews;
        this.mascotViews = mascotViews;
//TODO        this.collisionController = collisionController; Create your own instead.

        //TODO temp.
        this.character = mascotsList.get(1);
        this.characterView = mascotViews.get(1);
        //TODO temp.
    }

    //Makes the character walk away a few steps.
    public void walkAway(Direction direction){
        //TODO find the character with a loop in the humans and mascots lists. When found: Set characer = to that. (Set characterView aswell??)
        //TODO maybe make a lastDirection var so that the character wont go eg. up-down-up since it wouldn't make sense.

        switch (direction){
            case UP: this.moveUp();
                break;
            case DOWN: this.moveDown();
                break;
            case LEFT: this.moveLeft();
                break;
            case RIGHT: this.moveRight();
                break;
        }
    }

    public void moveUp() {
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY() + 2);
    }
    public void moveDown(){
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY() - 2);
    }

    public void moveLeft(){
        this.character.getPosition().setPosition(this.character.getPosition().getX() - 2,
                this.character.getPosition().getY());
    }

    public void moveRight(){
        this.character.getPosition().setPosition(this.character.getPosition().getX() + 2,
                this.character.getPosition().getY());
    }

    public void updateSprite() {
        characterView.getSprite().setPosition(this.character.getPosition().getX(), this.character.getPosition().getY());
    }

    public void updateAnimation(PlayerView.AnimationState animationState){
        characterView.setAnimationState(animationState);
        characterView.updateAnimation();
    }

    public int getWalkAwayLength(){
        return this.walkAwayLength;
    }

    public int getWalkAwayState(){
        return this.walkAwayState;
    }

    public void resetWalkAwayState(){
        this.walkAwayState = 0;
    }

    public void walkAwayOneStep(){
        Random rand = new Random();
        if(walkAwayState == walkAwayLength/3 || walkAwayState == (walkAwayLength/3)*2){
            walkAwayDirection = null;
        } //TODO add checkCollision/checkIfCollision?? here?

        if (walkAwayDirection == null){
            int i = rand.nextInt(4);
            switch (i){
                case 0: walkAwayDirection = Direction.UP;
                    break;
                case 1: walkAwayDirection = Direction.DOWN;
                        break;
                case 2: walkAwayDirection = Direction.LEFT;
                    break;
                case 3: walkAwayDirection = Direction.RIGHT;
                    break;
            }
        }

        if(walkAwayState < walkAwayLength/3){
            this.walkAway(walkAwayDirection);
        }
        else if(walkAwayState < (walkAwayLength/3)*2){
            this.walkAway(walkAwayDirection);
        }
        else if(walkAwayState < walkAwayLength){
            this.walkAway(walkAwayDirection);
        }

        updateSprite();
        walkAwayState++;
    }

}
//TODO 1. Check so that character won't go off screen.
//TODO 2. Fix lastDirection to avoid up-down-up shit.
//TODO 3. Add animations.
//TODO 4. Fix for all characters.
//TODO 5. Add collisions.
