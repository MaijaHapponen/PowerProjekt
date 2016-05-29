package com.crap.game.controller.game.character;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapObject;
import com.crap.game.model.character.*;
import com.crap.game.model.character.Character;
import com.crap.game.model.information.enums.AnimationState;
import com.crap.game.model.primary.Position;
import com.crap.game.view.character.CharacterView;
import com.crap.game.view.primary.CRAPView;
import com.crap.game.view.character.PlayerView;

import static com.crap.game.model.information.Constants.PIXEL_PER_TILE;

public class PlayerController extends CharacterController {

    private PlayerView playerView;
    public MapObject newWorldObject;

    public PlayerController(PlayerView playerView, CRAPView CRAPView){
        super(CRAPView, playerView.getPlayer(), playerView);
        this.playerView = playerView;
        this.newWorldObject = getCollisionController().getNewWorldObject();
    }

    public void movePlayer(int keycode) {
        updateSpeed();
        if (keycode == Input.Keys.UP &&
                !(checkIfCollision(getCharacter().nextStepUp()))) {
            super.moveUp();
        }
        else if (keycode == Input.Keys.DOWN &&
                !(checkIfCollision(getCharacter().nextStepDown()))){
            super.moveDown();
        }
        else if (keycode == Input.Keys.LEFT &&
                !(checkIfCollision(getCharacter().nextStepLeft()))){
            super.moveLeft();
        }
        else if (keycode == Input.Keys.RIGHT &&
                !(checkIfCollision(getCharacter().nextStepRight())) )  {
            super.moveRight();
        }
        updateSprite();
        updateCamera();
    }

    public void updateCamera(){
        playerView.moveCamera(getCharacter().getPosition().getX(), getCharacter().getPosition().getY(),
                getCRAPView().getWorldHeight() + PIXEL_PER_TILE, getCRAPView().getWorldWidth() + PIXEL_PER_TILE);
    }

    //Returns true if there is a collision.
    public boolean checkIfCollision(Position p){
        return (getCollisionController().isCollison(p.getX(),p.getY()) ||
                getCollisionController().isNewWorld(p.getX(),p.getY())||
                getInteractionController().isInteractionWithHuman(p.getX(),p.getY()) ||
                getInteractionController().isInteractionWithMascot(p.getX(),p.getY()));
    }

    public boolean isInteractionWithMascot(){
        return checkIfInteractionWithMascot(getCharacter().nextStepUp()) ||
                checkIfInteractionWithMascot(getCharacter().nextStepDown()) ||
                checkIfInteractionWithMascot(getCharacter().nextStepLeft()) ||
                checkIfInteractionWithMascot(getCharacter().nextStepRight());
    }

    public boolean checkIfInteractionWithMascot(Position pos){
        return getInteractionController().isInteractionWithMascot(pos.getX(), pos.getY());
    }

    public boolean isInteractionWithHuman(){
        return checkIfInteractionWithHuman(getCharacter().nextStepUp()) ||
                checkIfInteractionWithHuman(getCharacter().nextStepDown()) ||
                checkIfInteractionWithHuman(getCharacter().nextStepLeft()) ||
                checkIfInteractionWithHuman(getCharacter().nextStepRight());
    }

    public boolean checkIfInteractionWithHuman(Position pos){
        return getInteractionController().isInteractionWithHuman(pos.getX(), pos.getY());
    }

    public boolean isNewWorld(){
        return checkIfNewWorld(getCharacter().nextStepUp()) || checkIfNewWorld(getCharacter().nextStepDown())
                || checkIfNewWorld(getCharacter().nextStepLeft()) || checkIfNewWorld(getCharacter().nextStepRight());
    }

    public boolean checkIfNewWorld(Position pos){
        return getCollisionController().isNewWorld(pos.getX(),pos.getY());
    }

    public void updateSpeed(){
        if(getCollisionController().isSlowerTerrain(getCharacter().getPosition().getX(),
                getCharacter().getPosition().getY())){
            getCharacter().setSlowerSpeed();
        }
        else{
            getCharacter().setNormalSpeed();
        }
    }

    public void stopWalkingAnimation(int keyCode){
        switch (keyCode){
            case Input.Keys.UP:
                playerView.setAnimationState(AnimationState.STANDING_BACK);
                break;
            case Input.Keys.DOWN:
                playerView.setAnimationState(AnimationState.STANDING_FRONT);
                break;
            case Input.Keys.LEFT:
                playerView.setAnimationState(AnimationState.STANDING_LEFT);
                break;
            case Input.Keys.RIGHT:
                playerView.setAnimationState(AnimationState.STANDING_RIGHT);
                break;
        }
    }
    public Character getInteractingCharacter(){
        return interactionController.getInteractingCharacter();
    }
    public CharacterView getInteractingCharacterView(){
        return interactionController.getInteractingCharacterView();
    }
}
