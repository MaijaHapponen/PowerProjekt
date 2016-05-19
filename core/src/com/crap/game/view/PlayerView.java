package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.Player;
import com.crap.game.model.Position;

/**
 * Created by Maija on 2016-05-02.
 */
public class PlayerView extends ApplicationAdapter implements Screen{

    public enum AnimationState{WALKING_FRONT, WALKING_BACK, WALKING_RIGHT, WALKING_LEFT, STANDING_FRONT,
        STANDING_BACK, STANDING_RIGHT, STANDING_LEFT}

    private Player player;
    private Sprite playerSprite;
    private Texture texture;
    private OrthographicCamera camera;
    private int halfOfScreen = 250;
    private GameAnimation gameAnimation = new GameAnimation();
    private Animation animation;
    private AnimationState animationState = AnimationState.STANDING_FRONT;

    public final int NBR_OF_TEXTURE_IMAGES_HORIZONTALLY = 4;
    public final int NBR_OF_TEXTURE_IMAGES_VERTICALLY = 4;

    public PlayerView(){
        this.texture = new Texture(Gdx.files.internal("characters/kalleAnka.png"));
        this.playerSprite = new Sprite(texture);
        playerSprite.setPosition(0, 0);
        //TODO not hardcode

        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }
    public PlayerView(int x, int y){
        this.texture = new Texture(Gdx.files.internal("characters/imp.png"));
        this.playerSprite = new Sprite(texture);
        playerSprite.setPosition(x, y);
        //TODO: fix the setPosition so it's not so complicated
    }

    public void setPlayer(Player player){
        this.player=player;
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {}

    @Override
    public void hide() {}

    public Sprite getSprite(){
        return playerSprite;
    }

    public Player getPlayer(){
        return player;
    }

    public Texture getTexture() { return this.texture; }

    public int getPlayerSpriteWidth(){
        return this.texture.getWidth()/NBR_OF_TEXTURE_IMAGES_HORIZONTALLY;
    }
    public int getPlayerSpriteHeight(){
        return this.texture.getHeight()/NBR_OF_TEXTURE_IMAGES_VERTICALLY;
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public void moveCamera(float x,float y, float worldWidth, float worldHeight, String direction) {

        //TODO: Remove systemoutprints
        System.out.println(player.getPosition().getX() + " + " + player.getPosition().getY());

        System.out.println(playerSprite.getX() + " + " + playerSprite.getY());

        float boarderLeft = halfOfScreen;
        float boarderRight = worldWidth - halfOfScreen;
        float boarderTop = worldHeight - halfOfScreen;
        float boarderBottom = halfOfScreen;

        if(direction.equals("left")){
            moveCameraLeft(x, boarderLeft);
        }

        else if(direction.equals("right")){
            moveCameraRight(x, boarderRight);
        }

        else if(direction.equals("up")){
            moveCameraUp(y, boarderTop);
        }

        else if(direction.equals("down")){
            moveCameraDown(y, boarderBottom);
        }

        camera.update();
    }

    public void moveCameraUp(float y, float boarderTop) {
        if(y < boarderTop){
            camera.position.set(camera.position.x, y, 0);
        }
        else{
            camera.position.set(camera.position.x, boarderTop, 0);
        }
    }

    public void moveCameraDown(float y, float boarderBottom) {
        if (y > boarderBottom) {
            camera.position.set(camera.position.x, y, 0);
        } else{
            camera.position.set(camera.position.x, boarderBottom, 0);
        }
    }

    public void moveCameraLeft(float x, float boarderLeft){
        if(x > boarderLeft){
            camera.position.set(x, camera.position.y, 0);
        }
        else{
            camera.position.set(boarderLeft, camera.position.y, 0);
        }
    }
    public void moveCameraRight(float x, float boarderRight){
        if(x < boarderRight){
            camera.position.set(x, camera.position.y, 0);
        }
        else{
            camera.position.set(boarderRight, camera.position.y, 0);
        }
    }

    public Position getPlayerPosition(){
        return player.getPosition();
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }

    public Animation getAnimation(){
        return this.animation;
    }

    public void setAnimationState(AnimationState animationState){
        this.animationState = animationState;
        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, 129, 190,
                NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }
}
