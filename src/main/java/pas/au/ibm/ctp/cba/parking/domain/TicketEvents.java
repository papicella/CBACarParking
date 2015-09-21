package pas.au.ibm.ctp.cba.parking.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TicketEvents
{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;

    private Long userId;
    private String eventName;

    @Temporal(TemporalType.DATE)
    private Date eventDate;

    private String standium;
    private String location;

    public TicketEvents() {
    }

    public TicketEvents(Date eventDate, String eventName, String location, String standium, Long userId) {
        this.eventDate = eventDate;
        this.eventName = eventName;
        this.location = location;
        this.standium = standium;
        this.userId = userId;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStandium() {
        return standium;
    }

    public void setStandium(String standium) {
        this.standium = standium;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TicketEvents{" +
                "eventDate=" + eventDate +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", eventName='" + eventName + '\'' +
                ", standium='" + standium + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
