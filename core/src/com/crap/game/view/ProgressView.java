package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.crap.game.model.Mascot;
import com.crap.game.model.Position;
import com.crap.game.model.Progress;

import java.util.ArrayList;

import com.crap.game.model.Position;
import com.crap.game.model.Progress;

/**
 * Created by rebeccafinne on 2016-05-05.
 */
public class ProgressView extends ApplicationAdapter implements Screen {

    private Character character;
    private Texture textureBack;
    private Texture textureMascots;
    private Position position;
    private Sprite spriteBack;
    private Sprite spriteMascots;
    private Progress progress;



    public ProgressView(Character character){
        this.character = character;
        this.textureBack = new Texture("Progress/html5-progress-bar.jpg");
        this.spriteBack = new Sprite(textureBack);
        this.progress = new Progress();
        this.spriteBack.setPosition(0, 0);


    }

    public Texture getTextureBack(){
        return this.textureBack;
    }

    public Sprite getSpriteBack(){
        return this.spriteBack;
    }

    public Sprite getSpriteMascots(){
        return this.spriteMascots;
    }



    }

    public Position getPosition(){
        return progress.getPosition();
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }




    @Override
    public void hide() {

    }

    public void update(){
        if(progress.isNewMascotCaught()){
            this.textureMascots = new Texture(progress.getNewMascotToBar().getName());
            this.spriteMascots = new Sprite(textureMascots);
            progress.getCaractersOnBar().add(progress.getNewMascotToBar());
        }
    }



}



