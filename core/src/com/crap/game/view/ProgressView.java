package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.crap.game.model.Position;
import com.crap.game.model.Progress;

/**
 * Created by rebeccafinne on 2016-05-05.
 */
public class ProgressView extends ApplicationAdapter implements Screen {


    private Texture texture;
    private Position position;
    private Sprite sprite;
    private float width;
    private float height;
    private OrthographicCamera camera;
    private Progress progress;
    // private SpriteBatch batch;

    public ProgressView(){
        this.texture = new Texture("Progress/html5-progress-bar.jpg");
        this.sprite = new Sprite(texture);
        this.width = 40;
        this.height = 30;
        this.progress = new Progress();
        this.sprite.setPosition(0, 0);
        this.camera = new OrthographicCamera();
    }

    public Texture getProgress(){
        return this.texture;
    }

    public Sprite getSprite(){
        return this.sprite;
    }

    public void setSize(float w, float h){
        this.height = h;
        this.width = w;
    }

    public float getWidth(){
        return this.width;
    }

    public float getHeight(){
        return this.height;
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }
    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }

    public void moveCamera(int x,float y) {
        //TODO: fix so red is not visible
        if ((getPosition().getX() > 500 / 2) || (getPosition().getY() > 500 / 2)) {
            camera.position.set(x, y, 0);
            camera.update();
        }
    }

    public Position getPosition(){
        return progress.getPosition();
    }

    /* public void setPosition(float x, float y){
          x = getPosition().getX();
          y = getPosition().getY();
      }*/
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void hide() {

    }


}



