package net.wvffle.rsi.services;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Phrase;

import net.wvffle.rsi.event.Event;
import net.wvffle.rsi.event.EventType;
import net.wvffle.rsi.utils.MapWrapper;

@MTOM
@WebService
@BindingType(value = SOAPBinding.SOAP11HTTP_BINDING)
public class CityInformation {
    
    /**
     * Static HashMap that stores all events
     */
    private static HashMap<String, Event> events;

    /**
     * Singleton that creates new instance of events if the HashMap is null
     * @return instance of events
     */
    public static HashMap<String, Event> getEventsInstance() {
        if (events == null) {
            events = new HashMap<String, Event>();
        }

        return events;
    }

    /**
     * Puts new event to the events
     * @param name is the name of the event
     * @param type is the type of the event
     * @param date is the date of the event
     * @param description description of the event
     */
    @WebMethod
    public void addEvent(
        @WebParam(name="name")          String name, 
        @WebParam(name="type")          EventType type, 
        @WebParam(name="date")          Date date, 
        @WebParam(name="description")   String description
    ) {
        getEventsInstance().put(name, new Event(name, type, date, description));
    }

    /**
     * Modifies name of the event
     * @param oldName is the key to find the event
     * @param newName is the new name of the event and its new key
     */
    @WebMethod
    public void modifyEventName(
        @WebParam(name="oldName") String oldName, 
        @WebParam(name="newName") String newName
    ) {
        Event event = getEventsInstance().get(oldName);
        event.setName(newName);
        getEventsInstance().remove(oldName);
        getEventsInstance().put(newName, event);
    }

    /**
     * Modifies type of the event
     * @param type is the new type of the event
     * @param name is the key to find the event
     */
    @WebMethod
    public void modifyEventType(
        @WebParam(name="eventType") EventType eventType, 
        @WebParam(name="name")      String name
    ) {
        getEventsInstance().get(name).setType(eventType);
    }

    /**
     * Modifies date of the event
     * @param date is the new date of the event
     * @param name is the key to find the event
     */
    @WebMethod
    public void modifyEventDate(
        @WebParam(name="date") Date date, 
        @WebParam(name="name") String name
    ) {
        getEventsInstance().get(name).setDate(date);
    }

    /**
     * Modifies description of the event
     * @param description is the new description of the event
     * @param name is the key to find the event
     */
    @WebMethod
    public void modifyEventDescription(
        @WebParam(name="description")   String description, 
        @WebParam(name="name")          String name
        ) {
        getEventsInstance().get(name).setDescription(description);
    }

    /**
     * @return MapWrapper<String, Event> with all events
     */
    @WebMethod 
    public MapWrapper<String, Event> getEvents() {
        return new MapWrapper<String, Event>(events);
    }
    
    /**
     * @param name is the key to find the event
     * @return String information about the specific event
     */
    @WebMethod 
    public String getEventInfo(@WebParam(name="name") String name) {
        return getEventsInstance().get(name).toString();
    }

    /**
     * @param date contains the day of the event and allows to find the events with the same day of the event
     * @return events planned in the same day as the date parameter
     */
    @WebMethod 
    public List<Event> getEventsByDay(@WebParam(name="date") Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        HashMap<String, Event> events = getEventsInstance();

        List<Event> eventsByDay = new ArrayList<>();
        for (HashMap.Entry<String, Event> entry : events.entrySet()) {
            Event value = entry.getValue();
            Calendar calendarEntry = new GregorianCalendar();
            calendarEntry.setTime(value.getDate());

            if (calendarEntry.get(Calendar.DAY_OF_YEAR) == calendar.get(Calendar.DAY_OF_YEAR)
            && calendarEntry.get(Calendar.MONTH) == calendar.get(Calendar.MONTH)
            && calendarEntry.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
                eventsByDay.add(value);
            }
        }

        return eventsByDay;
    }


    /**
     * @param date contains the week of the event and allows to find the events in the same week of the event
     * @return events planned in the same week as the date parameter 
     */
    @WebMethod 
    public List<Event> getEventsByWeek(@WebParam(name="date") Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        HashMap<String, Event> events = getEventsInstance();

        List<Event> eventsByWeek = new ArrayList<>();
        for (HashMap.Entry<String, Event> entry : events.entrySet()) {
            Event value = entry.getValue();
            Calendar calendarEntry = new GregorianCalendar();
            calendarEntry.setTime(value.getDate());

            if (calendarEntry.get(Calendar.WEEK_OF_YEAR) == calendar.get(Calendar.WEEK_OF_YEAR)) {
                eventsByWeek.add(value);
            }
        }

        return eventsByWeek;
    }

    @WebMethod                                                          
    public byte[] generatePdf() throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
 
        PdfPTable table = new PdfPTable(5);
        addTableHeader(table);
        addRows(table);

        document.add(table);
        document.close();
        return baos.toByteArray();
    }
   
    private void addTableHeader(PdfPTable table) {
        String[] columnTitle = {"Name", "Type", "Date", "Description"};
        for (int i = 0; i < columnTitle.length; i++) {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle[i]));
            table.addCell(header);
        }
    }

    private void addRows(PdfPTable table) {
        HashMap<String, Event> events = getEventsInstance();
        for (HashMap.Entry<String, Event> entry : events.entrySet()) {
            table.addCell(entry.getValue().getName());
            table.addCell(entry.getValue().getType() + "");
            table.addCell(entry.getValue().getDate() + "");
            table.addCell(entry.getValue().getDescription());
        }
    }

}