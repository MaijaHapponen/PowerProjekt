package com.crap.game.model;

import java.util.ArrayList;

/**
 * Created by Lisa on 24/04/16.
 */
public class Progress {

    private ArrayList<Mascot> mascotsInGame;
    private ArrayList<Mascot> mascotsCaught = new ArrayList<Mascot>();

    public Progress(ArrayList<Mascot> mascotsInGame) {
        this.mascotsInGame = mascotsInGame;
        mascotsCaught =mascotsInGame;
    }

    //Method checking if all mascots has been caught by the player.
    public boolean areAllMascotsCaught() {
        if (mascotsInGame.isEmpty()) {
            return true;
        }
        return false;
    }

    //Adds the caught mascot to the list of mascots caught and removes it from the list of mascots still in the game.
    public void mascotCaught(Mascot mascot) {
        for (int i = 0; i < mascotsInGame.size(); i++) {
            if (mascotsInGame.get(i).equals(mascot)) {
                mascotsInGame.remove(i);
            }
        }
        mascotsCaught.add(mascot);
    }

    public ArrayList<Mascot> getMascotsCaught() {
        return this.mascotsCaught;
    }

    public ArrayList<Mascot> getMascotsInGame() {
        return mascotsInGame;
    }

    public void setMascotsInGame(ArrayList<Mascot> mascotsInGame){
        this.mascotsInGame = mascotsInGame;
    }


}
