public class TimeConverter {
    
    public static String convertTime(double time){
        int totalSeconds = (int) time;
        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;
        int milliseconds = (int) Math.round((time - totalSeconds) * 100);

        String strMilliseconds = String.format("%02d", milliseconds);
        String strSeconds = String.format("%02d", seconds);

        if (totalSeconds >= 60){
            return minutes + ":" + strSeconds + "." + strMilliseconds;
        }

        else{
            return strSeconds + "." + strMilliseconds;
        }
    }
}
