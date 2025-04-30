import java.util.ArrayList;

public class Event {
    
    private SwimEvent eventType;
    private ArrayList<Swimmer> swimmers;

    public Event (SwimEvent eventType){
        this.eventType = eventType;

        swimmers = new ArrayList<Swimmer>();
    }

    public void addSwimmer(Swimmer s){
        swimmers.add(s);
    }

    public SwimEvent getEvent(){
        return eventType;
    }

    public ArrayList<Swimmer> getSwimmers(){
        return swimmers;
    }

    public void listSwimmers(){
        for (Swimmer s: swimmers){
            System.out.println(s);
        }
    }
}
