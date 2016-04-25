package com.crap.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.crap.game.view.PlayerView;
import com.crap.game.view.WorldView;

public class Main extends Game {

    public SpriteBatch batch;
    public TiledMap map;

    public void create() {
        batch = new SpriteBatch();
        map = new TiledMap();
        this.setScreen(new WorldView(this));
    }

	@Override
	public void render () {super.render();}

    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
