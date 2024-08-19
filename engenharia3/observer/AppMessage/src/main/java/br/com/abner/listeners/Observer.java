package br.com.abner.listeners;

import br.com.abner.events.EventType;

public interface Observer {
    void update(EventType event);
}
