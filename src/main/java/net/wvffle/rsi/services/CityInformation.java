package net.wvffle.rsi.services;

// import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.MTOM;
import javax.xml.ws.soap.SOAPBinding;

// import com.itextpdf.text.BaseColor;
// import com.itextpdf.text.Document;
// import com.itextpdf.text.DocumentException;
// import com.itextpdf.text.Phrase;
// import com.itextpdf.text.pdf.PdfPCell;
// import com.itextpdf.text.pdf.PdfPTable;
// import com.itextpdf.text.pdf.PdfWriter;

import net.wvffle.rsi.cityevent.Event;
import net.wvffle.rsi.cityevent.EventType;

@MTOM
@WebService
@BindingType(value = SOAPBinding.SOAP11HTTP_BINDING)
public class CityInformation {
    private HashMap<String, Event> events = new HashMap<>();

    @WebMethod
    public void addEvent(String name, EventType type, Date date, String description) {
        events.put(name, new Event(name, type, date, description));
    }

    @WebMethod
    public void modifyEventName(String oldName, String newName) {
        Event event = events.get(oldName);
        event.setName(newName);
        events.remove(oldName);
        events.put(newName, event);
    }

    @WebMethod
    public void modifyEventType(EventType eventType, String name) {
        events.get(name).setType(eventType);
    }

    @WebMethod
    public void modifyEventDate(Date date, String name) {
        events.get(name).setDate(date);
    }

    @WebMethod
    public void modifyEventDescription(String description, String name) {
        events.get(name).setDescription(description);
    }

    @WebMethod 
    public HashMap<String, Event> getEvents() {
        return events;
    }
    
    @WebMethod 
    public String getEventInfo(String name) {
        return events.get(name).toString();
    }

    @WebMethod 
    public List<Event> getEventsByDay(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

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

    @WebMethod 
    public List<Event> getEventsByWeek(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

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

    // @WebMethod                                                          
    // public byte[] generatePdf() throws DocumentException {
    //     Document document = new Document();
    //     ByteArrayOutputStream baos = new ByteArrayOutputStream();
    //     PdfWriter.getInstance(document, baos);
 
    //     document.open();
 
    //     PdfPTable table = new PdfPTable(5);
    //     addTableHeader(table);
    //     addRows(table);

    //     document.add(table);
    //     document.close();
    //     return baos.toByteArray();
    // }
   
    // @WebMethod                                                          
    // private void addTableHeader(PdfPTable table) {
    //     String[] columnTitle = {"Name", "Type", "Date", "Description"};
    //     for (int i = 0; i < columnTitle.length; i++) {
    //         PdfPCell header = new PdfPCell();
    //         header.setBackgroundColor(BaseColor.LIGHT_GRAY);
    //         header.setBorderWidth(2);
    //         header.setPhrase(new Phrase(columnTitle[i]));
    //         table.addCell(header);
    //     }
    // }

    // @WebMethod                                                          
    // private void addRows(PdfPTable table) {
    //     for (HashMap.Entry<String, Event> entry : events.entrySet()) {
    //         table.addCell(entry.getValue().getName());
    //         table.addCell(entry.getValue().getType() + "");
    //         table.addCell(entry.getValue().getDate() + "");
    //         table.addCell(entry.getValue().getDescription());
    //     }
    // }
}