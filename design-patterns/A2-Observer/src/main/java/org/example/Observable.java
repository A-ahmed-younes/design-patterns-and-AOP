package org.example;

public interface Observable {
     void subscribe(Observer o);
     void unsubscribe(Observer o);
     void notifyObservers();
}
