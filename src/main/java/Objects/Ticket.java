package Objects;

public class Ticket {

    private int ticketId;
    private int eventId;
    private int userId;
    private String eventName;

    public Ticket(int id, int eventId, int userId, String eventName) {
        this.ticketId = id;
        this.eventId = eventId;
        this.userId = userId;
        this.eventName = eventName;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}
