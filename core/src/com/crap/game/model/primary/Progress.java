package com.crap.game.model.primary;

import com.crap.game.model.character.Mascot;

import java.util.ArrayList;

public class Progress {

    private ArrayList<Mascot> allMascots = new ArrayList<Mascot>();
    private ArrayList<Mascot> mascotsInGame;
    private ArrayList<Mascot> mascotsCaught = new ArrayList<Mascot>();
    private boolean newUpdate;

    public Progress(ArrayList<Mascot> mascots) {
        for(int i=0; i<mascots.size(); i++){
            allMascots.add(mascots.get(i));
        }
        this.mascotsInGame = mascots;
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
        setNewUpdate(true);
    }

    public ArrayList<Mascot> getMascotsCaught() {
        return this.mascotsCaught;
    }

    public boolean newUpdate(){
        return this.newUpdate;
    }

    public void setNewUpdate(boolean b){
        newUpdate = b;
    }
}
