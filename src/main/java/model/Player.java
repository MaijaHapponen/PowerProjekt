package model;

/**
 * Created by andrea on 2016-04-11.
 */
public class Player {
    private Position position;

    //Constructor
    public Player(){
        this.position = new Position();
    }

    //Constructor
    public Player(int x, int y){
        this.position = new Position(x, y);
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

    public Position getPosition(){
        return this.position;
    }
}
