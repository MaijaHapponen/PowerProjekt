package com.crap.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by andrea on 2016-04-11.
 * Edited by andrea on 2016-04-25.
 */

public class Player extends Sprite {


    private Texture texture;
    private Sprite sprite;
    private Position position;
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

    public void movePlayer(String direction){


        if (direction.equals("38") && !collision.getBlockedTiles(getPosition().getX(), getPosition().getY()-1)) {
            this.moveUp();

        } else if (direction.equals("40") && !collision.getBlockedTiles(getPosition().getX(), getPosition().getY()+1)) {
            this.moveDown();

        } else if (direction.equals("37") && !collision.getBlockedTiles(getPosition().getX()-1, getPosition().getY())) {
            this.moveLeft();

        } else if (direction.equals("39") && !collision.getBlockedTiles(getPosition().getX()+1, getPosition().getY())) {
            this.moveRight();
        }
    }

    //Moves the player one step up.
    public void moveUp(){
        if(this.position.getY() > 0) {
            this.position.setPosition(position.getX(), position.getY() - 1);
            update();
        }
    }

    //Moves the player one step down.
    public void moveDown(){
        if(this.position.getY() < 1000) { //TODO should be changed to the max height of the world later.
            this.position.setPosition(position.getX(), position.getY() + 1);
            update();
        }
    }

    //Moves the player one step to the right.
    public void moveRight(){
        if(this.position.getX() < 1000) { //TODO should be changed to the max width of the world later.
            this.position.setPosition(position.getX() + 1, position.getY());
            update();
        }
    }

    //Moves the player one step to the left.
    public void moveLeft(){
        if(this.position.getX() > 0){
            this.position.setPosition(position.getX() - 1, position.getY());
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
