package com.crap.game.view.character;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.information.enums.AnimationState;
import com.crap.game.model.character.Character;
import com.crap.game.view.character.animation.GameAnimation;

import static com.crap.game.model.information.Constants.*;

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

    public void updateAnimation(){
        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), NBR_OF_TEXTURE_IMAGES_VERTICALLY, NBR_OF_TEXTURE_IMAGES_HORIZONTALLY);
    }

    @Override
    public void dispose() {
        texture.dispose();
    }

    public Character getCharacter(){
        return this.character;
    }

    public void setCharacter(Character character){
        this.character = character;
    }

    public Sprite getSprite(){
        return this.sprite;
    }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public Animation getAnimation(){
        return this.animation;
    }

    public void setAnimation(Animation animation){
        this.animation = animation;
    }

    public AnimationState getAnimationState(){
        return this.animationState;
    }

    public void setAnimationState(AnimationState animationState){
        this.animationState = animationState;
    }

    public Texture getTexture(){
        return this.texture;
    }

    public void setTexture(Texture texture){
        this.texture = texture;
    }

    public GameAnimation getGameAnimation(){
        return this.gameAnimation;
    }
}
