import java.util.ArrayList;

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

    public ArrayList<Swim> sortFastToSlow(){
        ArrayList<Swim> orderedList = new ArrayList<Swim>();
        ArrayList<Swim> cloneList = (ArrayList<Swim>)swimHistory.clone();
        
        while (cloneList.size() > 0) {
            double fastestTime = 100000000;
            Swim fastestSwim = null;

            for (Swim s: cloneList){
                if (s.getTime() < fastestTime){
                    fastestTime = s.getTime();
                    fastestSwim = s;
                }
            }   
            orderedList.add(fastestSwim);
            cloneList.remove(fastestSwim);
        }

        return orderedList;
    }

    public String getAgeGroup(){
        if (getAge() <= 10){
            return "10 and under";
        }
        else if (getAge() == 11 || getAge() == 12){
            return "11-12";
        }
        else if (getAge() == 13 || getAge() == 14){
            return "13-14";
        }
        else if (getAge() == 15 || getAge() == 16){
            return "15-16";
        }
        else if (getAge() == 17 || getAge() == 18){
            return "17-18";
        }
        else{
            return "Over 18";
        }
    }

    // Considered for pro program
    public boolean proPotential() {
        SwimEvent fav = getFavEvent();
        Swim fastest = getFastestSwim(fav);
        int age = getAge();
    
        double benchmark = 0.0;
    
        if (fav == SwimEvent.Freestyle_100) {
            if (age <= 18) {
                benchmark = 51.0 + (18 - age); // More lenient for younger swimmers
            } else {
                benchmark = 50.0; // Stricter for older swimmers
            }
        } else if (fav == SwimEvent.Freestyle_200) {
            if (age <= 18) {
                benchmark = 112.0 + (18 - age); // ~1:52 base plus buffer
            } else {
                benchmark = 111.0; // Stricter for older swimmers
            }
        } else {
            return false; // Not applicable for other events
        }
    
        return fastest.getTime() <= benchmark;
    }
    

    public String toString(){
        return "ID: " + swimmerID + " | " + getFirstName() + " " + getLastName() + " | Age: " + getAge() 
        + " | Gender: " + getGender() + " | Nationality: " + getCountry() + " | Favourite Event: " + favEvent 
        + " | Fastest Swim: " + getFastestSwim(favEvent);
    }
}
