
public class Main {

    public static void main(String[] args) {
        System.out.println(SwimEvent.Freestyle_100);
        
        SwimInfo testing = new SwimInfo(1, SwimEvent.Freestyle_200, "05-30-24", 102.85);

        System.out.println(testing.getFormattedTime());
    }
    
}
