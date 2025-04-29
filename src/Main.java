
public class Main {

    public static void main(String[] args) {
        System.out.println(SwimEvent.Freestyle_100);
        
        Swim testing = new Swim(1, SwimEvent.Freestyle_50, "05-30-24", 19.90);

        System.out.println(testing.getFormattedTime());
    }
    
}
