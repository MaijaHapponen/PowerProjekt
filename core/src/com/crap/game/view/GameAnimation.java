package com.crap.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Lisa on 09/05/16.
 */
public class GameAnimation {
    private Texture img; //TODO animation
    private TextureRegion[][] tmpFrames; //TODO animation
    private TextureRegion[] animationFrames; //TODO animation
    private Animation animation; //TODO animation

//    public GameAnimation(Texture texture, int width, int height, int columns, int startRow, int endRow) {
//        TextureRegion[][] tmpFrames = TextureRegion.split(texture, width, height); //TODO animation
//
////        animationFrames = new TextureRegion[16];
////        int index = 1;
////
////        for (int i = 0; i < 3; i++) {
////            for (int j = 0; j < 3; j++) {
////                animationFrames[index++] = tmpFrames[i][j];
////            }
////        }
////        this.animation = new Animation(1f/4f, animationFrames);
//    }


    public GameAnimation(){
        this.img = new Texture(Gdx.files.internal("characters/kalleAnka.png"));
        tmpFrames = TextureRegion.split(img,129/4,190/4);

        animationFrames = new TextureRegion[16];
        int index = 0;

        for (int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                animationFrames[index++] = tmpFrames[i][j];
            }
        }

        animation = new Animation(1f/4f, animationFrames);
    }


    public Animation getAnimation(){
        return this.animation;
    }


//    public Animation createAnimation(Texture texture, int width, int height, int columns, int startRow, int endRow){
//        TextureRegion[][] tmpFrames = TextureRegion.split(texture, width, height);
//
//        animationFrames = new TextureRegion[16];
//        int index = 1;
//
//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++){
//                animationFrames[index++] = tmpFrames[i][j];
//            }
//        }


        /*
        for(int i=startRow; i<endRow+1; i++){
            for(int j=0; j<columns; j++){
                animationFrames[index++] = tmpFrames[i][j];
            }
        }*/
//        this.animation = new Animation(1f/4f, animationFrames);

//        return new Animation(1f/4f, animationFrames);
//    }

//    public Animation getAnimationFront(Texture texture, int width, int height, int columns, int startRow, int endRow){
//        this.animation = createAnimation(texture, width, height, columns, startRow, endRow); //TODO ändra mått
//        return this.animation;
//    }
//
//    public Animation getAnimationBack(Texture texture, int width, int height, int columns, int startRow, int endRow){
//        this.animation = createAnimation(texture, width, height, columns, startRow, endRow);
//        return this.animation;
//    }
//
//    public Animation getAnimationLeft(Texture texture, int width, int height, int columns, int startRow, int endRow){
//        this.animation = createAnimation(texture, width, height, columns, startRow, endRow);
//        return this.animation;
//    }
//
//    public Animation getAnimationRight(Texture texture, int width, int height, int columns, int startRow, int endRow){
//        this.animation = createAnimation(texture, width, height, columns, startRow, endRow);
//        return this.animation;
//    }
}
