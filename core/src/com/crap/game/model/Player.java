package com.crap.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by andrea on 2016-04-11.
 * Edited by andrea on 2016-04-25.
 */
public class Player extends Sprite{
    private Texture texture;
    private Sprite sprite;
    private Position position;
    private int change = 5;
    //private CollisionModel collision = new CollisionModel();

    //Constructor
    public Player(){
        this.position = new Position(250, 250);
        this.texture = new Texture(Gdx.files.internal("characters/donald.png"));
        this.sprite = new Sprite(texture);
        sprite.setPosition(position.getX(), position.getY());
    }

    //Constructor
    public Player(int x, int y){
        this.position = new Position(x, y);
        this.texture = new Texture(Gdx.files.internal("characters/donald.png"));
        this.sprite = new Sprite(texture);
        sprite.setPosition(position.getX(), position.getY());
    }

    //Moves the player up, down, right or left.
    public void movePlayer(int keycode){
        if (keycode == Input.Keys.UP){// && !collision.isCollision(position.getX(), position.getY())) {
            this.moveUp();
        }
        else if (keycode == Input.Keys.DOWN){ // && !collision.isCollision(position.getX(), position.getY())) {
            this.moveDown();
        }
        else if (keycode == Input.Keys.LEFT){// && !collision.isCollision(position.getX(), position.getY())) {
            this.moveLeft();
        }
        else if (keycode == Input.Keys.RIGHT){ //&& !collision.isCollision(position.getX(), position.getY())) {
            this.moveRight();
        }
    }

    //Moves the player one step up.
    public void moveUp(){
        if(this.position.getY() < 1000-change) { //TODO should be changed to the max height of the world later.
            this.position.setPosition(position.getX(), position.getY() + change);
            update();
        }
    }

    //Moves the player one step down.
    public void moveDown(){
        if(this.position.getY() > change){
            this.position.setPosition(position.getX(), position.getY() - change);
            update();
        }
    }

    //Moves the player one step to the right.
    public void moveRight(){
        if(this.position.getX() < 1000-change) { //TODO should be changed to the max width of the world later.
            this.position.setPosition(position.getX() + change, position.getY());
            update();
        }
    }

    //Moves the player one step to the left.
    public void moveLeft(){
        if(this.position.getX() > change){
            this.position.setPosition(position.getX() - change, position.getY());
            update();
        }
    }

    //Updates the position of the players Sprite
    public void update(){
        sprite.setPosition(position.getX(), position.getY());
    }

    //Returns the players Position object.
    public Position getPosition(){return this.position;  }

    //Returns the players Texture object
    public Texture getTexture() { return this.texture; }

    //Returns the players Sprite object
    public Sprite getSprite() { return this.sprite; }

}
