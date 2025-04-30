import java.io.*;
import java.util.ArrayList;

public class SwimFileReader {
    
    public  ArrayList<Swimmer> readSwimmers (String swimmersFile) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(swimmersFile));
        ArrayList<Swimmer> swimmers = new ArrayList<>();

        String line;
        br.readLine(); 

        //Reads the swimmers.csv file until the end, seperating each value by their commas and creating a new object that categorizes it.
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String first = parts[1];
            String last = parts[2];
            String gender = parts[3];
            int year = Integer.parseInt(parts[4]);
            int height = Integer.parseInt(parts[5]);
            String country = parts[6];
            SwimEvent favEvent = SwimEvent.valueOf(parts[7]);
;
            Swimmer swimmer = new Swimmer(id, first, last, gender, year, height, country, favEvent);
            swimmers.add(swimmer);

        }
        br.close();

        return swimmers;
    }


}
