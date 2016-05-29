package com.crap.game.view.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.information.enums.AnimationState;
import com.crap.game.model.character.Player;
import com.crap.game.model.primary.Position;

import static com.crap.game.model.information.Constants.*;

public class PlayerView extends CharacterView implements Screen{

    private Player player;
    private OrthographicCamera camera;

    private float halfOfScreen = Gdx.graphics.getWidth()/2;

    public void initPlayerView(){
        setTexture(new Texture(Gdx.files.internal("characters/"+player.getName()+".png")));
        setSprite(new Sprite(getTexture()));
        setAnimation(getGameAnimation().getAnimation(getAnimationState(), getTexture(), getTexture().getWidth(),
                getTexture().getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY));
    }

    public void moveCamera(float x,float y, float worldWidth, float worldHeight) {
        float boarderLeft = halfOfScreen;
        float boarderRight = worldWidth - halfOfScreen;
        float boarderTop = worldHeight - halfOfScreen;
        float boarderBottom = halfOfScreen;

        if(player.canMoveCameraUp(y, boarderTop) && player.canMoveCameraDown(y, boarderBottom)) {
            if (player.canMoveCameraLeft(x, boarderLeft) && player.canMoveCameraRight(x, boarderRight)) {
                camera.position.set(x, y, 0);
            }
            else if (player.canMoveCameraRight(x, boarderRight)) {
                camera.position.set(boarderLeft, y, 0);
            }
            else {
                camera.position.set(boarderRight, y, 0);
            }
        }
        else if(player.canMoveCameraUp(y, boarderTop)){
            if (player.canMoveCameraLeft(x, boarderLeft) && player.canMoveCameraRight(x, boarderRight)) {
                camera.position.set(x, boarderBottom, 0);
            }
            else if (player.canMoveCameraRight(x, boarderRight)) {
                camera.position.set(boarderLeft, boarderBottom, 0);
            }
            else {
                camera.position.set(boarderRight, boarderBottom, 0);
            }
        }
        else{
            if (player.canMoveCameraLeft(x, boarderLeft) && player.canMoveCameraRight(x, boarderRight)) {
                camera.position.set(x, boarderTop, 0);
            }
            else if (player.canMoveCameraRight(x, boarderRight)) {
                camera.position.set(boarderLeft, boarderTop, 0);
            }
            else {
                camera.position.set(boarderRight, boarderTop, 0);
            }
        }
        camera.update();
    }

    public void setPlayer(Player player){
        this.player=player;
        initPlayerView();
        player.setWidthAndHeight(getPlayerSpriteWidth(), getPlayerSpriteHeight());
    }

    public Player getPlayer(){
        return player;
    }

    public int getPlayerSpriteWidth(){
        return getTexture().getWidth()/NBR_OF_TEXTURE_IMAGES_HORIZONTALLY;
    }
    public int getPlayerSpriteHeight(){
        return getTexture().getHeight()/NBR_OF_TEXTURE_IMAGES_VERTICALLY;
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public Position getPlayerPosition(){
        return player.getPosition();
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }

    public void setAnimationState(AnimationState animationState){
        super.setAnimationState(animationState);
        setAnimation(getGameAnimation().getAnimation(getAnimationState(), getTexture(), 129, 190,
                NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY));
    }
}
