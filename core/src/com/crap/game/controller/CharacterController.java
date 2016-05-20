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
    private Direction lastDirection;



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
    public void move(Direction direction){
        //TODO find the character with a loop in the humans and mascots lists. When found: Set characer = to that. (Set characterView aswell??)
        //TODO maybe make a lastDirection var so that the character wont go eg. up-down-up since it wouldn't make sense.

        switch (direction){
            case UP:
                if(isPositionEmpty(character.getPosition().getX(), character.getPosition().getY()+2)) {
                    this.moveUp();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
            case DOWN:
                if(isPositionEmpty(character.getPosition().getX(), character.getPosition().getY()-2)) {
                    this.moveDown();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
            case LEFT:
                if(isPositionEmpty(character.getPosition().getX()-2, character.getPosition().getY())) {
                    this.moveLeft();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
            case RIGHT:
                if(isPositionEmpty(character.getPosition().getX()+2, character.getPosition().getY())) {
                    this.moveRight();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
        }
    }

    public void moveUp() {
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY() + 2);
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_BACK);
        this.characterView.updateAnimation();
    }
    public void moveDown(){
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY() - 2);
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_FRONT);
        this.characterView.updateAnimation();
    }

    public void moveLeft(){
        this.character.getPosition().setPosition(this.character.getPosition().getX() - 2,
                this.character.getPosition().getY());
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_LEFT);
        this.characterView.updateAnimation();
    }

    public void moveRight(){
        this.character.getPosition().setPosition(this.character.getPosition().getX() + 2,
                this.character.getPosition().getY());
        this.characterView.setAnimationState(PlayerView.AnimationState.WALKING_RIGHT);
        this.characterView.updateAnimation();
    }

    public void updateSprite() {
        characterView.getSprite().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY());
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

    public void walkAway(){
        if(walkAwayState<walkAwayLength){
            walkAwayOneStep();
        }
    }

    public boolean isPositionEmpty(float x, float y){
        if(x<0 || x>1000 || y<0 || y>1000){ //TODO fix 1000.
            return false;
        }
        return true;
    }

    public void decideNewDirection(){
        Random rand = new Random();
        int i = rand.nextInt(4);
        switch (i){
            case 0:
                if(lastDirection != Direction.DOWN) {
                    walkAwayDirection = Direction.UP;
                }
                else{
                    decideNewDirection();
                }
                break;
            case 1:
                if(lastDirection != Direction.UP) {
                    walkAwayDirection = Direction.DOWN;
                }
                else{
                    decideNewDirection();
                }
                break;
            case 2:
                if(lastDirection != Direction.RIGHT) {
                    walkAwayDirection = Direction.LEFT;
                }
                else{
                    decideNewDirection();
                }
                break;
            case 3:
                if(lastDirection != Direction.LEFT) {
                    walkAwayDirection = Direction.RIGHT;
                }
                else{
                    decideNewDirection();
                }
                break;
        }
    }

    public void stopWalkingAnimation(){
        switch (walkAwayDirection){
            case UP:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_BACK);
                this.characterView.updateAnimation();
                break;
            case DOWN:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_FRONT);
                this.characterView.updateAnimation();
                break;
            case LEFT:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_LEFT);
                this.characterView.updateAnimation();
                break;
            case RIGHT:
                this.characterView.setAnimationState(PlayerView.AnimationState.STANDING_RIGHT);
                this.characterView.updateAnimation();
                break;
        }
    }

    public void walkAwayOneStep(){
        if(walkAwayState == walkAwayLength/3 || walkAwayState == (walkAwayLength/3)*2){
            lastDirection = walkAwayDirection;
            walkAwayDirection = null;
        }

        if (walkAwayDirection == null){
            decideNewDirection();
        }
        this.move(walkAwayDirection);

        if(walkAwayState == walkAwayLength-1){
            stopWalkingAnimation();
        }

        updateSprite();
        walkAwayState++;
    }

}

//TODO 4. Fix for all characters.
//TODO 5. Add collisions.
