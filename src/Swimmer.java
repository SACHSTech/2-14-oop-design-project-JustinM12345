import java.util.ArrayList;
import java.util.List;
public class Swimmer extends Person{

    private int swimmerID;
    private SwimEvent favEvent;
    private ArrayList<Swim> swimHistory;

    public Swimmer(int swimmerID, String firstName, String lastName, String gender, int birthYear, int height, String country, SwimEvent favEvent){
        super(firstName, lastName, gender, birthYear, height, country);
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
                if (fastestSwim == null || s.getTime() < fastestSwim.getTime()){
                    fastestSwim = s;
                }
            }
        }
        return fastestSwim;
    }

    // public ArrayList<Swim> sortFastToSlow(){
    //     ArrayList<Swim> fastToSlow = new ArrayList<Swim>();
    //     ArrayList copyArray = (ArrayList)swimHistory.clone(); 
    // }

    // public ageGroup getAgeGroup(){
    //     return null;
    // }

    // isSwimmingFavourite

    // Considered for pro program

    public String toString(){
        return "ID: " + swimmerID + " | " + getFirstName() + " " + getLastName() + " | Age: " + getAge() 
        + " | Gender: " + getGender() + " | Nationality: " + getCountry() + " | Favourite Event: " + favEvent 
        + " | Fastest Swim: " + getFastestSwim(favEvent);
    }
}
