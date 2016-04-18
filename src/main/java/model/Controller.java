package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Created by Lisa on 18/04/16.
 */
public class Controller implements IObservable{

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener observer){
        pcs.addPropertyChangeListener(observer);
    }

    public void removeObserver(PropertyChangeListener observer){
        pcs.removePropertyChangeListener(observer);
    }


    KeyListener listener = new KeyListener() {

        @Override
        public void keyPressed(KeyEvent e) {
            String keyCode = "" + e.getKeyCode();
            pcs.firePropertyChange(keyCode, true, false);
        }

        @Override
        public void keyReleased(KeyEvent event) {
        }

        @Override
        public void keyTyped(KeyEvent event) {
        }
    };
}
