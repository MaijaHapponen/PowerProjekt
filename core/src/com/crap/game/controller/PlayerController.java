package com.crap.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.CollisionModel;
import com.crap.game.model.Player;
import com.crap.game.model.Position;

/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class PlayerController {

    Player player = new Player();
    CollisionModel collision = new CollisionModel();
    private Texture texture;
    private Sprite sprite;

    //Constructor
    public PlayerController(){
        this.texture = new Texture(Gdx.files.internal("characters/imp.png"));
        this.sprite = new Sprite(texture);
        sprite.setPosition(250, 250);

    }

    //Constructor
    public PlayerController(int x, int y){

        this.texture = new Texture(Gdx.files.internal("characters/imp.png"));
        this.sprite = new Sprite(texture);
        sprite.setPosition(player.getPosition().getX(), player.getPosition().getY());
    }


    public void movePlayer(int keycode) {

        if (keycode == Input.Keys.UP) {// && !(collision.getTypeOfTile(position.getX(), position.getY() - player.getNormalSpeed) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveUp();
        } else if (keycode == Input.Keys.DOWN){ //&& !(collision.getTypeOfTile(position.getX(), position.getY() + player.getNormalSpeed) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveDown();
        } else if (keycode == Input.Keys.LEFT){ //) && !(collision.getTypeOfTile(position.getX() - normalSpeed, position.getY()) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveLeft();
        } else if (keycode == Input.Keys.RIGHT) { // && !(collision.getTypeOfTile(position.getX() + normalSpeed, position.getY()) == CollisionModel.typeOfTile.SOLID_TILE)) {
            player.moveRight();
        }
    }

    public void update() {
        sprite.setPosition(player.getPosition().getX(), player.getPosition().getY());
    }

    //Returns the players Texture object
    public Texture getTexture() { return this.texture; }

    //Returns the players Sprite object
    public Sprite getSprite() { return this.sprite; }

}
