public class SwimInfo {
    
    private int swimmerID;
    private SwimEvent event;
    private String date;
    private double time;

    public SwimInfo(int swimmerID, SwimEvent event, String date, double time){
        
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
}
