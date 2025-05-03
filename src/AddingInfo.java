import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utility class for interactively adding swimmer and swim information through user input
 * 
 * @author Justin M 
 */
public class AddingInfo {
    
    /**
     * Prompts the user for swimmer details and creates a swimmer object.
     * 
     * It uses the number of swimmers already in the given collection to assign a new ID.
     * 
     * @param event the current event to determine the number of current swimmers
     * @return a newly created swimmer object with the inputted information
     * @throws IOException if an input error occurs
     */
    public static Swimmer addSwimmer(Event event) throws IOException{
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int swimmerID = event.getNumSwimmers() + 1;
        String firstName;
        String lastName;
        String gender;
        int birthYear;
        int height;
        String country;
        SwimEvent favEvent = null;
        boolean validEvent = false;
        
        System.out.print("Swimmer's First Name: ");
        firstName = keyboard.readLine();
        System.out.print("Swimmer's Last Name: ");
        lastName = keyboard.readLine();
        System.out.print("Swimmer's Gender (Male/Female): ");
        gender = keyboard.readLine();
        System.out.print("Representing country: ");
        country = keyboard.readLine();
        System.out.print("Year of birth: ");
        birthYear = Integer.parseInt(keyboard.readLine());
        System.out.print("Height in cm: ");
        height = Integer.parseInt(keyboard.readLine());
        while (!validEvent) {
            System.out.println("Enter your favourite event (e.g. Freestyle_100). Choose from:");
            for (SwimEvent e : SwimEvent.values()) {
                System.out.println(" - " + e.name());
            }
        
            System.out.print("Favourite event: ");
            String eventInput = keyboard.readLine();
        
            for (SwimEvent e : SwimEvent.values()) {
                if (e.name().equals(eventInput)) {
                    favEvent = e;
                    validEvent = true;
                    break;
                }
            }
        
            if (!validEvent) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        Swimmer newSwimmer = new Swimmer(swimmerID, firstName, lastName, gender, birthYear, height, country, favEvent);

        return newSwimmer;

    }

    /**
     * Prompts the user to input swim information for a swimmer, including event, date, and time.
     *
     * @param swimmerID the unique ID of the swimmer to associate with the swim
     * @return a new swim object with user-provided data
     * @throws IOException if an input error occurs
     */
    public static Swim addSwim(int swimmerID) throws IOException{
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        SwimEvent event = null;
        String date;
        double time;
        boolean validEvent = false;

        while (!validEvent) {
            System.out.println("Enter the name of the event that you would like to add a time to (e.g. Freestyle_100). Choose from:");
            for (SwimEvent e : SwimEvent.values()) {
                System.out.println(" - " + e.name());
            }
        
            System.out.print("Input the name: ");
            String eventInput = keyboard.readLine();
        
            for (SwimEvent e : SwimEvent.values()) {
                if (e.name().equals(eventInput)) {
                    event = e;
                    validEvent = true;
                    break;
                }
            }
        
            if (!validEvent) {
                System.out.println("Invalid input. Please try again.");
            }
        }

        System.out.print("Input the date of the swim (Please use format yyyy-mm-dd): ");
        date = keyboard.readLine();
        System.out.print("Please input the time that the swimmer achieved (MUST BE IN SECONDS, eg: 1:02 is 62 seconds): ");
        time = Double.parseDouble(keyboard.readLine());

        Swim addedSwim = new Swim(swimmerID, event, date, time);

        return addedSwim;
    }
}