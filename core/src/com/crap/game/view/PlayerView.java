package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.Player;
import com.crap.game.model.Position;

/**
 * Created by Maija on 2016-05-02.
 */
public class PlayerView extends ApplicationAdapter implements Screen{
    private Player player;
    private Sprite playerSprite;
    private Texture texture;
    private OrthographicCamera camera;

    public PlayerView(){
        this.texture = new Texture(Gdx.files.internal("characters/imp.png"));
        this.playerSprite = new Sprite(texture);
        playerSprite.setPosition(250, 250);

    }
    public PlayerView(int x, int y){
        this.texture = new Texture(Gdx.files.internal("characters/imp.png"));
        this.playerSprite = new Sprite(texture);
        playerSprite.setPosition(player.getPosition().getX(), player.getPosition().getY());
        //TODO: fix the setPosition so it's not so complicated
    }

    public void setPlayer(Player player){
        this.player=player;
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

    public Sprite getSprite(){
        return playerSprite;
    }

    public Player getPlayer(){
        return player;
    }

    public Texture getTexture() { return this.texture; }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public void moveCamera(int x,float y) {
        //TODO: fix so red is not visible
        if ((getPlayerPosition().getX() > 500 / 2) || (getPlayerPosition().getY() > 500 / 2)) {
            camera.position.set(x, y, 0);
            camera.update();
        }
    }

    public Position getPlayerPosition(){
        return player.getPosition();
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }
}
