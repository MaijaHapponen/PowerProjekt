package model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * Created by andrea on 2016-04-11.
 */
public class Player implements PropertyChangeListener {
    private Position position;

    //Constructor
    public Player(){
        this.position = new Position();
    }

    //Constructor
    public Player(int x, int y){
        this.position = new Position(x, y);
    }

    public void propertyChange(PropertyChangeEvent evt){
        this.movePlayer(evt.getPropertyName());
    }

    //Moves the player up, down, right or left.
    public void movePlayer(String direction){

        if (direction.equals("38")) {
            this.moveUp();

        } else if (direction.equals("40")) {
            this.moveDown();

        } else if (direction.equals("37")) {
            this.moveLeft();

        } else if (direction.equals("39")) {
            this.moveRight();
        }

        System.out.println("Player X-coordinate: " + this.getPosition().getX()); //TODO remove later
        System.out.println("Player Y-coordinate: " + this.getPosition().getY()); //TODO remove later
    }

    //Moves the player one step up.
    public void moveUp(){
        if(this.position.getY() > 0) {
            this.position.setPosition(position.getX(), position.getY() - 1);
        }
    }

    //Moves the player one step down.
    public void moveDown(){
        if(this.position.getY() < 100) { //TODO should be changed to the max height of the world later.
            this.position.setPosition(position.getX(), position.getY() + 1);
        }
    }

    //Moves the player one step to the right.
    public void moveRight(){
        if(this.position.getX() < 100) { //TODO should be changed to the max width of the world later.
            this.position.setPosition(position.getX() + 1, position.getY());
        }
    }

    //Moves the player one step to the left.
    public void moveLeft(){
        if(this.position.getX() > 0){
            this.position.setPosition(position.getX() - 1, position.getY());
        }
    }

    //Returns the players Position object.
    public Position getPosition(){
        return this.position;
    }

}
