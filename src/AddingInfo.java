import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddingInfo {
    
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
}
