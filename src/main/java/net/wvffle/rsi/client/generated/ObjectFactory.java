
package net.wvffle.rsi.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.wvffle.rsi.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteEvent_QNAME = new QName("http://services.rsi.wvffle.net/", "deleteEvent");
    private final static QName _GetEventsForMonth_QNAME = new QName("http://services.rsi.wvffle.net/", "getEventsForMonth");
    private final static QName _DeleteEventResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "deleteEventResponse");
    private final static QName _UpdateEventResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "updateEventResponse");
    private final static QName _GetEventsForDayResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "getEventsForDayResponse");
    private final static QName _AddEvent_QNAME = new QName("http://services.rsi.wvffle.net/", "addEvent");
    private final static QName _DocumentException_QNAME = new QName("http://services.rsi.wvffle.net/", "DocumentException");
    private final static QName _AddEventResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "addEventResponse");
    private final static QName _UpdateEvent_QNAME = new QName("http://services.rsi.wvffle.net/", "updateEvent");
    private final static QName _GeneratePdfResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "generatePdfResponse");
    private final static QName _GetEventsForMonthResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "getEventsForMonthResponse");
    private final static QName _GetAllEventsResponse_QNAME = new QName("http://services.rsi.wvffle.net/", "getAllEventsResponse");
    private final static QName _GetEventsForDay_QNAME = new QName("http://services.rsi.wvffle.net/", "getEventsForDay");
    private final static QName _GetAllEvents_QNAME = new QName("http://services.rsi.wvffle.net/", "getAllEvents");
    private final static QName _GeneratePdf_QNAME = new QName("http://services.rsi.wvffle.net/", "generatePdf");
    private final static QName _SQLException_QNAME = new QName("http://services.rsi.wvffle.net/", "SQLException");
    private final static QName _GeneratePdfResponseReturn_QNAME = new QName("", "return");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.wvffle.rsi.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SQLException }
     * 
     */
    public SQLException createSQLException() {
        return new SQLException();
    }

    /**
     * Create an instance of {@link GeneratePdf }
     * 
     */
    public GeneratePdf createGeneratePdf() {
        return new GeneratePdf();
    }

    /**
     * Create an instance of {@link GeneratePdfResponse }
     * 
     */
    public GeneratePdfResponse createGeneratePdfResponse() {
        return new GeneratePdfResponse();
    }

    /**
     * Create an instance of {@link GetEventsForMonthResponse }
     * 
     */
    public GetEventsForMonthResponse createGetEventsForMonthResponse() {
        return new GetEventsForMonthResponse();
    }

    /**
     * Create an instance of {@link GetAllEvents }
     * 
     */
    public GetAllEvents createGetAllEvents() {
        return new GetAllEvents();
    }

    /**
     * Create an instance of {@link GetAllEventsResponse }
     * 
     */
    public GetAllEventsResponse createGetAllEventsResponse() {
        return new GetAllEventsResponse();
    }

    /**
     * Create an instance of {@link GetEventsForDay }
     * 
     */
    public GetEventsForDay createGetEventsForDay() {
        return new GetEventsForDay();
    }

    /**
     * Create an instance of {@link AddEvent }
     * 
     */
    public AddEvent createAddEvent() {
        return new AddEvent();
    }

    /**
     * Create an instance of {@link GetEventsForDayResponse }
     * 
     */
    public GetEventsForDayResponse createGetEventsForDayResponse() {
        return new GetEventsForDayResponse();
    }

    /**
     * Create an instance of {@link UpdateEvent }
     * 
     */
    public UpdateEvent createUpdateEvent() {
        return new UpdateEvent();
    }

    /**
     * Create an instance of {@link DocumentException }
     * 
     */
    public DocumentException createDocumentException() {
        return new DocumentException();
    }

    /**
     * Create an instance of {@link AddEventResponse }
     * 
     */
    public AddEventResponse createAddEventResponse() {
        return new AddEventResponse();
    }

    /**
     * Create an instance of {@link DeleteEvent }
     * 
     */
    public DeleteEvent createDeleteEvent() {
        return new DeleteEvent();
    }

    /**
     * Create an instance of {@link GetEventsForMonth }
     * 
     */
    public GetEventsForMonth createGetEventsForMonth() {
        return new GetEventsForMonth();
    }

    /**
     * Create an instance of {@link DeleteEventResponse }
     * 
     */
    public DeleteEventResponse createDeleteEventResponse() {
        return new DeleteEventResponse();
    }

    /**
     * Create an instance of {@link UpdateEventResponse }
     * 
     */
    public UpdateEventResponse createUpdateEventResponse() {
        return new UpdateEventResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Throwable }
     * 
     */
    public Throwable createThrowable() {
        return new Throwable();
    }

    /**
     * Create an instance of {@link StackTraceElement }
     * 
     */
    public StackTraceElement createStackTraceElement() {
        return new StackTraceElement();
    }

    /**
     * Create an instance of {@link Event }
     * 
     */
    public Event createEvent() {
        return new Event();
    }

    /**
     * Create an instance of {@link SqlException }
     * 
     */
    public SqlException createSqlException() {
        return new SqlException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "deleteEvent")
    public JAXBElement<DeleteEvent> createDeleteEvent(DeleteEvent value) {
        return new JAXBElement<DeleteEvent>(_DeleteEvent_QNAME, DeleteEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsForMonth }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "getEventsForMonth")
    public JAXBElement<GetEventsForMonth> createGetEventsForMonth(GetEventsForMonth value) {
        return new JAXBElement<GetEventsForMonth>(_GetEventsForMonth_QNAME, GetEventsForMonth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "deleteEventResponse")
    public JAXBElement<DeleteEventResponse> createDeleteEventResponse(DeleteEventResponse value) {
        return new JAXBElement<DeleteEventResponse>(_DeleteEventResponse_QNAME, DeleteEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "updateEventResponse")
    public JAXBElement<UpdateEventResponse> createUpdateEventResponse(UpdateEventResponse value) {
        return new JAXBElement<UpdateEventResponse>(_UpdateEventResponse_QNAME, UpdateEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsForDayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "getEventsForDayResponse")
    public JAXBElement<GetEventsForDayResponse> createGetEventsForDayResponse(GetEventsForDayResponse value) {
        return new JAXBElement<GetEventsForDayResponse>(_GetEventsForDayResponse_QNAME, GetEventsForDayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "addEvent")
    public JAXBElement<AddEvent> createAddEvent(AddEvent value) {
        return new JAXBElement<AddEvent>(_AddEvent_QNAME, AddEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "DocumentException")
    public JAXBElement<DocumentException> createDocumentException(DocumentException value) {
        return new JAXBElement<DocumentException>(_DocumentException_QNAME, DocumentException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEventResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "addEventResponse")
    public JAXBElement<AddEventResponse> createAddEventResponse(AddEventResponse value) {
        return new JAXBElement<AddEventResponse>(_AddEventResponse_QNAME, AddEventResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEvent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "updateEvent")
    public JAXBElement<UpdateEvent> createUpdateEvent(UpdateEvent value) {
        return new JAXBElement<UpdateEvent>(_UpdateEvent_QNAME, UpdateEvent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneratePdfResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "generatePdfResponse")
    public JAXBElement<GeneratePdfResponse> createGeneratePdfResponse(GeneratePdfResponse value) {
        return new JAXBElement<GeneratePdfResponse>(_GeneratePdfResponse_QNAME, GeneratePdfResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsForMonthResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "getEventsForMonthResponse")
    public JAXBElement<GetEventsForMonthResponse> createGetEventsForMonthResponse(GetEventsForMonthResponse value) {
        return new JAXBElement<GetEventsForMonthResponse>(_GetEventsForMonthResponse_QNAME, GetEventsForMonthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEventsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "getAllEventsResponse")
    public JAXBElement<GetAllEventsResponse> createGetAllEventsResponse(GetAllEventsResponse value) {
        return new JAXBElement<GetAllEventsResponse>(_GetAllEventsResponse_QNAME, GetAllEventsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEventsForDay }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "getEventsForDay")
    public JAXBElement<GetEventsForDay> createGetEventsForDay(GetEventsForDay value) {
        return new JAXBElement<GetEventsForDay>(_GetEventsForDay_QNAME, GetEventsForDay.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllEvents }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "getAllEvents")
    public JAXBElement<GetAllEvents> createGetAllEvents(GetAllEvents value) {
        return new JAXBElement<GetAllEvents>(_GetAllEvents_QNAME, GetAllEvents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneratePdf }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "generatePdf")
    public JAXBElement<GeneratePdf> createGeneratePdf(GeneratePdf value) {
        return new JAXBElement<GeneratePdf>(_GeneratePdf_QNAME, GeneratePdf.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SQLException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.rsi.wvffle.net/", name = "SQLException")
    public JAXBElement<SQLException> createSQLException(SQLException value) {
        return new JAXBElement<SQLException>(_SQLException_QNAME, SQLException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "return", scope = GeneratePdfResponse.class)
    public JAXBElement<byte[]> createGeneratePdfResponseReturn(byte[] value) {
        return new JAXBElement<byte[]>(_GeneratePdfResponseReturn_QNAME, byte[].class, GeneratePdfResponse.class, ((byte[]) value));
    }

}
