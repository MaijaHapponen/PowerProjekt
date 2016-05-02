package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crap.game.controller.PlayerController;
import com.crap.game.model.Player;
import com.crap.game.model.Position;

/**
 * Created by andrea on 2016-04-28.
 */

public class CharacterView extends ApplicationAdapter{ /*implements Screen {

    public Player player;
    public Sprite sprite;
    private Position position;
    private Texture texture;
    public OrthographicCamera camera;
    private PlayerController playerController;

    @Override
    public void render(float delta) {
        this.sprite = playerController.getSprite();
        this.moveCamera(player.getPosition().getX(), player.getPosition().getY());

        super.render();
    }

    @Override
    public void hide() {}

    @Override
    public void show() {}

    public void setPlayer(Player player) { this.player = player; }

    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }

    public void setTexture(Texture texture){
        this.texture = texture;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public void update(){
        sprite.setPosition(position.getX(), position.getY());
    }

    public void setCamera(OrthographicCamera camera) { this.camera = camera;}

    public void moveCamera(int x,float y) {
        if ((player.getPosition().getX() > 500 / 2) || (player.getPosition().getY() > 500 / 2)) {
            camera.position.set(x, y, 0);
            camera.update();
        }
    }*/
}
