package container.draw.fill;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GradientStop
{
    private String color;
    private double point;
    private Double alpha;

    public GradientStop(double point, String color)
    {
        this.color = color;
        this.point = point;
    }

    public GradientStop(double point, String color, double alpha)
    {
        this.color = color;
        this.point = point;
        this.alpha = alpha;
    }

    public String getColor()
    {
        return color;
    }

    public double getPoint()
    {
        return point;
    }

    public Double getAlpha()
    {
        return alpha;
    }
}
