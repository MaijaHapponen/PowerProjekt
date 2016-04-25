package com.crap.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.crap.game.Main;
import com.crap.game.controller.Controller;
import com.crap.game.model.Player;

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
    public static Player player;
    private String level;
    private Sprite sprite;
    private Texture texture;
    private Controller controller;

    public WorldView(Main main){
        this.batch = new SpriteBatch();
        this.camera = new OrthographicCamera();
        this.level = "hubbeneditsand";
        this.player = new Player();
        this.sprite = player.getSprite();
        //this.texture = new Texture(Gdx.files.internal("characters/donald.png"));
        //this.sprite = new Sprite(texture);

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera.setToOrtho(false, width, height);

        map = new TmxMapLoader().load("maps/"+level+".tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void show() {
        //camera.update();
        //player = new Player();
        //controller = new Controller();
        //player = new PlayerView();
        //renderer.addSprite(player.getSprite());
        //player.setPosition(250, 250);
        //sprite.setPosition(position.getX(), position.getY());
        //Gdx.input.setInputProcessor(controller);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        //camera.lookAt(player.getPosition().getX(),player.getPosition().getY(),0);
        camera.update();
        renderer.setView(camera);
        renderer.render();
        batch.begin();
        batch.enableBlending();
        sprite.draw(batch);
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
        map.dispose();
        renderer.dispose();
    }
}
