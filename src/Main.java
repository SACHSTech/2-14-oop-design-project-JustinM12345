import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        
        // Reading csv files and using swimfilereader to create arraylist of objects
        ArrayList<Swimmer> champSwimmers = SwimFileReader.readSwimmers("swimmers.csv");
        ArrayList<Swim> champSwimCollection = SwimFileReader.readSwims("swims.csv");
        ArrayList<Swimmer> ageGroupSwimmers = SwimFileReader.readSwimmers("ageGroupSwimmers.csv");
        ArrayList<Swim> ageGroupSwims = SwimFileReader.readSwims("ageGroupSwims.csv");


        // Add all swims to swimmers
        for (Swimmer s : champSwimmers) {
            for (Swim x: champSwimCollection) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);

                    System.out.println("Added swim " + x + " for swimmer: " + s.getName());
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
        }

        mens_100m_freestyle.listSwimmers();

        // Add all swims to swimmers
        for (Swimmer s : ageGroupSwimmers) {
            for (Swim x: ageGroupSwims) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);

                    System.out.println("Added swim " + x + " for swimmer: " + s.getName());
                }
            }
        }

        // Creating event
        Event mens_200m_freestyle = new Event(SwimEvent.Freestyle_200, "Male");

        System.out.println(mens_200m_freestyle);

        // Adding all swimmers to event
        for (Swimmer s: ageGroupSwimmers){
            mens_200m_freestyle.addSwimmer(s);

            System.out.println("Added swimmer " + s.getName());
        }

        mens_200m_freestyle.listSwimmers();

        mens_200m_freestyle.createHeatSheet();





    }
    
}
