public class TimeConverter {
    
    public static String convertTime(double time){
        String strTime = Double.toString(time);
        int seconds = (int)time;
        int minutes;

        String milliseconds = strTime.substring(strTime.length() - 3, strTime.length());

        if (seconds >= 60){
            minutes = seconds / 60;
            seconds = seconds % 60;
            String strSeconds = String.valueOf(seconds);
            if (strSeconds.length() == 1){
                strSeconds = 0 + strSeconds;

                return minutes + ":" + strSeconds + milliseconds;
            }

            else{
                return minutes + ":" + seconds + milliseconds;
            }
        }

        else{
            return seconds + milliseconds;
        }
    }
}
