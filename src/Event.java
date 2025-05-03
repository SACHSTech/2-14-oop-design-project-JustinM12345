import java.util.ArrayList;

/**
 * Represents a swimming event with a specific type and gender category.
 * 
 * Maintains a list of swimmers competing in the event, and provides utility
 * methods for managing participants and generating heat sheets.
 * 
 * @author Justin M
 */
public class Event {
    
    private SwimEvent eventType;
    private String gender;
    private ArrayList<Swimmer> swimmers;
    private String eventName;

    /**
     * Constructs an Event object with the given event type and gender.
     * Sets the display name of the event based on the type.
     *
     * @param eventType the type of swim event
     * @param gender the gender category (Male/Female)
     */
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

    /**
     * Adds a swimmer to the event.
     *
     * @param s the swimmer to add
     */
    public void addSwimmer(Swimmer s){
        swimmers.add(s);
    }

    /**
     * Returns the type of this swim event.
     *
     * @return the event type
     */
    public SwimEvent getEvent(){
        return eventType;
    }

    /**
     * Returns the gender category of this event.
     *
     * @return the gender string
     */
    public String getGender(){
        return gender;
    }

    /**
     * Returns the list of swimmers participating in the event.
     *
     * @return list of swimmers
     */
    public ArrayList<Swimmer> getSwimmers(){
        return swimmers;
    }

    /**
     * Returns the number of swimmers in this event.
     *
     * @return number of swimmers
     */
    public int getNumSwimmers(){
        return swimmers.size();
    }

    /**
     * Prints all swimmers currently added to the event.
     */
    public void listSwimmers(){
        for (Swimmer s: swimmers){
            System.out.println(s);
        }
    }

    /**
     * Counts how many swimmers have this event as their favourite.
     *
     * @return number of swimmers whose favourite event this is
     */
    public int numSwimmingFavourite(){
        int x = 0;
        for (Swimmer s: swimmers){
            if (s.getFavEvent().equals(eventType)){
                x++;
            }
        }
        return x;
    }

    /**
     * Sorts and returns the swimmers from fastest to slowest based on their best time
     * in this event.
     *
     * @return list of swimmers ordered by speed
     */
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

    /**
     * Prints a formatted heat sheet listing swimmers in order of seed time.
     */
    public void createHeatSheet(){
        ArrayList<Swimmer> orderedList = listFastestToSlowest();
        int i = 1;

        System.out.println("HEAT SHEET");
        System.out.println(gender + " " + eventName);
        System.out.printf("%-6s %-20s %-5s %-15s %-15s%n", "RANK", "ATHLETE", "AGE", "COUNTRY", "SEED TIME");
        System.out.println("--------------------------------------------------------------");

        for (Swimmer s : orderedList) {
            System.out.printf("%-6d %-20s %-5s %-15s %-15s %n", 
                            i, 
                            s.getName(), 
                            s.getAge(),
                            s.getCountry(),
                            s.getFastestSwim(eventType).getFormattedTime());
            i++;
        }
    }

    /**
     * Returns a string with info of the event.
     *
     * @return formatted event name with gender
     */
    public String toString(){
        return gender + " " + eventName;
    }


}
