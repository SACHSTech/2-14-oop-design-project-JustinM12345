
public class Main {

    public static void main(String[] args) {
        System.out.println(SwimEvent.Freestyle_100);
        
        SwimInfo testing = new SwimInfo(1, SwimEvent.Freestyle_50, "05-30-24", 79.90);

        System.out.println(testing.getFormattedTime());
    }
    
}
