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
    CollisionController collisionController = new CollisionController();

    public PlayerController(PlayerView playerView){
        this.playerView = playerView;
        this.player = playerView.getPlayer();
    }

    public void movePlayer(int keycode) {
        int width = playerView.getPlayerSpriteWidth();
        int height = playerView.getPlayerSpriteHeight();
        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(getPlayerPositionX(),
                        (getPlayerPositionY()+height  + player.getCurrentSpeed()))) &&
                !(checkIfCollision(getPlayerPositionX() + width,
                        (getPlayerPositionY() +height+ player.getCurrentSpeed())))) {
            player.moveUp();
        } else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(getPlayerPositionX(), getPlayerPositionY()- player.getCurrentSpeed())) &&
                !(checkIfCollision(getPlayerPositionX()+width, getPlayerPositionY() - player.getCurrentSpeed()))) {
            player.moveDown();
        } else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision((getPlayerPositionX()) - player.getCurrentSpeed(), getPlayerPositionY()))&&
                !(checkIfCollision((getPlayerPositionX()) - player.getCurrentSpeed(), getPlayerPositionY()+height))) {
            player.moveLeft();
        } else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(getPlayerPositionX() + width
                        + player.getCurrentSpeed(), getPlayerPositionY())) &&
                !(checkIfCollision(getPlayerPositionX() + width
                        + player.getCurrentSpeed(), getPlayerPositionY()+height)) )  {
            player.moveRight();
        }
        updateSpeed();
        playerView.moveCamera((int) getPlayerPositionX(), (int) getPlayerPositionY());
    }

    public void update() {
        playerView.getSprite().setPosition(getPlayerPositionX(), getPlayerPositionY());
    }
    public float getPlayerPositionX(){
        return player.getPosition().getX();
    }
    public float getPlayerPositionY(){
        return player.getPosition().getY();
    }
    public boolean checkIfCollision(float x, float y){
        collisionController.updateCollisionValues(x,y);
        return collisionController.isCollison();
    }


    public void updateSpeed(){
        if(collisionController.isSlowerTerrain()){
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
