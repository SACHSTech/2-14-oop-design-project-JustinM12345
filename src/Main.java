import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        
        // Reading csv files and using swimfilereader to create arraylist of objects
        ArrayList<Swimmer> swimmers = SwimFileReader.readSwimmers("swimmers.csv");
        ArrayList<Swim> swimCollection = SwimFileReader.readSwims("swims.csv");


        // Add all swims to swimmers
        for (Swimmer s : swimmers) {
            for (Swim x: swimCollection) {
                if (s.getID() == x.getID()){
                    s.addSwim(x);

                    System.out.println("Added swim " + x + " for swimmer: " + s.getName());
                }
            }
        }

        // Print out all swimmers
        for (Swimmer s: swimmers){
            System.out.println(s);
        }

        Event mens_100m_freestyle = new Event(SwimEvent.Freestyle_100, "Male");

        System.out.println(mens_100m_freestyle);
    }
    
}
