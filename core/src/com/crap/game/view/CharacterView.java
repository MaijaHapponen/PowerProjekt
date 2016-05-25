package com.crap.game.view;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.Character;

/**
 * Created by andrea on 2016-04-28.
 */

public class CharacterView extends ScreenAdapter {

    private Character character;
    private Sprite sprite;
    private Texture texture;
    private GameAnimation gameAnimation = new GameAnimation();
    private Animation animation;
    private PlayerView.AnimationState animationState = PlayerView.AnimationState.STANDING_FRONT;

    public final int NBR_OF_TEXTURE_IMAGES_HORIZONTALLY = 4;
    public final int NBR_OF_TEXTURE_IMAGES_VERTICALLY = 4;

    public CharacterView(Character character){
        this.character = character;
        this.texture = new Texture("characters/"+character.getName()+".png");
        this.sprite = new Sprite(texture);
        sprite.setPosition(character.getPosition().getX(), character.getPosition().getY());

        character.setWidthAndHeight(sprite.getWidth()/NBR_OF_TEXTURE_IMAGES_HORIZONTALLY,
                sprite.getHeight()/NBR_OF_TEXTURE_IMAGES_VERTICALLY);

        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }

    public CharacterView(Character character,Texture texture){
        this.character = character;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        sprite.setPosition(character.getPosition().getX(), character.getPosition().getY());

        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }

    public Character getCharacter(){
        return this.character;
    }

    @Override
    public void dispose() {
        texture.dispose();

    }

    public Sprite getSprite(){
        return this.sprite;
    }

    public Animation getAnimation(){
        return this.animation;
    }

    public void updateAnimation(){
        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }

    public PlayerView.AnimationState getAnimationState(){
        return this.animationState;
    }


    public void setAnimationState(PlayerView.AnimationState animationState){
        this.animationState = animationState;
    }

    public Texture getTexture(){
        return this.texture;
    }

    public int getCharacterSpriteWidth(){
        return this.texture.getWidth()/NBR_OF_TEXTURE_IMAGES_HORIZONTALLY;
    }

    public int getCharacterSpriteHeight(){
        return this.texture.getHeight()/NBR_OF_TEXTURE_IMAGES_VERTICALLY;
    }


}
