package com.crap.game.model;

public class Menu {

    private String gameName;
    private int currentItemNr;
    private String currentItem;
    private String[] menuItems;

    public Menu(String gameName,String[] menuItems){
        this.gameName = gameName;
        this.menuItems = menuItems;
        currentItemNr =0;
        currentItem = menuItems[currentItemNr];
    }

    public void setCurrentItem(String direction){
        int lastItemNr = amountOfItems() -1;
        if(direction.equals("nextStepUp")){
            if(currentItemNr == 0) currentItemNr =lastItemNr;
            else currentItemNr = currentItemNr -1;

        }else if(direction.equals("nextStepDown")){
            if(currentItemNr == lastItemNr) currentItemNr = 0;
            else currentItemNr = currentItemNr + 1;
        }
        currentItem = menuItems[currentItemNr];
    }

    public String getGameName(){
        return gameName;
    }
    public String getCurrentItem(){
        return currentItem;
    }
    public int amountOfItems(){
        return menuItems.length;
    }
    public String getMenuItem(int i){
        return menuItems[i];
    }
    public int currentItemNumber(){
        return currentItemNr;
    }
}

