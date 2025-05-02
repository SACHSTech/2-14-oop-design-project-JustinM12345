import java.util.ArrayList;

public class Event {
    
    private SwimEvent eventType;
    private String gender;
    private ArrayList<Swimmer> swimmers;
    private String eventName;

    public Event (SwimEvent eventType, String gender){
        if (eventType.equals(SwimEvent.Freestyle_100)){
            this.eventName = "100m Freestyle";
        }
        else if (eventType.equals(SwimEvent.Freestyle_200)){
            this.eventName = "200m Freestyle";
        }
        else{
            //System.out.println("Will add all events another time, do not want to clutter this with so many events");
        }
        this.eventType = eventType;
        if (gender.equals("Male")){
            this.gender = "Mens";
        }
        else if (gender.equals("Female")){
            this.gender = "Womens";
        }

        swimmers = new ArrayList<Swimmer>();
    }

    public void addSwimmer(Swimmer s){
        swimmers.add(s);
    }

    public SwimEvent getEvent(){
        return eventType;
    }

    public String getGender(){
        return gender;
    }

    public ArrayList<Swimmer> getSwimmers(){
        return swimmers;
    }

    public void listSwimmers(){
        for (Swimmer s: swimmers){
            System.out.println(s);
        }
    }

    public ArrayList<Swimmer> listFastestToSlowest(){
        ArrayList<Swimmer> cloneList = (ArrayList<Swimmer>)swimmers.clone();
        ArrayList<Swimmer> orderedList = new ArrayList<Swimmer>();
        while (cloneList.size() > 0) {
            double fastestTime = 100000000;
            Swimmer fastestSwimmer = null;

            for (Swimmer s: cloneList){
                if (s.getFastestSwim(eventType).getTime() < fastestTime){
                    fastestTime = s.getFastestSwim(eventType).getTime();
                    fastestSwimmer = s;
                }
            }   
            orderedList.add(fastestSwimmer);
            cloneList.remove(fastestSwimmer);
        }

        return orderedList;
    }

    public void createHeatSheet(){
        ArrayList<Swimmer> orderedList = listFastestToSlowest();
        int i = 1;

        System.out.println("HEAT SHEET");
        System.out.println(gender + " " + eventName);
        System.out.printf("%-6s %-25s %-15s%n", "RANK", "ATHLETE", "SEED TIME");
        System.out.println("-----------------------------------------------------");

        for (Swimmer s : orderedList) {
            System.out.printf("%-6d %-25s %-15s%n", 
                            i, 
                            s.getName(), 
                            s.getFastestSwim(eventType).getFormattedTime());
            i++;
        }
    }

    public String toString(){
        return gender + " " + eventName;
    }


}
