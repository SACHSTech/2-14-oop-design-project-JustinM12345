import java.io.*;
import java.util.ArrayList;

/**
 * A utility class for reading swimmer and swim data from CSV files
 * and converting them into object lists.
 * 
 * @author Justin M
 */
public class SwimFileReader {
    
    /**
     * Reads swimmer data from a CSV file and creates a list of Swimmer objects.
     *
     * @param swimmersFile the name of the CSV file containing swimmer data
     * @return an ArrayList of Swimmer objects
     * @throws IOException if the file is not found or cannot be read
     */
    public static ArrayList<Swimmer> readSwimmers(String swimmersFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/" + swimmersFile));
        ArrayList<Swimmer> swimmers = new ArrayList<>();

        String line;
        br.readLine(); // skip header

        // Reads each line and splits the values by commas to construct a Swimmer
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

            Swimmer swimmer = new Swimmer(id, first, last, gender, year, height, country, favEvent);
            swimmers.add(swimmer);
        }
        br.close();

        return swimmers;
    }

    /**
     * Reads swim result data from a CSV file and creates a list of Swim objects.
     *
     * @param swimsFile the name of the CSV file containing swim result data
     * @return an ArrayList of Swim objects
     * @throws IOException if the file is not found or cannot be read
     */
    public static ArrayList<Swim> readSwims(String swimsFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/" + swimsFile));
        ArrayList<Swim> swims = new ArrayList<>();

        String line;
        br.readLine(); // skip header

        // Reads each line and splits the values by commas to construct a Swim
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            SwimEvent event = SwimEvent.valueOf(parts[1]);
            String date = parts[2];
            double time = Double.parseDouble(parts[3]);

            Swim s = new Swim(id, event, date, time);
            swims.add(s);
        }
        br.close();

        return swims;
    }
}