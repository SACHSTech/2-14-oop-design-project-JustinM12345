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


        //--------------------------------- Professional swimmers csv--------------------------------
        // Add all swims to swimmers
        for (Swimmer s : champSwimmers) {
            for (Swim x: champSwimCollection) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);
                }
            }
        }

        // Creating event
        Event mens_100m_freestyle = new Event(SwimEvent.Freestyle_100, "Male");

        // Adding all swimmers to event
        for (Swimmer s: champSwimmers){
            mens_100m_freestyle.addSwimmer(s);
        }

        //------------------------------------------------------------ Age group swimmers csv -------------------------------------------

        // Add all swims to swimmers
        for (Swimmer s : ageGroupSwimmers) {
            for (Swim x: ageGroupSwims) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);
                }
            }
        }

        // Creating event
        Event mens_200m_freestyle = new Event(SwimEvent.Freestyle_200, "Male");

        // Adding all swimmers to event
        for (Swimmer s: ageGroupSwimmers){
            mens_200m_freestyle.addSwimmer(s);
        }

        // -------User interface-----------------------------------------------------------------

        boolean runningProgram = true;
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        int userChoice;

        while(runningProgram){
            int addingID;
            Swimmer selectedSwimmer = null;

            System.out.println("Swim Meet Manager\nManage swimmers, events, and race results!\nDeveloped by Justin M\n-----------------------------------------");
            System.out.print("Which of the following options would you like to do?\n1. List all swimmers\n2. Add a new swimmer\n3. Add a swim result to a swimmer\n4. View heat sheet for an event\n5. View a swimmer's fastest swim\n6. View a swimmer's swim history (fast to slow)\n7. Check a swimmer's pro potential (Based on favourite swim)\n8. List all swimmers (fastest to slowest)\n9. Exit program\nInput your choice: ");

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
                    System.out.println("Swimmer successfully added!");
                        break;

                    case 2:
                    // Professional swimmers
                    mens_100m_freestyle.addSwimmer(AddingInfo.addSwimmer(mens_100m_freestyle));
                    System.out.println("Swimmer successfully added!");
                        break;
                
                    default:
                    System.out.println("Invalid option");
                        break;
                }
                    break;

                case 3:
                //Add a swim result to a swimmer
                System.out.print("Which of the following groups is the swimmer in?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    // Age group Swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_200m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_200m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    selectedSwimmer.addSwim(AddingInfo.addSwim(addingID));
                    System.out.println("Updated history of swims");
                    for (Swim s: selectedSwimmer.getSwims()){
                        System.out.println(s);
                    }
                    break;

                    case 2:
                    // Professional Swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_100m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_100m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    selectedSwimmer.addSwim(AddingInfo.addSwim(addingID));
                    System.out.println("Updated history of swims");
                    for (Swim s: selectedSwimmer.getSwims()){
                        System.out.println(s);
                    }

                    break;
                
                    default:
                    System.out.println("Invalid option");
                        break;
                }
                    break;

                case 4:
                //View heat sheet for an event
                System.out.print("Which event do you want to generate heat sheets for?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    mens_200m_freestyle.createHeatSheet();
                        break;
                    
                    case 2:
                    mens_100m_freestyle.createHeatSheet();
                        break;

                    default:
                    System.out.println("Invalid option");
                        break;
                }
                    break;

                case 5:
                //View a swimmer's fastest swim
                System.out.print("Which of the following groups is the swimmer in?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    // Age group Swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_200m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_200m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    System.out.println(selectedSwimmer.getFastestSwim(SwimEvent.Freestyle_200));
                    break;

                    case 2:
                    // Professional swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_100m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_100m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    System.out.println(selectedSwimmer.getFastestSwim(SwimEvent.Freestyle_100));
                    break;

                    default:
                    System.out.println("Invalid option");
                        break;
                }

                case 6:
                //View a swimmer's swim history
                System.out.print("Which of the following groups is the swimmer in?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    // Age group Swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_200m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_200m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    for(Swim s: selectedSwimmer.sortFastToSlow()){
                        System.out.println(s);
                    }
                    break;

                    case 2:
                    // Professional swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_100m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_100m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    for(Swim s: selectedSwimmer.sortFastToSlow()){
                        System.out.println(s);
                    }
                    break;

                    default:
                    System.out.println("Invalid option");
                        break;
                }
                    break;

                case 7:
                //Check a swimmer's pro potential
                System.out.print("Which of the following groups is the swimmer in?\n1. Age Group Swimmers\n2. Professional Swimmers\nInput your choice:");
                userChoice = Integer.parseInt(keyboard.readLine());
                switch (userChoice) {
                    case 1:
                    // Age group Swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_200m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_200m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    System.out.println("Does this swimmer have potential to be pro?: " + selectedSwimmer.proPotential());
                    break;

                    case 2:
                    // Professional swimmers
                    System.out.println("These are the swimmers currently in the group");
                    mens_100m_freestyle.listSwimmers();
                    System.out.print("Please enter the ID of the swimmer: ");
                    addingID = Integer.parseInt(keyboard.readLine());
                    for (Swimmer s : mens_100m_freestyle.getSwimmers()) {
                        if (s.getID() == addingID) {
                            selectedSwimmer = s;
                            break;
                        }
                    }
                    System.out.println("Does this swimmer have potential to be pro?: " + selectedSwimmer.proPotential());
                    break;

                    default:
                    System.out.println("Invalid option");
                        break;
                }

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
