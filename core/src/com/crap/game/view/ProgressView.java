package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;
import com.crap.game.model.Character;
import com.sun.prism.image.ViewPort;


import java.util.ArrayList;

/**
 * Created by rebeccafinne on 2016-05-05.
 */
public class ProgressView extends ApplicationAdapter implements Screen {

    private Character character;
    private Texture textureBack;
    private Texture textureMascots;
    private Sprite spriteBack;
    private Sprite spriteMascots;
    private Progress progress;
    Player player;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    private int progressbarWidth = 400;
    private int progressbarHeight = 100;

    private Label mascotsCaughtLabel = new Label(String.format("Mascots you have caught"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Viewport viewPort;
    private Stage stage;



    private TextureRegion textureRegion; //To make the progressbar a region and put caught mascots on there easier




    public ProgressView(){

        batch = new SpriteBatch();
        viewPort = new FitViewport(progressbarWidth, progressbarHeight, new OrthographicCamera());
        stage = new Stage(viewPort, batch);

        Table table = new Table();
        table.bottom();
        table.setFillParent(true);

        table.add(mascotsCaughtLabel);
        table.row();
        table.add(progress.getNameCharactersOnBar());

        stage.addActor(table);


    }

    public Label getMascotsCaughtLabel(){
        return this.mascotsCaughtLabel;
    }

    public Stage getStage(){
        return this.stage;
    }

    public Texture getTextureBack(){
        return this.textureBack;
    }

    public int getProgressbarWidth(){
        return this.progressbarWidth;
    }

    public int getProgressbarHeight(){
        return this.progressbarHeight;
    }

    public Sprite getSpriteBack(){
        return this.spriteBack;
    }

    public Sprite getSpriteMascots(){
        return this.spriteMascots;
    }

    public TextureRegion getTextureRegion(){
        return this.textureRegion;
    }


    public void moveCamera() {
        //TODO: fix so red is not visible
        if ((player.getPosition().getX() > 500 / 2) || (player.getPosition().getY() > 500 / 2)) {
            camera.position.set(player.getPosition().getX(), player.getPosition().getY(), 0);
            camera.update();
        }
       /* camera.position.set(player.getPosition().getX() - 250, player.getPosition().getY() -250, 0);
        camera.update();    */
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

    public void update(){
        if(progress.isNewMascotCaught()){
            this.textureMascots = new Texture(progress.getNewMascotToBar().getName());
            this.spriteMascots = new Sprite(textureMascots);
            progress.getCaractersOnBar().add(progress.getNewMascotToBar());
        }
    }

    public OrthographicCamera getCamera(){
        return this.camera;
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }



}



