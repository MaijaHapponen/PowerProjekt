package com.crap.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.crap.game.model.Position;
import com.crap.game.controller.Controller;
import com.crap.game.Main;

/**
 * Created by Maija on 2016-04-21.
 * Edited by Andrea on 2016-04-22.
 * Edited by Andrea on 2016-04-25
 */
public class WorldView extends ApplicationAdapter implements Screen{

    public static OrthographicCamera camera;
    private SpriteBatch batch;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private Position position;
    private Controller controller;
    private Main game;

    public WorldView(Main main){
        this.game = main;

        batch = PlayerView.batch;

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);

        map = new TmxMapLoader().load("maps/hubbeneditsand.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void show() {

        //camera.update();

       // player = new Player();
        //controller = new Controller();
        //player = new PlayerView();

        //renderer.addSprite(player.getSprite());
        //player.setPosition(250, 250);
        //sprite.setPosition(position.getX(), position.getY());
        //Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        //camera.lookAt(position.getX(),position.getY(),0);
        camera.update();

        game.batch.setProjectionMatrix(camera.combined);
        renderer.setView(camera);
        renderer.render();
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
        map.dispose();
        renderer.dispose();
    }
}
