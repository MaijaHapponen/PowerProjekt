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

        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(getPlayerPositionX(),
                        (getPlayerPositionY() + playerView.getPlayerSpriteHeight()) + player.getCurrentSpeed()))) {
            player.moveUp();
        } else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(getPlayerPositionX(), getPlayerPositionY() + player.getCurrentSpeed()))) {
            player.moveDown();
        } else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision((getPlayerPositionX()) - player.getCurrentSpeed(), getPlayerPositionY()))) {
            player.moveLeft();
        } else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(getPlayerPositionX() + playerView.getPlayerSpriteWidth()
                        + player.getCurrentSpeed(), getPlayerPositionY())))  {
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
