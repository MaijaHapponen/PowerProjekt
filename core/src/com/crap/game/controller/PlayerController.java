package com.crap.game.controller;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapObject;
import com.crap.game.model.Player;
import com.crap.game.model.Position;
import com.crap.game.view.GameView;
import com.crap.game.view.PlayerView;

import static com.crap.game.model.Constants.pixelPerTile;

/**
 * Created by rebeccafinne on 2016-04-30.
 */
public class PlayerController {
    private GameView gameView;
    private PlayerView playerView;
    private Player player;
    private CollisionController collisionController;
    private InteractionController interactionController;
    public MapObject newWorldObject;

    public PlayerController(PlayerView playerView, GameView gameView){
        this.playerView = playerView;
        this.player = playerView.getPlayer();
        this.gameView = gameView;
        this.collisionController = new CollisionController(gameView.getWorld());
        this.interactionController = new InteractionController(gameView);
        this.newWorldObject = collisionController.getNewWorldObject();
    }

    public Player getPlayer(){
        return this.player;
    }

    public void updateCollisionController(){
        this.collisionController = new CollisionController(gameView.getWorld());
        collisionController.setPlayerWidthAndHeight(playerView.getPlayerSpriteWidth(),playerView.getPlayerSpriteHeight());
    }

    public void movePlayer(int keycode) {

        updateSpeed();

        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(player.up()))) {
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_BACK);
            player.moveUp(gameView.getWorldHeight());
        }

        else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(player.down()))){
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_FRONT);
            player.moveDown();
        }

        else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision(player.left()))){
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_LEFT);
            player.moveLeft();
        }

        else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(player.right())) )  {
            playerView.setAnimationState(PlayerView.AnimationState.WALKING_RIGHT);
            player.moveRight(gameView.getWorldWidth());
        }

        updateSprite();
        playerView.moveCamera(player.getPosition().getX(), player.getPosition().getY(),
                gameView.getWorldHeight()+ pixelPerTile, gameView.getWorldWidth()+pixelPerTile);

    }

    public void updateSprite() {
        playerView.getSprite().setPosition(player.getPosition().getX(), player.getPosition().getY());
    }

    public boolean checkIfCollision(Position p){
        return (collisionController.isCollison(p.getX(),p.getY()) || collisionController.isNewWorld(p.getX(),p.getY())||
                interactionController.isInteractionWithHuman(p.getX(),p.getY())
                || interactionController.isInteractionWithMascot(p.getX(),p.getY()));
    }

    public boolean isInteractionWithMascot(){
        return checkIfInteractionWithMascot(player.up()) || checkIfInteractionWithMascot(player.down()) ||
                checkIfInteractionWithMascot(player.left()) || checkIfInteractionWithMascot(player.right());
    }

    public boolean checkIfInteractionWithMascot(Position pos){
        return interactionController.isInteractionWithMascot(pos.getX(),pos.getY());
    }

    public boolean isInteractionWithHuman(){
        return checkIfInteractionWithHuman(player.up()) || checkIfInteractionWithHuman(player.down()) ||
                checkIfInteractionWithHuman(player.left()) || checkIfInteractionWithHuman(player.right());
    }

    public boolean checkIfInteractionWithHuman(Position pos){
        return interactionController.isInteractionWithHuman(pos.getX(), pos.getY());
    }

    public boolean isNewWorld(){

        return checkIfNewWorld(player.up()) || checkIfNewWorld(player.down())
                || checkIfNewWorld(player.left()) || checkIfNewWorld(player.right());
    }

    public boolean checkIfNewWorld(Position pos){
        return collisionController.isNewWorld(pos.getX(),pos.getY());
    }


    public void updateSpeed(){
        if(collisionController.isSlowerTerrain(player.getPosition().getX(), player.getPosition().getY())){
            player.setSlowerSpeed();
        }
        else{
            player.setNormalSpeed();
        }
    }

    public void stopWalkingAnimation(int keyCode){
        switch (keyCode){
            case Input.Keys.UP:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_BACK);
                break;
            case Input.Keys.DOWN:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_FRONT);
                break;
            case Input.Keys.LEFT:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_LEFT);
                break;
            case Input.Keys.RIGHT:
                playerView.setAnimationState(PlayerView.AnimationState.STANDING_RIGHT);
                break;
        }
    }

    public CollisionController getCollisionController(){
        return this.collisionController;
    }

    public InteractionController getInteractionController(){
        return this.interactionController;
    }
}
