package com.crap.game.model;

import java.util.ArrayList;

import com.crap.game.model.Mascot;

/**
 * Created by Lisa on 24/04/16.
 */
public class Progress {

    private ArrayList<Mascot> mascotsInGame = new ArrayList<Mascot>(); //TODO borde denna listan vara här eller i någon annan klass istället? Måste fylla på den när man startar spelet.
    private ArrayList<Mascot> mascotsCaught;
    private ArrayList<Mascot> charactersOnBar;
    private Position position;
    private boolean newMascotCaught = false;
    private Mascot newMascotToBar;

    //Constructor
    public Progress() {
        mascotsCaught = new ArrayList<Mascot>();
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
                newMascotCaught = true;
            }
        }
        mascotsCaught.add(mascot);
        newMascotToBar =  mascot;
        newMascotCaught = false;
    }


    public ArrayList<Mascot> getMascotsCaught() {
        return this.mascotsCaught;
    }

    public ArrayList<Mascot> getMascotsInGame() {
        return mascotsInGame;
    }

    public void charactersOnBar() {
        for (int i = 0; i < mascotsCaught.size(); i++) {
            // if(mascotsCaught.get(i).getName().equals(g));


            //  }
        }

    }

    public ArrayList<Mascot> getCaractersOnBar(){
        return this.charactersOnBar;
    }

    public boolean isNewMascotCaught(){
        return this.newMascotCaught;
    }

    public Position getPosition(){
        return this.position;
    }

    public Mascot getNewMascotToBar(){
        return this.newMascotToBar;
    }
}
