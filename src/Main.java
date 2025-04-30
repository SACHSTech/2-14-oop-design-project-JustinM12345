import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException{
        
        ArrayList<Swimmer> swimmers = SwimFileReader.readSwimmers("swimmers.csv");

        // Example: print all swimmers
        for (Swimmer s : swimmers) {
            System.out.println(s);
        }
    }
    
}
