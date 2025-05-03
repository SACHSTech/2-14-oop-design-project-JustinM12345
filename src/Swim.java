/**
 * Represents a single swim performance by a swimmer, including details such as
 * the swimmer's ID, the event, the date it occurred, and the time recorded.
 * 
 * Provides methods to retrieve raw and formatted data about the swim.
 * 
 * This class is used to track a swimmer's history of performances.
 * 
 * @author Justin M
 */
public class Swim {
    
    private int swimmerID;
    private SwimEvent event;
    private String date;
    private double time;

    /**
     * Constructs a Swim object with the specified swimmer ID, event, date, and time.
     *
     * @param swimmerID the ID of the swimmer who performed the swim
     * @param event the event type of the swim (e.g. Freestyle_100)
     * @param date the date the swim was performed (format: yyyy-mm-dd)
     * @param time the time achieved in seconds
     */
    public Swim(int swimmerID, SwimEvent event, String date, double time){
        this.swimmerID = swimmerID;
        this.event = event;
        this.date = date;
        this.time = time;
    }

    /**
     * Returns the swimmer's ID associated with this swim.
     *
     * @return the swimmer ID
     */
    public int getID(){
        return swimmerID;
    }

    /**
     * Returns the event in which the swim took place.
     *
     * @return the swim event
     */
    public SwimEvent getEvent(){
        return event;
    }

    /**
     * Returns the date the swim occurred.
     *
     * @return the swim date in yyyy-mm-dd format
     */
    public String getDate(){
        return date;
    }

    /**
     * Returns the time of the swim in seconds.
     *
     * @return the swim time in seconds
     */
    public double getTime(){
        return time;
    }

    /**
     * Returns the swim time in a formatted string (e.g. 1:05.32).
     *
     * @return formatted swim time
     */
    public String getFormattedTime(){
        return TimeConverter.convertTime(time);
    }

    /**
     * Returns a string with info of the swim, including event name, date, and formatted time.
     *
     * @return string describing the swim
     */
    public String toString(){
        return "Event: " + event + " | Date Swum: " + date + " | Time: " + TimeConverter.convertTime(time);
    }
}