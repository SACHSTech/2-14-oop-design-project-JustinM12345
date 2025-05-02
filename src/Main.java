import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        
        // Reading csv files and using swimfilereader to create arraylist of objects
        ArrayList<Swimmer> champSwimmers = SwimFileReader.readSwimmers("proSwimmers.csv");
        ArrayList<Swim> champSwimCollection = SwimFileReader.readSwims("proSwims.csv");
        ArrayList<Swimmer> ageGroupSwimmers = SwimFileReader.readSwimmers("ageGroupSwimmers.csv");
        ArrayList<Swim> ageGroupSwims = SwimFileReader.readSwims("ageGroupSwims.csv");


        // Add all swims to swimmers
        for (Swimmer s : champSwimmers) {
            for (Swim x: champSwimCollection) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);

                    //System.out.println("Added swim " + x + " for swimmer: " + s.getName());
                }
            }
        }

        // Creating event
        Event mens_100m_freestyle = new Event(SwimEvent.Freestyle_100, "Male");

        System.out.println(mens_100m_freestyle);

        // Adding all swimmers to event
        for (Swimmer s: champSwimmers){
            mens_100m_freestyle.addSwimmer(s);

            System.out.println("Added swimmer " + s.getName());
            System.out.println("Pro swimmer?: " + s.proPotential());
        }

        mens_100m_freestyle.createHeatSheet();

        //------------------------------------------------------------ Age group swimmers csv -------------------------------------------

        // Add all swims to swimmers
        for (Swimmer s : ageGroupSwimmers) {
            for (Swim x: ageGroupSwims) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);

                    //System.out.println("Added swim " + x + " for swimmer: " + s.getName());
                }
            }
        }

        // Printing out each swimmers' swims 
        for (Swimmer s: ageGroupSwimmers){
            ArrayList<Swim> swimsSorted= s.sortFastToSlow();
            System.out.println("Swims sorted from fastest to slowest for " + s.getName());
            for (Swim x: swimsSorted){
                System.out.println(x);
            }
            System.out.println("Potential to become pro?: " + s.proPotential());
            System.out.println("-----------------------------------------------");
        }

        // Creating event
        Event mens_200m_freestyle = new Event(SwimEvent.Freestyle_200, "Male");

        // Adding all swimmers to event
        for (Swimmer s: ageGroupSwimmers){
            mens_200m_freestyle.addSwimmer(s);

            //System.out.println("Added swimmer " + s.getName());
        }

        //mens_200m_freestyle.listSwimmers();

        mens_200m_freestyle.createHeatSheet();

        // -------User interface-----------------------------------------------------------------

        boolean runningProgram = true;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int userChoice;

        while(runningProgram){
            System.out.println("Swim Meet Manager\nManage swimmers, events, and race results!\nDeveloped by Justin M\n-----------------------------------------");
            System.out.print("Which of the following options would you like to do?\n1. List all swimmers\n2. Add a new swimmer\n3. Add a swim result to a swimmer\n4. View heat sheet for an event\n5. View a swimmer's fastest swim\n6. View a swimmer's swim history (fast to slow)\n7. Check a swimmer's pro potential\n8. List all swimmers (fastest to slowest)\n9. Exit program\nInput your choice:");

            userChoice = Integer.parseInt(keyboard.readLine());

            switch (userChoice) {
                case 1:
                //List all swimmers
                System.out.print("Which of the following groups do you want to display?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    // Age group Swimmers 
                    mens_200m_freestyle.listSwimmers(); 
                        break;

                    case 2:
                    // Professional Swimmers
                    mens_100m_freestyle.listSwimmers();
                        break;

                    default:
                    System.out.println("Invalid option");
                        break;
                }

                    break;

                case 2:
                //Add a new swimmer
                System.out.print("Which of the following groups do you want to add a swimmer to?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    // Age group swimmers
                    mens_200m_freestyle.addSwimmer(AddingInfo.addSwimmer(mens_200m_freestyle));
                    mens_200m_freestyle.listSwimmers();
                        break;

                    case 2:
                    // Professional swimmers

                        break;
                
                    default:
                    System.out.println("Invalid option");
                        break;
                }
                    break;

                case 3:
                //Add a swim result to a swimmer
                    break;

                case 4:
                //View heat sheet for an event
                    break;

                case 5:
                //View a swimmer's fastest swim
                    break;

                case 6:
                //View a swimmer's swim history
                    break;

                case 7:
                //Check a swimmer's pro potential
                    break;

                case 8:
                //List all swimmers fastest to slowest
                    break;

                case 9:
                //Exit
                System.out.println("Thanks for using the program!");
                runningProgram = false;
                    break;
                
                default:
                System.out.println("Invalid option");
                    break;
            }

            
        }
        





    }
    
}
