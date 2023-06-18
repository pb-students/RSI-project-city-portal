package net.wvffle.rsi.services;

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
import java.io.ByteArrayOutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import net.wvffle.rsi.event.Event;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

@Path("/")
@BindingType(value = SOAPBinding.SOAP11HTTP_BINDING)
public class CityInformation {

    private static JdbcPooledConnectionSource connectionSource;
    private static Dao<Event, Long> eventDao;

    public CityInformation() {
        try {
            connectionSource = new JdbcPooledConnectionSource(
                    "jdbc:sqlite:/home/coder/workspace/database.db");
            TableUtils.createTableIfNotExists(connectionSource, Event.class);
            eventDao = DaoManager.createDao(connectionSource, Event.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Create new event
     *
     * @param name        is the name of the event
     * @param type        is the type of the event
     * @param date        is the date of the event
     * @param description description of the event
     * @return the new event
     */
    @POST
    @Path("/events")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Event addEvent(Event event) throws SQLException {
        eventDao.create(event);
        return event;
    }

    /**
     * Update an event
     *
     * @param id          is the id of the event
     * @param name        is the name of the event
     * @param type        is the type of the event
     * @param date        is the date of the event
     * @param description is the description of the event
     * @return the updated event
     */
    @POST
    @Path("/events/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Event updateEvennt(@PathParam("id") long id, Event event)
            throws SQLException {
        Event originalEvent = eventDao.queryForId(id);

        originalEvent.setName(event.getName());
        originalEvent.setType(event.getType());
        originalEvent.setDate(event.getDate());
        originalEvent.setDescription(event.getDescription());

        eventDao.update(originalEvent);
        return originalEvent;
    }

    /**
     * Delete an event
     *
     * @param id is the id of the event
     */
    @DELETE
    @Path("/events/{id}")
    public void deleteEvent(@PathParam("id") long id) throws SQLException {
        eventDao.deleteById(id);
    }

    /**
     * Get an event by id
     *
     * @param id is the id of the event
     * @return the event
     */
    @GET
    @Path("/events/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Event getEventById(@PathParam("id") long id) throws SQLException {
        return eventDao.queryForId(id);
    }

    /**
     * Get all events sorted by date
     *
     * @return all events
     */
    @GET
    @Path("/events")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getAllEvents() throws SQLException {
        return eventDao.queryBuilder().orderBy("date", false).query();
    }

    /**
     * Get paginated events
     */
    @GET
    @Path("/events/by/page/{page}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getPaginatedEvents(@PathParam("page") long page)
            throws SQLException {
        return eventDao.queryBuilder()
                .orderBy("date", false)
                .limit(10L)
                .offset((page - 1) * 10)
                .query();
    }
    
    /**
     * Get all events for a specific day
     * @throws ParseException
     */
    @GET
    @Path("/events/by/day/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsForDay(@PathParam("date") String date)
            throws SQLException, ParseException {

        Date day = new DateTime(date).toDate();
        return eventDao.queryBuilder().where().eq("date", day).query();
    }

    /**
     * Get all events for a specific week
     * @throws ParseException
     */
    @GET
    @Path("/events/by/week/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Event> getEventsForWeek(@PathParam("date") String date)
            throws SQLException, ParseException {
        Date from = new DateTime(date).withDayOfWeek(DateTimeConstants.MONDAY).toDate();
        Date to = new DateTime(date).withDayOfWeek(DateTimeConstants.SUNDAY).toDate();

        return eventDao.queryBuilder()
                .orderBy("date", false)
                .where()
                .between("date", from, to)
                .query();
    }

    /**
     * Generates pdf and inserts all the events into the table
     *
     * @return pdf as byte array
     */
    @GET
    @Path("/pdf")
    @Produces("application/pdf")
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
        String[] columnTitle = { "Name", "Type", "Calendar", "Description" };
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
