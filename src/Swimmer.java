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

    public Swim getFastestSwim(SwimEvent event){
        Swim fastestSwim = null;
        for (Swim s: swimHistory){
            if (s.getEvent().equals(event)){
                if (s.getTime() < fastestSwim.getTime()){
                    fastestSwim = s;
                }
            }
        }
        return fastestSwim;
    }

    public ArrayList<Swim> sortFastToSlow(){
        ArrayList<Swim> fastToSlow = new ArrayList<Swim>();
        ArrayList copyArray = (ArrayList)swimHistory.clone(); 
    }

    public ageGroup getAgeGroup(){
        return null;
    }

    // isSwimmingFavourite

    // Considered for pro program

    
}
