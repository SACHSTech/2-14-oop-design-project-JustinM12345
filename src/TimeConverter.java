/**
 * Utility class for converting swim times from a decimal format (in seconds) 
 * to a human-readable string format (MM:SS.ss or SS.ss).
 * Example: A time of 125.37 would be converted to "2:05.37".
 * 
 * @author Justin M
 */
public class TimeConverter {
    
    /**
     * Converts a time in decimal seconds to a formatted string representation.
     *
     * @param time the time in seconds (e.g., 59.85 or 123.45)
     * @return the formatted time string
     */
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
