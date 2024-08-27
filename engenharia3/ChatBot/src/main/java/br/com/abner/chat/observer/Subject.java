package br.com.abner.chat.observer;

public interface Subject {
    void notifyObservers(String message);
}
