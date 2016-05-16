package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.crap.game.controller.CollisionController;
import com.crap.game.model.Player;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;

import com.crap.game.model.Player;
import javafx.scene.input.KeyCode;

/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class PlayerController {
    GameView gameView;
    PlayerView playerView;
    Player player;
    CollisionController collisionController;
    InteractionController interactionController;

    public PlayerController(PlayerView playerView, GameView gameView){
        this.playerView = playerView;
        this.player = playerView.getPlayer();
        this.gameView = gameView;

        this.interactionController = new InteractionController(gameView);
        this.collisionController = new CollisionController(gameView.getWorld());
        collisionController.setPlayerWidthAndHeight(playerView.getPlayerSpriteWidth(),playerView.getPlayerSpriteHeight());
    }

    public void movePlayer(int keycode) {

        System.out.println(collisionController.isNewWorld(getPlayerPositionX(),getPlayerPositionY()));
        updateSpeed();
        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(getPlayerPositionX(), (getPlayerPositionY() + player.getCurrentSpeed())))) {
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_BACK);
            player.moveUp();
        } else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(getPlayerPositionX(), getPlayerPositionY()- player.getCurrentSpeed()))){
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_FRONT);
            player.moveDown();
        } else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision((getPlayerPositionX()) - player.getCurrentSpeed(), getPlayerPositionY()))){
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_LEFT);
            player.moveLeft();
        } else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(getPlayerPositionX()+ player.getCurrentSpeed(), getPlayerPositionY())) )  {
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_RIGHT);
            player.moveRight();
        }
        updateSprite();
        playerView.moveCamera((int) getPlayerPositionX(), (int) getPlayerPositionY());
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
    public boolean checkIfCollision(float x, float y){
        return (collisionController.isCollison(x,y) || collisionController.isNewWorld(x,y)||
                interactionController.isInteractionWithHuman(x,y)
                || interactionController.isInteractionWithMascot(x,y));
    }


    public void updateSpeed(){
        if(collisionController.isSlowerTerrain(getPlayerPositionX(), getPlayerPositionY()) ){
            player.setCurrentSpeed(player.getSlowerSpeed());
        }else{
            player.setCurrentSpeed(player.getNormalSpeed());
        }
    }

    public Player getPlayer(){
        return this.player;
    }

    public PlayerView getPlayerView(){
        return this.playerView;
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
}
