package world.draw.fill;

import com.fasterxml.jackson.annotation.JsonInclude;
import util.ColorUtil;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradientStop
{
    private String color;
    private double point;

    public GradientStop(double point, String color)
    {
        this.color = color;
        this.point = point;
    }

    public GradientStop(double point, String color, double alpha)
    {
        this.color = ColorUtil.hexAlpha(color, alpha);
        this.point = point;
    }

    public String getColor()
    {
        return color;
    }

    public double getPoint()
    {
        return point;
    }
}
