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
    private int pixelPerTile = 30;
    private int halfOfScreen = 250;



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

    public float getPlayerSpriteWidth(){
        return this.texture.getWidth();
    }
    public float getPlayerSpriteHeight(){
        return this.texture.getHeight();
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public void moveCamera(float x,float y) {

        int worldLeft = 0;
        int worldBottom = 0;
        int worldRight = GameView.world.getProperties().get("width", Integer.class)*pixelPerTile;
        int worldTop = GameView.world.getProperties().get("height", Integer.class)*pixelPerTile;

        float px = getPlayerPosition().getX();
        float py = getPlayerPosition().getY();
        float boarderLeft = worldLeft+halfOfScreen;
        float boarderRight = worldRight-halfOfScreen;
        float boarderTop = worldTop-halfOfScreen;
        float boarderBottom = worldBottom+halfOfScreen;

        if ((px > boarderLeft) && (px < boarderRight)) {
            if((py > boarderBottom) && (py < boarderTop)){
                camera.position.set(x,y,0);
                camera.update();
            }
            else if (py > boarderBottom) {
                camera.position.set(x, boarderTop, 0);
                camera.update();
            }
            else{
                camera.position.set(x, boarderBottom, 0);
                camera.update();
            }
        }
        else if (px > boarderLeft) {
            if((py > boarderBottom) && (py < boarderTop)){
                camera.position.set(boarderRight,y,0);
                camera.update();
            }
            else if (py > boarderBottom) {
                camera.position.set(boarderRight, boarderTop, 0);
                camera.update();
            }
            else{
                camera.position.set(boarderRight, boarderBottom, 0);
                camera.update();
            }
        }
        else if ((px < boarderRight)) {
            if((py > boarderBottom) && (py < boarderTop)){
                camera.position.set(boarderLeft,y,0);
                camera.update();
            }
            else if (py > boarderBottom) {
                camera.position.set(boarderLeft, boarderTop, 0);
                camera.update();
            }
            else{
                camera.position.set(boarderLeft, boarderBottom, 0);
                camera.update();
            }
        }
        else if((py > boarderBottom) && (py < boarderTop)) {
            if (px > boarderLeft) {
                camera.position.set(boarderRight, y, 0);
                camera.update();
            } else {
                camera.position.set(boarderLeft, y, 0);
                camera.update();
            }
        }
        else if (py > boarderBottom) {
            camera.position.set(x, boarderTop, 0);
            camera.update();
        }
        else if (py < boarderTop) {
            camera.position.set(x, boarderBottom, 0);
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
