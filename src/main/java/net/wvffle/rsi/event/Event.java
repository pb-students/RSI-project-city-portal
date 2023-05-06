package net.wvffle.rsi.event;

import java.util.Calendar;

public class Event {
    /**
     * Name of the event
     */
    private String name;

    /**
     * Type of the event
     */
    private String type;

    /**
     * Date of the event
     */
    private Calendar date;

    /**
     * Description of the event
     */
    private String description;


    /**
     * Constructor for creating a new event instance
     * @param name is the name of the event
     * @param type is the type of the event
     * @param date is the date of the event
     * @param description description of the event
     */
    public Event(String name, String type, Calendar date, String description) {
        this.name = name;
        this.type = type;
        this.date = date;
        this.description = description;
    }

    /**
     * Event name getter
     * @return name of the event
     */
    public String getName() {
        return name;
    }

    /**
     * Event type getter
     * @return type of the event
     */
    public String getType() {
        return type;
    }
    
    /**
     * Event date getter
     * @return date of the event
     */
    public Calendar getDate() {
        return date;
    }

    /**
     * Event description getter
     * @return description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Event name setter
     * @param name is the new name of the event
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Event type setter
     * @param type is the new type of the event
     */
    public void setType(String type) {
            this.type = type;
    }

    /**
     * Event date setter
     * @param date is the new date of the event
     */
    public void setDate(Calendar date) {
        this.date = date;
    }

    /**
     * Event description setter
     * @param description is the new description of the event
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Event toString method
     * @return String representation of the event
     */
    @Override
    public String toString() {
        return "Event " + "name: " + name + ", type: " + type + ", date: " + date + ", description " + description;
    }
}