
package net.wvffle.rsi.client.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="eventType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Concert"/>
 *     &lt;enumeration value="Sport"/>
 *     &lt;enumeration value="Picnic"/>
 *     &lt;enumeration value="Workshop"/>
 *     &lt;enumeration value="Conference"/>
 *     &lt;enumeration value="Party"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "eventType")
@XmlEnum
public enum EventType {

    @XmlEnumValue("Concert")
    CONCERT("Concert"),
    @XmlEnumValue("Sport")
    SPORT("Sport"),
    @XmlEnumValue("Picnic")
    PICNIC("Picnic"),
    @XmlEnumValue("Workshop")
    WORKSHOP("Workshop"),
    @XmlEnumValue("Conference")
    CONFERENCE("Conference"),
    @XmlEnumValue("Party")
    PARTY("Party");
    private final String value;

    EventType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EventType fromValue(String v) {
        for (EventType c: EventType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
