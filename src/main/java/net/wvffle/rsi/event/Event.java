package net.wvffle.rsi.event;

import java.util.Date;

public class Event {
    private String name;
    private EventType type;
    private Date date;
    private String description;

    public Event(String name, EventType type, Date date, String description) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public EventType getType() {
        return type;
    }
    
    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(EventType type) {
            this.type = type;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event " + "name: " + name + ", type: " + type + ", date: " + date + ", description " + description;
    }
}