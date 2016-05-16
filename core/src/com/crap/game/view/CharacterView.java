package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.controller.PlayerController;
import com.crap.game.model.Character;

/**
 * Created by andrea on 2016-04-28.
 */

public class CharacterView extends ApplicationAdapter implements Screen {

    private com.crap.game.model.Character character;
    private Sprite sprite;
    private Texture texture;
    private GameAnimation gameAnimation = new GameAnimation();
    private Animation animation;
    private PlayerView.AnimationState animationState = PlayerView.AnimationState.STANDING_FRONT;

    public CharacterView(Character character){
        this.character = character;
        this.texture = new Texture("characters/"+character.getName()+".png");
        this.sprite = new Sprite(texture);
        sprite.setPosition(character.getPosition().getX(), character.getPosition().getY());

        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), 4, 4);
    }
    public CharacterView(Character character,Texture texture){
        this.character = character;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        sprite.setPosition(character.getPosition().getX(), character.getPosition().getY());

        this.animation = this.gameAnimation.getAnimation(this.animationState, this.texture, this.texture.getWidth(),
                this.texture.getHeight(), 4, 4);
    }

    @Override
    public void render(float delta) {


    }

    @Override
    public void hide() {}

    @Override
    public void show() {}


    public void update(){
    }

    public Sprite getSprite(){
        return this.sprite;
    }

    public Animation getAnimation(){
        return this.animation;
    }

    public int getCharacterSpriteWidth(){
        return this.texture.getWidth()/4; //TODO snyggare lösning än hårdkodat /4
    }

    public int getCharacterSpriteHeight(){
        return this.texture.getHeight()/4; //TODO snyggare lösning än hårdkodat /4
    }
}
