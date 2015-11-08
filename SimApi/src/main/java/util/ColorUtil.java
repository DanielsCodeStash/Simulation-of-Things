package util;

public class ColorUtil
{

    public static String hexAlpha(String color, double alpha)
    {
        int r = Integer.valueOf(color.substring( 1, 3 ), 16 );
        int g = Integer.valueOf(color.substring( 3, 5 ), 16 );
        int b = Integer.valueOf(color.substring( 5, 7 ), 16 );
        return "rgba(" + r + "," + g + "," + b + "," + alpha + ")";
    }
}
