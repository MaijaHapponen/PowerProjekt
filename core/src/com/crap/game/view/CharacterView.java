package com.crap.game.view;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.AnimationState;
import com.crap.game.model.Character;

import static com.crap.game.model.Constants.*;

/**
 * Created by andrea on 2016-04-28.
 */

public class CharacterView extends ScreenAdapter {

    private Character character;
    private Sprite sprite;
    private Texture texture;
    private GameAnimation gameAnimation = new GameAnimation();
    private Animation animation;
    private AnimationState animationState = AnimationState.STANDING_FRONT;

    public CharacterView(){

    }

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

    public void setAnimationState(AnimationState animationState){
        this.animationState = animationState;
    }

    public int getCharacterSpriteWidth(){
        return this.texture.getWidth()/NBR_OF_TEXTURE_IMAGES_HORIZONTALLY;
    }

    public int getCharacterSpriteHeight(){
        return this.texture.getHeight()/NBR_OF_TEXTURE_IMAGES_VERTICALLY;
    }


}
