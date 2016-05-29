package com.crap.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.crap.game.model.AnimationState;

/**
 * Created by Lisa on 09/05/16.
 */
public class GameAnimation {

    private TextureRegion[][] tmpFrames;
    private TextureRegion[] animationFrames;

    public Animation createAnimation(Texture texture, int rows, int columns, int startRow,
                                     int endRow) {
        tmpFrames = TextureRegion.split(texture, texture.getWidth()/columns, texture.getHeight()/rows);

        animationFrames = new TextureRegion[columns*(1+(endRow-startRow))];
        int index = 0;

        for (int i = startRow - 1; i < endRow; i++) {
            for (int j = 0; j < columns; j++) {
                animationFrames[index++] = tmpFrames[i][j];
            }
        }
        return new Animation(1f/5f, animationFrames);
    }

    public Animation createImage(Texture texture, int rows, int columns, int imageRow,
                                 int imageColumn){
        tmpFrames = TextureRegion.split(texture, texture.getWidth()/columns, texture.getHeight()/rows);
        animationFrames = new TextureRegion[1];
        animationFrames[0] = tmpFrames[imageRow][imageColumn];
        return new Animation(1f/4f, animationFrames);
    }

    public Animation getAnimation(AnimationState animationState, Texture texture, int width, int height,
                                  int rows, int columns){
        switch (animationState){
            case WALKING_FRONT:
                return getAnimationWalkingFront(texture, rows, columns);

            case WALKING_BACK:
                return getAnimationWalkingBack(texture, rows, columns);

            case WALKING_LEFT:
                return getAnimationWalkingLeft(texture, rows, columns);

            case WALKING_RIGHT:
                return getAnimationWalkingRight(texture, rows, columns);

            case STANDING_FRONT:
                return getAnimationStandingFront(texture, rows, columns);

            case STANDING_BACK:
                return getAnimationStandingBack(texture, rows, columns);

            case STANDING_LEFT:
                return getAnimationStandingLeft(texture, rows, columns);

            case STANDING_RIGHT:
                return getAnimationStandingRight(texture, rows, columns);
        }
        return getAnimationStandingFront(texture, rows, columns);
    }

    public Animation getAnimationWalkingFront(Texture texture, int rows, int columns){
        return createAnimation(texture, rows, columns, 1, 1);
    }

    public Animation getAnimationWalkingBack(Texture texture, int rows, int columns){
        return createAnimation(texture,rows, columns, 4, 4);
    }

    public Animation getAnimationWalkingLeft(Texture texture, int rows, int columns){
        return createAnimation(texture, rows, columns, 2, 2);
    }

    public Animation getAnimationWalkingRight(Texture texture, int rows, int columns){
        return createAnimation(texture, rows, columns, 3, 3);
    }

    public Animation getAnimationStandingFront(Texture texture, int rows, int columns){
        return createImage(texture, rows, columns, 0, 0);
    }

    public Animation getAnimationStandingBack(Texture texture, int rows, int columns){
        return createImage(texture, rows, columns, 3, 0);
    }

    public Animation getAnimationStandingLeft(Texture texture, int rows, int columns){
        return createImage(texture, rows, columns, 1, 0);
    }

    public Animation getAnimationStandingRight(Texture texture, int rows, int columns){
        return createImage(texture, rows, columns, 2, 0);
    }
}
