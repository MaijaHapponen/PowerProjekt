package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapObject;
import com.crap.game.model.Player;
import com.crap.game.model.Position;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;

/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class PlayerController {
    private GameView gameView;
    private PlayerView playerView;
    private Player player;
    private Position nextPlayerPos;
    private CollisionController collisionController;
    private InteractionController interactionController;
    public MapObject newWorldObject;

    public PlayerController(PlayerView playerView, GameView gameView){
        this.playerView = playerView;
        this.player = playerView.getPlayer();
        this.gameView = gameView;
        this.collisionController = new CollisionController(gameView.getWorld());
        this.nextPlayerPos = new Position();
        this.interactionController = new InteractionController(gameView);
        this.newWorldObject = collisionController.getNewWorldObject();
    }

    public void updateCollisionController(){
        this.collisionController = new CollisionController(gameView.getWorld());
        collisionController.setPlayerWidthAndHeight(playerView.getPlayerSpriteWidth(),playerView.getPlayerSpriteHeight());
    }

    public void movePlayer(int keycode) {

        String direction = null;
        updateSpeed();

        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(up()))) {
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_BACK);
            player.moveUp(gameView.getWorldHeight());
        }
        else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(down()))){
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_FRONT);
            player.moveDown();
        }
        else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision(left()))){
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_LEFT);
            player.moveLeft();
        }
        else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(right())) )  {
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_RIGHT);
            player.moveRight(gameView.getWorldWidth());
        }

        updateSprite();
        playerView.moveCamera(getPlayerPositionX(), getPlayerPositionY(),
                gameView.getWorldHeight(), gameView.getWorldWidth());
    }

    public void updateSprite() {
        playerView.getSprite().setPosition(getPlayerPositionX(), getPlayerPositionY());
    }

    public float getPlayerPositionX(){
        return player.getPosition().getX();
    }

    public float getPlayerPositionY(){
        return player.getPosition().getY();
    }

    public boolean checkIfCollision(Position p){
        return (collisionController.isCollison(p.getX(),p.getY()) || collisionController.isNewWorld(p.getX(),p.getY())||
                interactionController.isInteractionWithHuman(p.getX(),p.getY())
                || interactionController.isInteractionWithMascot(p.getX(),p.getY()));
    }

    public Position up(){
        nextPlayerPos.setPosition(getPlayerPositionX(), (getPlayerPositionY() + player.getCurrentSpeed()));
        return nextPlayerPos;
    }

    public Position down(){
        nextPlayerPos.setPosition(getPlayerPositionX(), getPlayerPositionY() - player.getCurrentSpeed());
        return nextPlayerPos;
    }

    public Position left(){
        nextPlayerPos.setPosition(getPlayerPositionX() - player.getCurrentSpeed(), getPlayerPositionY());
        return nextPlayerPos;
    }

    public Position right(){
        nextPlayerPos.setPosition(getPlayerPositionX() + player.getCurrentSpeed(), getPlayerPositionY());
        return nextPlayerPos;
    }

    public boolean isInteractionWithMascot(){
        return checkIfInteractionWithMascot(up()) || checkIfInteractionWithMascot(down()) ||
                checkIfInteractionWithMascot(left()) || checkIfInteractionWithMascot(right());
    }

    public boolean checkIfInteractionWithMascot(Position pos){
        return interactionController.isInteractionWithMascot(pos.getX(),pos.getY());
    }

    public boolean isNewWorld(){

        return checkIfNewWorld(up()) || checkIfNewWorld(down()) || checkIfNewWorld(left()) || checkIfNewWorld(right());
    }

    public boolean checkIfNewWorld(Position pos){
        return collisionController.isNewWorld(pos.getX(),pos.getY());
    }


    public void updateSpeed(){
        if(collisionController.isSlowerTerrain(getPlayerPositionX(), getPlayerPositionY()) ){
            player.setCurrentSpeed(player.getSlowerSpeed());
        }
        else{
            player.setCurrentSpeed(player.getNormalSpeed());
        }
    }

    public void stopWalkingAnimation(int keyCode){
        switch (keyCode){
            case Input.Keys.UP:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_BACK);
                break;
            case Input.Keys.DOWN:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_FRONT);
                break;
            case Input.Keys.LEFT:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_LEFT);
                break;
            case Input.Keys.RIGHT:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_RIGHT);
                break;
        }
    }

    public String getNewWorldName(){return collisionController.getNewWorldName();}
}
