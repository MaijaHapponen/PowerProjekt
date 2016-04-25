package com.crap.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by andrea on 2016-04-11.
 */
public class Player extends Sprite {
    private Texture texture;
    private Sprite sprite;
    private float x;
    private float y;
    //private CollisionModel collision = new CollisionModel();

    //Constructor
    public Player(){
        this.x = 250;
        this.y = 250;
        this.texture = new Texture(Gdx.files.internal("character/donald.png"));
        this.sprite = new Sprite(texture);
        sprite.setPosition(this.x,this.y);
    }

    //Constructor
    public Player(int x, int y){
        //this.position = new Position(x, y);
        this.x = 250;
        this.y = 250;
        this.texture = new Texture(Gdx.files.internal("character/donald.png"));
        this.sprite = new Sprite(texture);
        sprite.setPosition(this.x,this.y);
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
        if(y>0){//this.position.getY() > 0) {
            //this.position.setPosition(position.getX(), position.getY() - 1);
            float ny = y;
            this.y = ny -1;
            update();
        }
    }

    //Moves the player one step down.
    public void moveDown(){
        if(y<1000){//this.position.getY() < 1000) { //TODO should be changed to the max height of the world later.
            //this.position.setPosition(position.getX(), position.getY() + 1);
            float ny = y;
            this.y = ny +1;
            update();
        }
    }

    //Moves the player one step to the right.
    public void moveRight(){
        if(x<1000){//this.position.getX() < 1000) { //TODO should be changed to the max width of the world later.
            //this.position.setPosition(position.getX() + 1, position.getY());
            float nx = x;
            this.x = nx -1;
            update();
        }
    }

    //Moves the player one step to the left.
    public void moveLeft(){
        if(x>0){//this.position.getX() > 0){
            //this.position.setPosition(position.getX() - 1, position.getY());
            float nx = x;
            this.x = nx +1;
            update();
        }
    }

    //Updates the position of the players Sprite
    public void update(){
        sprite.setPosition(x,y);//position.getX(), position.getY());
    }

    //Returns the players Position object.
    //public Position getPosition(){return this.position;  }

    public float getX(){ return this.x;}


    public float getY(){ return this.y;}

    //Returns the players Texture object
    public Texture getTexture() { return this.texture; }

    //Returns the players Sprite object
    public Sprite getSprite() { return this.sprite; }

}
