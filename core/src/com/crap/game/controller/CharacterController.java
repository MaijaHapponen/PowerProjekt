package com.crap.game.controller;

import com.crap.game.model.Character;
import com.crap.game.view.CharacterView;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;

import java.util.Random;

public class CharacterController{

    public enum Direction{UP, DOWN, LEFT, RIGHT}

    private GameView gameView;
    private Character character;
    private CharacterView characterView;
    private CollisionController collisionController;
    private int walkAwayLength = 60;
    private int walkAwayState = walkAwayLength;
    private Direction walkAwayDirection;
    private Direction lastDirection;
    private InteractionController interactionController;

    public CharacterController(GameView view){
        this.gameView = view;
        this.collisionController = new CollisionController(view.getWorld());
        interactionController = new InteractionController(view);
    }

    public void interactsWith(Character character, CharacterView characterView){
        collisionController.setPlayerWidthAndHeight(characterView.getCharacterSpriteWidth(),
                characterView.getCharacterSpriteHeight());
        this.character = character;
        this.characterView = characterView;
    }

    public void updateCollisionController(){
        this.collisionController = new CollisionController(gameView.getWorld());
        if(characterView != null) {
            collisionController.setPlayerWidthAndHeight(characterView.getCharacterSpriteWidth(),
                    characterView.getCharacterSpriteHeight());
        }
    }

    public void move(Direction direction){

        //TODO: remove magic number
        switch (direction){
            case UP:
                if(isPositionEmpty(character.getPosition().getX(), character.getPosition().getY()+2)){
                    this.moveUp();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
            case DOWN:
                if(isPositionEmpty(character.getPosition().getX(), character.getPosition().getY()-2)){
                    this.moveDown();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
            case LEFT:
                if(isPositionEmpty(character.getPosition().getX()-2, character.getPosition().getY())){
                    this.moveLeft();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
            case RIGHT:
                if(isPositionEmpty(character.getPosition().getX()+2, character.getPosition().getY())){
                    this.moveRight();
                }
                else{
                    lastDirection = walkAwayDirection;
                    walkAwayDirection = null;
                }
                break;
        }
    }

    //Returns true if there is a collision.
    public boolean checkIfCollision(float x, float y) {
        if (collisionController.isCollison(x, y) || collisionController.isNewWorld(x,y)) {
            return true;
        }
        if (interactionController.isInteractionWithAnotherCharacter(this.character, x, y)){
            return true;
        }
        if (interactionController.isInteractionWithPlayer(x, y)){
            System.out.println("CRASH");
            return true;
        }
        /*if (interactionController.isInteractionWithMascot(x, y)){ //TODO Collieds with itself... fuck
            System.out.println("Collision with Mascot!");
            return true;
        }*/
        return false;
    }

    public void moveUp() {
        //TODO: fix a setposistion class in chracter instead or a moveUp, moveDown as the player has
        this.character.getPosition().setPosition(this.character.getPosition().getX(),
                this.character.getPosition().getY()+2);
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

    public void walkAway(Character character, CharacterView characterView){
        if(walkAwayState<walkAwayLength){
            interactsWith(character, characterView);
            walkAwayOneStep();
        }
    }

    public boolean isPositionEmpty(float x, float y){
        if(x<0 || x>1000 || y<0 || y>1000){ //TODO fix 1000.
            return false;
        }
        if(checkIfCollision(x, y)){
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
            //stopWalkingAnimation();
        }

        updateSprite();

        walkAwayState++;
    }

}