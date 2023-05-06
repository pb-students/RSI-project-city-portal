package net.wvffle.rsi.client;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.bind.DatatypeConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.soap.MTOMFeature;


import net.wvffle.rsi.client.generated.CityInformation;
import net.wvffle.rsi.client.generated.CityInformationService;
import net.wvffle.rsi.client.generated.DocumentException_Exception;
import net.wvffle.rsi.client.generated.Event;
import net.wvffle.rsi.client.generated.SQLException_Exception;


public class Main {
    private static final String WS_URL = "https://wsdl--main--project-rsi--siwykot41.code.wvffle.net/RSI/CityInformationService?wsdl"; 

    public static void main(String[] args) throws DatatypeConfigurationException, DocumentException_Exception, SQLException_Exception  {
        // CityInformationService service  = new CityInformationService();

        // CityInformation port = service.getCityInformationPort(new MTOMFeature());
        // GregorianCalendar calendar = new GregorianCalendar();

        // //miesiące liczone są od zera
        // calendar.set(2000, 9, 28);
        // XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar); 
        // port.addEvent("Darmowa pizza", "Patry", date, "Targi pracy na pb");

        // calendar.set(2000, 2, 3);
        // date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar); 
        // port.addEvent("Spotkanie", "Party", date, "Rodzinny festyn na rynku");

        // calendar.set(2000, 2, 2);
        // date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar); 
        // port.addEvent("Krzysztof Krawczyk - GWINT", "Concert", date, "Koncert Krzysztofa Krawczyka w klubie GWINT");
        
        // printEvents(port.getEventsByWeek(date));
        // printEvents(port.getEventsByDay(date));
        // System.out.println("------------");
        // port.modifyEventName("Krzysztof Krawczyk - GWINT", "Filip Rutkowski - GWINT");
        // System.out.println("------------");
        // printEvents(port.getEventsByWeek(date));

        // calendar.set(2000, 2, 17);
        // date = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar); 
        // port.modifyEventDate(date, "Filip Rutkowski - GWINT");
        // System.out.println("------------");
        // printEvents(port.getEventsByWeek(date));


        // port.modifyEventDescription("Koncert Filipa na nervach", "Filip Rutkowski - GWINT");
        // System.out.println("------------");
        // printEvents(port.getEventsByWeek(date));

        // // port.modifyEventType(EventType.PARTY, "Filip Rutkowski - GWINT");
        // System.out.println("------------");
        // printEvents(port.getEventsByWeek(date));

        // byte[] pdfBytes = port.generatePdf();
        // savePdf(pdfBytes);
        // System.out.println("cityinformationServer.generatePdf() : Download Successful");
    }

    // Save the imageBytes as pdf file to the local disk
    public static void savePdf(byte[] pdfBytes) {
        String pdfString = DatatypeConverter.printBase64Binary(pdfBytes);
        String pdfStringWithHeader = "data:image/jpg;base64," + pdfString;
        String pdfStringWithoutHeader = pdfStringWithHeader.substring(pdfStringWithHeader.indexOf(",") + 1);
        byte[] pdfBytesWithoutHeader = DatatypeConverter.parseBase64Binary(pdfStringWithoutHeader);
        try {
            java.io.FileOutputStream fos = new java.io.FileOutputStream("bialystok-events.pdf");
            fos.write(pdfBytesWithoutHeader);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String eventToString(Event event) {
        return "Nazwa: " + event.getName() + " Typ: " 
        + event.getType() + " Data: " + event.getDate() 
        + " Description: " + event.getDescription();
    }

    public static void printEvents(List<Event> events) {
        for (int i = 0; i < events.size(); i++) {
            System.out.println(eventToString(events.get(i)));
        }
    }

    public static List<String> eventToStrings(List<Event> events) {
        List<String> eventsStrings = new ArrayList<String>();
        for (int i = 0; i < events.size(); i++) {
            eventsStrings.add(eventToString(events.get(i)));
        }

        return eventsStrings;
    }
}