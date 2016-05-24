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
    private float halfOfScreen = 250;
    private float boarderLeft = halfOfScreen;
    private float boarderBottom = halfOfScreen;
    private GameAnimation gameAnimation = new GameAnimation();
    private Animation animation;
    private AnimationState animationState = AnimationState.STANDING_FRONT;

    public final int NBR_OF_TEXTURE_IMAGES_HORIZONTALLY = 4;
    public final int NBR_OF_TEXTURE_IMAGES_VERTICALLY = 4;

    public void initPlayerView(){
        this.texture = new Texture(Gdx.files.internal("characters/"+player.getName()+".png"));
        this.playerSprite = new Sprite(texture);
        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }

    public void setPlayer(Player player){
        this.player=player;
        initPlayerView();
        player.setWidthAndHeight(getPlayerSpriteWidth(), getPlayerSpriteHeight());

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

    public void moveCamera(float x,float y, float worldWidth, float worldHeight) {

        float boarderLeft = halfOfScreen;
        float boarderRight = worldWidth - halfOfScreen;
        float boarderTop = worldHeight - halfOfScreen;
        float boarderBottom = halfOfScreen;

        if(canMoveCameraUp(y, boarderTop) && canMoveCameraDown(y, boarderBottom)) {
            if (canMoveCameraLeft(x, boarderLeft) && canMoveCameraRight(x, boarderRight)) {
                camera.position.set(x, y, 0);
            }
            else if (canMoveCameraRight(x, boarderRight)) {
                camera.position.set(boarderLeft, y, 0);
            }
            else {
                camera.position.set(boarderRight, y, 0);
            }
        }

        else if(canMoveCameraUp(y, boarderTop)){
            if (canMoveCameraLeft(x, boarderLeft) && canMoveCameraRight(x, boarderRight)) {
                camera.position.set(x, boarderBottom, 0);
            }
            else if (canMoveCameraRight(x, boarderRight)) {
                camera.position.set(boarderLeft, boarderBottom, 0);
            }
            else {
                camera.position.set(boarderRight, boarderBottom, 0);
            }
        }

        else{
            if (canMoveCameraLeft(x, boarderLeft) && canMoveCameraRight(x, boarderRight)) {
                camera.position.set(x, boarderTop, 0);
            }
            else if (canMoveCameraRight(x, boarderRight)) {
                camera.position.set(boarderLeft, boarderTop, 0);
            }
            else {
                camera.position.set(boarderRight, boarderTop, 0);
            }
        }

        camera.update();
    }

    public boolean canMoveCameraUp(float y, float boarderTop) {
        return (y < boarderTop);
    }

    public boolean canMoveCameraDown(float y, float boarderBottom){
        return (y > boarderBottom);
    }

    public boolean canMoveCameraLeft(float x, float boarderLeft){
        return (x > boarderLeft);
    }

    public boolean canMoveCameraRight(float x, float boarderRight){
        return (x < boarderRight);
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
