package model;

import java.beans.PropertyChangeListener;

/**
 * Created by Lisa on 18/04/16.
 */
public interface IObservable {

    public void addObserver(PropertyChangeListener observer);

    public void removeObserver(PropertyChangeListener observer);

}
