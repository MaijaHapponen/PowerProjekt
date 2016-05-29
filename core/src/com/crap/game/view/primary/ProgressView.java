package com.crap.game.view.primary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.crap.game.model.character.Mascot;
import com.crap.game.model.primary.Progress;

/**
 * Created by rebeccafinne on 2016-05-05.
 */
public class ProgressView extends ScreenAdapter {

    private Progress progress;
    private SpriteBatch batch;
    private Image progressBarImage;
    private Table table;


    private int progressbarWidth = Gdx.graphics.getWidth();
    private int progressbarHeight = Gdx.graphics.getHeight();

    private Viewport viewPort;
    private Stage stage;

    private Group group;

    public ProgressView(Progress progress){

        batch = new SpriteBatch();
        viewPort = new FitViewport(progressbarWidth, progressbarHeight, new OrthographicCamera());
        stage = new Stage(viewPort, batch);
        this.progress = progress;
        table = new Table();
        table.bottom();
        table.setFillParent(true);

        this.group = new WidgetGroup();

        this.progressBarImage = new Image(new Texture("progressbar/progressbar.png"));
        updateProgressBar();

    }

    public void drawStage(){
        stage.draw();
    }

    public Stage getStage(){
        return this.stage;
    }

    public void updateProgressBar(){
        group.addActor(progressBarImage);
        if (progress.getMascotsCaught() != null) {
            for(int i = 0; i < progress.getMascotsCaught().size(); i++) {
                Mascot tempMascot = progress.getMascotsCaught().get(i);
                Image image;
                image = new Image(new Texture("progressbar/"+tempMascot.getName()+".png"));
                group.addActor(image);
            }
        }
        table.left();
        table.add(group);
        stage.addActor(table);
    }
    @Override
    public void dispose(){
        batch.dispose();
        stage.dispose();
    }

}



