import java.util.ArrayList;

/**
 * Represents a swimmer, extending the Person class, with additional attributes such as a unique swimmer ID,
 * favorite swimming event, and a history of recorded swims.
 * 
 * Provides methods to manage swims, retrieve fastest performances, and determine professional potential based on a benchmark.
 * 
 * @author Justin M
 */
public class Swimmer extends Person{

    private int swimmerID;
    private SwimEvent favEvent;
    private ArrayList<Swim> swimHistory;

    /**
     * Constructs a Swimmer object
     *
     * @param swimmerID the unique ID of the swimmer
     * @param firstName the swimmer's first name
     * @param lastName the swimmer's last name
     * @param gender the swimmer's gender
     * @param birthYear the swimmer's year of birth
     * @param height the swimmer's height in centimeters
     * @param country the swimmer's country of origin
     * @param favEvent the swimmer's favorite swim event
     */
    public Swimmer(int swimmerID, String firstName, String lastName, String gender, int birthYear, int height, String country, SwimEvent favEvent){
        super(firstName, lastName, gender, birthYear, height, country);
        this.swimmerID = swimmerID;
        this.favEvent = favEvent;
        
        swimHistory = new ArrayList<Swim>();
    }

    /**
     * Adds a swim to the swimmer's history.
     *
     * @param swim the Swim object to add
     */
    public void addSwim(Swim swim) {
        swimHistory.add(swim);
    }

    /**
     * Returns the swimmer's unique ID.
     *
     * @return swimmer ID
     */
    public int getID() {
        return swimmerID;
    }

    /**
     * Returns the swimmer's favorite swim event.
     *
     * @return favorite event
     */
    public SwimEvent getFavEvent() {
        return favEvent;
    }

    /**
     * Returns a list of all swims recorded for the swimmer.
     *
     * @return list of Swim objects
     */
    public ArrayList<Swim> getSwims() {
        return swimHistory;
    }

    /**
     * Returns the fastest swim for a specified event.
     *
     * @param event the SwimEvent to search for
     * @return the Swim with the fastest time in the given event, or null if no such swim exists
     */
    public Swim getFastestSwim(SwimEvent event) {
        Swim fastestSwim = null;
        for (Swim s : swimHistory) {
            if (s.getEvent().equals(event)) {
                if (fastestSwim == null || s.getTime() < fastestSwim.getTime()) {
                    fastestSwim = s;
                }
            }
        }
        return fastestSwim;
    }

    /**
     * Sorts and returns the swimmer's swim history from fastest to slowest time.
     *
     * @return ordered list of Swim objects
     */
    public ArrayList<Swim> sortFastToSlow() {
        ArrayList<Swim> orderedList = new ArrayList<>();
        ArrayList<Swim> cloneList = (ArrayList<Swim>) swimHistory.clone();

        while (!cloneList.isEmpty()) {
            double fastestTime = 100000000;
            Swim fastestSwim = null;

            for (Swim s : cloneList) {
                if (s.getTime() < fastestTime) {
                    fastestTime = s.getTime();
                    fastestSwim = s;
                }
            }
            orderedList.add(fastestSwim);
            cloneList.remove(fastestSwim);
        }

        return orderedList;
    }

    /**
     * Determines the swimmer's age group category based on their age.
     *
     * @return the swimmer's age group as a string
     */
    public String getAgeGroup() {
        if (getAge() <= 10) {
            return "10 and under";
        } else if (getAge() == 11 || getAge() == 12) {
            return "11-12";
        } else if (getAge() == 13 || getAge() == 14) {
            return "13-14";
        } else if (getAge() == 15 || getAge() == 16) {
            return "15-16";
        } else if (getAge() == 17 || getAge() == 18) {
            return "17-18";
        } else {
            return "Over 18";
        }
    }

    /**
     * Evaluates the swimmer's potential to qualify for a professional program based on age and fastest time
     * in their favorite event.
     *
     * @return "Yes", "Slightly Possible", or "Highly Unlikely" depending on performance
     */
    public String proPotential() {
        SwimEvent fav = getFavEvent();
        Swim fastest = getFastestSwim(fav);
        int age = getAge();
        double benchmark = 0.0;

        if (fav == SwimEvent.Freestyle_100) {
            benchmark = (age <= 18) ? 51.0 + (18 - age) : 50.0;
        } else if (fav == SwimEvent.Freestyle_200) {
            benchmark = (age <= 18) ? 112.0 + (18 - age) : 111.0;
        } else {
            return "Currently don't have other events as it will become too cluttered";
        }

        if (fastest.getTime() <= benchmark) {
            return "Yes";
        } else if (fastest.getTime() - 2 <= benchmark) {
            return "Slightly Possible";
        } else {
            return "Highly Unlikely";
        }
    }

    /**
     * Returns a string with info of the swimmer, including personal and competitive details.
     *
     * @return formatted string with swimmer information
     */
    public String toString() {
        return "ID: " + swimmerID + " | " + getFirstName() + " " + getLastName() + " | Age: " + getAge() 
            + " | Gender: " + getGender() + " | Nationality: " + getCountry() + " | Favourite Event: " + favEvent;
    }
}