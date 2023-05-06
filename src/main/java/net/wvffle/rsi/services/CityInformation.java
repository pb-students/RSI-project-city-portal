package net.wvffle.rsi.services;

import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;

import net.wvffle.rsi.event.Event;

@MTOM
@WebService
@BindingType(value = SOAPBinding.SOAP11HTTP_BINDING)
public class CityInformation {
    
    private static JdbcPooledConnectionSource connectionSource;
    private static Dao<Event, Long> eventDao;

    public CityInformation() {
        try {
            connectionSource = new JdbcPooledConnectionSource("jdbc:sqlite:/home/coder/workspace/database.db");
            TableUtils.createTableIfNotExists(connectionSource, Event.class);
            eventDao = DaoManager.createDao(connectionSource, Event.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create new event
     * @param name is the name of the event
     * @param type is the type of the event
     * @param date is the date of the event
     * @param description description of the event
     * @return the new event
     */
    @WebMethod
    public Event addEvent(
        @WebParam(name="name")          String name, 
        @WebParam(name="type")          String type, 
        @WebParam(name="date")          Date date, 
        @WebParam(name="description")   String description
    ) throws SQLException {
        Event event = new Event(name, type, date, description);
        eventDao.create(event);
        return event;
    }

    /**
     * Update an event
     * @param id is the id of the event
     * @param name is the name of the event
     * @param type is the type of the event
     * @param date is the date of the event
     * @param description is the description of the event
     * @return the updated event
     */
    @WebMethod
    public Event updateEvent(
        @WebParam(name="id")            long id, 
        @WebParam(name="name")          String name, 
        @WebParam(name="type")          String type, 
        @WebParam(name="date")          Date date, 
        @WebParam(name="description")   String description
    ) throws SQLException {
        Event event = eventDao.queryForId(id);

        event.setName(name);
        event.setType(type);
        event.setDate(date);
        event.setDescription(description);

        eventDao.update(event);

        return event;
    }

    /**
     * Delete an event
     * @param id is the id of the event
     */
    @WebMethod
    public void deleteEvent(@WebParam(name="id") long id) throws SQLException {
        eventDao.deleteById(id);
    }

    /**
     * Get all events sorted by date
     * @return all events
     */
    @WebMethod
    public List<Event> getAllEvents() throws SQLException {
        return eventDao.queryBuilder().orderBy("date", false).query();
    }

    /**
     * Get all events for a specific day
     */
    @WebMethod
    public List<Event> getEventsForDay(@WebParam(name="date") Date date) throws SQLException {
        return eventDao.queryBuilder().where().eq("date", date).query();
    }

    /**
     * Get all events for a specific month
     */
    @WebMethod
    public List<Event> getEventsForMonth(@WebParam(name="date") Date date) throws SQLException {
        // TODO (siwykot41): Dodaj logike, uzywamy ORMLite
        return eventDao.queryBuilder().query();
    }

    /**
     * Generates pdf and inserts all the events into the table 
     * @return pdf as byte array
     */
    @WebMethod                                                          
    public byte[] generatePdf() throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);
        document.open();
 
        PdfPTable table = new PdfPTable(4);
        addTableHeader(table);
        addRows(table);

        document.add(table);
        document.close();
        return baos.toByteArray();
    }
   
    private void addTableHeader(PdfPTable table) {
        String[] columnTitle = {"Name", "Type", "Calendar", "Description"};
        for (int i = 0; i < columnTitle.length; i++) {
            PdfPCell header = new PdfPCell();
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setBorderWidth(2);
            header.setPhrase(new Phrase(columnTitle[i]));
            table.addCell(header);
        }
    }

    private void addRows(PdfPTable table) {
        try {
            for (Event event : getAllEvents()) {
                table.addCell(event.getName());
                table.addCell(event.getType());
                table.addCell(event.getDate().toString());
                table.addCell(event.getDescription());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}