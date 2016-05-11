package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.crap.game.controller.CollisionController;
import com.crap.game.model.Player;
import com.crap.game.view.PlayerView;

import com.crap.game.model.Player;
/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class PlayerController {
    PlayerView playerView;
    Player player;
    CollisionController collisionController;

    public PlayerController(PlayerView playerView, GameView gameView){
        this.playerView = playerView;
        this.player = playerView.getPlayer();
        this.gameView = gameView;

        this.collisionController = new CollisionController();
        collisionController.setPlayerWidthAndHeight(playerView.getPlayerSpriteWidth(),playerView.getPlayerSpriteHeight());
    }

    public void movePlayer(int keycode) {

        updateSpeed();
        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(getPlayerPositionX(), (getPlayerPositionY() + player.getCurrentSpeed())))) {
            player.moveUp();
        } else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(getPlayerPositionX(), getPlayerPositionY()- player.getCurrentSpeed()))){
            player.moveDown();
        } else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision((getPlayerPositionX()) - player.getCurrentSpeed(), getPlayerPositionY()))){
            player.moveLeft();
        } else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(getPlayerPositionX()+ player.getCurrentSpeed(), getPlayerPositionY())) )  {
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
        return collisionController.isCollison(x,y);
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
}
