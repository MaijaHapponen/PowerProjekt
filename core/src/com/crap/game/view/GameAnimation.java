package com.crap.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Lisa on 09/05/16.
 */
public class GameAnimation {
    private TextureRegion[][] tmpFrames;
    private TextureRegion[] animationFrames;


    public Animation createAnimation(Texture texture, int width, int height, int rows, int columns, int startRow,
                                     int endRow) {
        tmpFrames = TextureRegion.split(texture, width/columns, height/rows);

        animationFrames = new TextureRegion[columns*(1+(endRow-startRow))];
        int index = 0;

        for (int i = startRow - 1; i < endRow; i++) {
            for (int j = 0; j < columns; j++) {
                animationFrames[index++] = tmpFrames[i][j];
            }
        }
        return new Animation(1f / 4f, animationFrames);
    }

    public Animation getAnimation(PlayerView.AnimationState animationState, Texture texture, int width, int height,
                                  int rows, int columns){
        switch (animationState){
            case WALKING_FRONT:
                return getAnimationFront(texture, width, height, rows, columns);

            case WALKING_BACK:
                return getAnimationBack(texture, width, height, rows, columns);

            case WALKING_LEFT:
                return getAnimationLeft(texture, width, height, rows, columns);

            case WALKING_RIGHT:
                return getAnimationRight(texture, width, height, rows, columns);

            case STANDING_FRONT:
                return getAnimationFront(texture, width, height, rows, columns); //TODO fix new method

            case STANDING_BACK:
                return getAnimationFront(texture, width, height, rows, columns); //TODO fix new method

            case STANDING_LEFT:
                return getAnimationFront(texture, width, height, rows, columns); //TODO fix new method

            case STANDING_RIGHT:
                return getAnimationFront(texture, width, height, rows, columns); //TODO fix new method
        }
        return getAnimationFront(texture, width, height, rows, columns); //TODO fix later
    }

    public Animation getAnimationFront(Texture texture, int width, int height, int rows, int columns){
        return createAnimation(texture, width, height, rows, columns, 1, 1);
    }

    public Animation getAnimationBack(Texture texture, int width, int height, int rows, int columns){
        return createAnimation(texture, width, height, rows, columns, 4, 4);
    }

    public Animation getAnimationLeft(Texture texture, int width, int height, int rows, int columns){
        return createAnimation(texture, width, height, rows, columns, 2, 2);
    }

    public Animation getAnimationRight(Texture texture, int width, int height, int rows, int columns){
        return createAnimation(texture, width, height, rows, columns, 3, 3);
    }
}
