package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.crap.game.model.Player;

/**
 * Created by Maija on 2016-04-21.
 * Edited by Andrea on 2016-04-22.
 * Edited by Andrea on 2016-04-25
 */
public class WorldView extends ApplicationAdapter implements Screen{

    private SpriteBatch batch;
    public static TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private String level;
    private Sprite sprite;
    private Player player;
    private TiledMap world;
    private OrthographicCamera camera;

    public WorldView(){
        this.batch = new SpriteBatch();
        this.level = "horsalmaskin";
        this.camera = new OrthographicCamera();
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera.setToOrtho(false, width, height);

        map = new TmxMapLoader().load("maps/"+level+".tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        this.sprite = player.getSprite();

        camera.update();
        renderer.setView(camera);
        renderer.render();
        batch.begin();
        sprite.draw(batch);
        batch.end();
        //camera.lookAt(player.getPosition().getX(),player.getPosition().getY(),0);
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

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setWorld(TiledMap world) { this.world = world; }
}
