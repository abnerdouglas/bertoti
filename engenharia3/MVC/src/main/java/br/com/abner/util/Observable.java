package br.com.abner.util;

import br.com.abner.view.Observer;

public interface Observable {
    void addObserver(Observer o);
    void notifyObservers();
}

