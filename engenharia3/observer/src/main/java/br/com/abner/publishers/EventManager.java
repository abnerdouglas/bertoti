package br.com.abner.publishers;

import br.com.abner.events.EventType;
import br.com.abner.listeners.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    Map<EventType, List<Observer>> listeners = new HashMap<>();

    public EventManager(EventType... operations){
        for(EventType operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(EventType eventType, Observer observer) {
        List<Observer> users = listeners.get(eventType);
        users.add(observer);
    }

    public void notify(EventType event){
        List<Observer> users = listeners.get(event);
        for (Observer observer : users){
            observer.update(event);
        }
    }
}
