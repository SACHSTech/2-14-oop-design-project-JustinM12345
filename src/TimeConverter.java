public class TimeConverter {
    
    public static String convertTime(double time){
        int totalSeconds = (int) time;
        int seconds = (int)time;
        int minutes;

        int milliseconds = (int) Math.round((time - totalSeconds) * 100);

        if (seconds >= 60){
            minutes = seconds / 60;
            seconds = seconds % 60;
            String strSeconds = String.valueOf(seconds);
            if (strSeconds.length() == 1){
                strSeconds = 0 + strSeconds;

                return minutes + ":" + strSeconds + "." + milliseconds;
            }

            else{
                return minutes + ":" + seconds + "." + milliseconds;
            }
        }

        else{
            return seconds + "." + milliseconds;
        }
    }
}
