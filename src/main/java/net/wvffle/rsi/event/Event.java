package net.wvffle.rsi.event;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@DatabaseTable(tableName = "events")
public class Event {
    /**
     * ID of the event
     */
    @DatabaseField(generatedId = true)
    private long id;

    /**
     * Name of the event
     */
    @NonNull
    @DatabaseField(canBeNull = false)
    private String name;

    /**
     * Type of the event
     */
    @NonNull
    @DatabaseField(canBeNull = false)
    private String type;

    /**
     * Date of the event
     */
    @NonNull
    @DatabaseField(canBeNull = false, dataType = DataType.DATE_LONG)
    private Date date;

    /**
     * Description of the event
     */
    @NonNull
    @DatabaseField(canBeNull = false)
    private String description;
}
