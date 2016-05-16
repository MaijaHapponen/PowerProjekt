package com.crap.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;



import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.*;





/**
 * Created by rebeccafinne on 2016-05-05.
 */
public class ProgressView extends ApplicationAdapter implements Screen {

    Player player;
    private Progress progress;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Image image;
    private Table table;

    private int progressbarWidth = 500;
    private int progressbarHeight = 500;


    private Label mascotsCaughtLabel = new Label(String.format("Mascots you have caught"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
    private Viewport viewPort;
    private Stage stage;

    public ProgressView(Progress progress){

        batch = new SpriteBatch();
        viewPort = new FitViewport(progressbarWidth, progressbarHeight, new OrthographicCamera());
        stage = new Stage(viewPort, batch);
        this.progress = progress;
        table = new Table();
        table.bottom();
        table.setFillParent(true);

        this.setProgressBarTable(table);


        stage.addActor(table);


    }

    public Label getMascotsCaughtLabel(){
        return this.mascotsCaughtLabel;
    }

    public Stage getStage(){
        return this.stage;
    }

    public Table setProgressBarTable(Table table){
        table.add(mascotsCaughtLabel);
        if(progress.getMascotsCaught() != null) {
            table.row();
            for(int i = 0; i < progress.getMascotsCaught().size(); i++) {
                Mascot tempMascot = progress.getMascotsCaught().get(i);
                image = new Image(new Texture(tempMascot.getName()));
                table.add(image);

            }
        }return this.table;

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


    public OrthographicCamera getCamera(){
        return this.camera;
    }

    public void setCamera(OrthographicCamera camera){
        this.camera = camera;
    }



}



