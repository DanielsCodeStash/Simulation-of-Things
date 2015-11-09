package util;

public class TimeUtil
{


    public static void main(String[] args)
    {
        for (int hour = 0; hour < 24; hour++)
        {
            for (int min = 0; min < 60; min++)
            {
                System.out.println(toDbTimeString(hour, min));
            }
        }
    }

    public static String toDbTimeString(int hour, int min)
    {
        String hourStr = hour < 10 ? "0" + hour : Integer.toString(hour);
        String minStr = min < 10 ? "0" + min : Integer.toString(min);
        return hourStr + ":" + minStr + ":00";
    }
}
