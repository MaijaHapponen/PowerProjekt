package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.crap.game.Main;
import com.crap.game.controller.Controller;
import com.crap.game.model.Player;

/**
 * Created by andrea on 2016-04-25.
 */
public class PlayerView extends ApplicationAdapter implements Screen{

    public static OrthographicCamera camera;
    public static Player player;
    public Main game;
    public static SpriteBatch batch;
    private Controller controller;

    public PlayerView(Main main){
        this.game = main;

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        batch = new SpriteBatch();
        player = new Player();

        player.setX(250);
        player.setY(250);
        player.setRotation(45);

        controller = new Controller();

        Gdx.input.setInputProcessor(controller);    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(player.getSprite(),player.getX(),player.getY());
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
    }
}
