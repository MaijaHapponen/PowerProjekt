package com.crap.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Lisa on 09/05/16.
 */
public class GameAnimation {
    TextureRegion[] animationFrames;
    private Animation animation;

    public Animation createAnimation(Texture texture, int width, int height, int columns, int startRow, int endRow){
        TextureRegion[][] tmpFrames = TextureRegion.split(texture, width, height);

        animationFrames = new TextureRegion[columns*(1+(endRow-startRow))];
        int index = 1;

        for(int i=startRow; i<endRow+1; i++){
            for(int j=0; j<columns; j++){
                animationFrames[index++] = tmpFrames[i][j];
            }
        }
        animation = new Animation(1f/4f,animationFrames);

        return this.animation;
    }

    public Animation getAnimationFront(Texture texture, int width, int height, int columns, int startRow, int endRow){
        this.animation = createAnimation(texture, width, height, columns, startRow, endRow); //TODO ändra mått
        return this.animation;
    }

    public Animation getAnimationBack(Texture texture, int width, int height, int columns, int startRow, int endRow){
        this.animation = createAnimation(texture, width, height, columns, startRow, endRow);
        return this.animation;
    }

    public Animation getAnimationLeft(Texture texture, int width, int height, int columns, int startRow, int endRow){
        this.animation = createAnimation(texture, width, height, columns, startRow, endRow);
        return this.animation;
    }

    public Animation getAnimationRight(Texture texture, int width, int height, int columns, int startRow, int endRow){
        this.animation = createAnimation(texture, width, height, columns, startRow, endRow);
        return this.animation;
    }
}
