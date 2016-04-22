package com.crap.game.view;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.crap.game.model.Player;
import com.crap.game.model.WorldRenderer;
import com.crap.game.controller.Controller;
import com.crap.game.model.Player;

/**
 * Created by Maija on 2016-04-21.
 * Edited by Andrea on 2016-04-22.
 */
public class WorldView extends ApplicationAdapter implements Screen, InputProcessor{

    public static OrthographicCamera camera;
    public static Player player;
    private Texture texture;
    private Sprite sprite;
    private TiledMap map;
    private WorldRenderer renderer;

    @Override
    public void show() {
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, width, height);
        camera.update();

        texture = new Texture("characters/donald.png");
        sprite = new Sprite(texture);

        map = new TmxMapLoader().load("maps/hubbeneditsand.tmx");
        renderer = new WorldRenderer(map);
        renderer.addSprite(sprite);
        sprite.setPosition(250,250);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        camera.update();
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

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if(keycode == Input.Keys.LEFT)
            sprite.setPosition(sprite.getX()-5,sprite.getY());
            camera.translate(-5,0);
        if(keycode == Input.Keys.RIGHT)
            sprite.setPosition(sprite.getX()+5,sprite.getY());
            camera.translate(5,0);
        if(keycode == Input.Keys.UP)
            sprite.setPosition(sprite.getX(),sprite.getY()+5);
            camera.translate(0,5);
        if(keycode == Input.Keys.DOWN)
            sprite.setPosition(sprite.getX(),sprite.getY()-5);
            camera.translate(0,-5);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
