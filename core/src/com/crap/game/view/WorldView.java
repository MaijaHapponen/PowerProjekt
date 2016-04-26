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
import com.crap.game.model.Human;
import com.crap.game.model.Mascot;
import com.crap.game.model.Player;

import java.util.ArrayList;

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

    private ArrayList<Human> humansList = new ArrayList<Human>();
    private ArrayList<Sprite> humansSpriteList = new ArrayList<Sprite>();
    private ArrayList<Mascot> mascotsList = new ArrayList<Mascot>();
    private ArrayList<Sprite> mascotsSpriteList = new ArrayList<Sprite>();

    public WorldView(){
        this.batch = new SpriteBatch();
        this.level = "horsalmaskin";

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

        for(int i=0; i<humansList.size(); i++){
            Sprite tmpSprite = humansList.get(i).getSprite();
            this.humansSpriteList.add(tmpSprite);
        }
        for(int i=0; i<mascotsList.size(); i++){
            Sprite tmpSprite = mascotsList.get(i).getSprite();
            this.mascotsSpriteList.add(tmpSprite);
        }

        this.sprite = player.getSprite();
        moveCamera(player.getPosition().getX(), player.getPosition().getY());

        batch.setProjectionMatrix(camera.combined);
        renderer.setView(camera);
        renderer.render();
        batch.begin();
        for(int i = 0; i<humansSpriteList.size(); i++){
            humansSpriteList.get(i).draw(batch);
        }
        for(int i = 0; i<mascotsSpriteList.size(); i++){
            mascotsSpriteList.get(i).draw(batch);
        }
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

    public void setPlayer(Player player){
        this.player = player;
    }

    public void setHumans(ArrayList<Human> humans){
        for (int i=0; i<humans.size(); i++) {
            this.humansList.add(humans.get(i));
        }
    }

    public void setMascots(ArrayList<Mascot> mascots){
        for (int i=0; i<mascots.size(); i++) {
            this.mascotsList.add(mascots.get(i));
        }
    }

    public void setWorld(TiledMap world) { this.world = world; }

    public void setCamera(OrthographicCamera camera) { this.camera = camera;}

    public void moveCamera(int x,float y) {
        if ((player.getPosition().getX() > 500 / 2) || (player.getPosition().getY() > 500 / 2)) {
            camera.position.set(x, y, 0);
            camera.update();
        }
    }

}
