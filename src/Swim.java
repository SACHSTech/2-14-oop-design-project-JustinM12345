public class Swim {
    
    private int swimmerID;
    private SwimEvent event;
    private String date;
    private double time;

    public Swim(int swimmerID, SwimEvent event, String date, double time){
        
        this.swimmerID = swimmerID;
        this.event = event;
        this.date = date;
        this.time = time;

    }

    public int getID(){
        return swimmerID;
    }

    public SwimEvent getEvent(){
        return event;
    }

    public String getDate(){
        return date;
    }

    public double getTime(){
        return time;
    }

    public String getFormattedTime(){
        return TimeConverter.convertTime(time);
    }

    public String toString(){
        return "ID: " + swimmerID + " | Time: " + TimeConverter.convertTime(time);
        
    }
}
