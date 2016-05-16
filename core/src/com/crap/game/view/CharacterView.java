package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.Character;

/**
 * Created by andrea on 2016-04-28.
 */

public class CharacterView extends ApplicationAdapter implements Screen {

    private Character character;
    private Sprite sprite;
    private Texture texture;

    public CharacterView(Character character){
        this.character = character;
        this.texture = new Texture("characters/"+character.getName()+".png"); //TODO Ska sklart inte var jttar senare.
        this.sprite = new Sprite(texture);
        sprite.setPosition(character.getPosition().getX(), character.getPosition().getY());
        character.setWidthAndHeight(sprite.getWidth(),sprite.getHeight());
    }
    public CharacterView(Character character,Texture texture){
        this.character = character;
        this.texture = texture;
        this.sprite = new Sprite(texture);
        sprite.setPosition(character.getPosition().getX(), character.getPosition().getY());
    }

    public Character getCharacter(){
        return this.character;
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
}
