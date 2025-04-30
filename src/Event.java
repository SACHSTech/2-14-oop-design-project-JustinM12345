import java.util.ArrayList;

public class Event {
    
    private String eventType;
    private String gender;
    private ArrayList<Swimmer> swimmers;

    public Event (SwimEvent eventType, String gender){
        if (eventType.equals(SwimEvent.Freestyle_100)){
            this.eventType = "100m Freestyle";
        }
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

    public String getEvent(){
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

    public String toString(){
        return gender + " " + eventType;
    }
}
