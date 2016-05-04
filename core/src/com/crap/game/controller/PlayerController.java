package com.crap.game.controller;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.Main;
import com.crap.game.model.CollisionModel;
import com.crap.game.model.Player;
import com.crap.game.model.Position;
import com.crap.game.view.PlayerView;
import com.crap.game.view.WorldView;


/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class PlayerController {
    PlayerView playerView;
    Player player;
    CollisionModel collision = new CollisionModel();
    private enum Directions  {UP, DOWN, LEFT, RIGHT};
    private Directions direction;


    public PlayerController(PlayerView playerView){
        this.playerView = playerView;
        this.player = playerView.getPlayer();
    }

    public void movePlayer(int keycode) {

        if (keycode == Input.Keys.UP) {// && !(collision.getTypeOfTile(position.getX(), position.getY() - player.getNormalSpeed) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveUp();
            this.direction = Directions.UP;
        } else if (keycode == Input.Keys.DOWN){ //&& !(collision.getTypeOfTile(position.getX(), position.getY() + player.getNormalSpeed) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveDown();
            this.direction = Directions.DOWN;
        } else if (keycode == Input.Keys.LEFT){ //) && !(collision.getTypeOfTile(position.getX() - normalSpeed, position.getY()) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveLeft();
            this.direction = Directions.LEFT;
        } else if (keycode == Input.Keys.RIGHT) { // && !(collision.getTypeOfTile(position.getX() + normalSpeed, position.getY()) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveRight();
            this.direction = Directions.RIGHT;
        }
        playerView.moveCamera(player.getPosition().getX(),player.getPosition().getY());
    }

    public void update() {
        playerView.getSprite().setPosition(player.getPosition().getX(), player.getPosition().getY());
    }

    public Directions getDirection(){
        return this.direction;
    }


}
