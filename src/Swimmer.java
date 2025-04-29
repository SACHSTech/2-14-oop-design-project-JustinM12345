import java.util.ArrayList;
import java.util.List;
public class Swimmer extends Person{

    private int swimmerID;
    private SwimEvent favEvent;
    private ArrayList<Swim> swimHistory;

    public Swimmer(String firstName, String lastName, String gender, int age, int height, String country, int swimmerID, SwimEvent favEvent){
        super(firstName, lastName, gender, age, height, country);
        this.swimmerID = swimmerID;
        this.favEvent = favEvent;
        
        swimHistory = new ArrayList<Swim>();
    }

    public void addSwim(Swim swim){
        swimHistory.add(swim);
    }

    public int getID(){
        return swimmerID;
    }

    public SwimEvent getFavEvent(){
        return favEvent;
    }

    


}
