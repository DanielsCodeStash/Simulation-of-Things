package world.draw.fill;

import java.util.ArrayList;
import java.util.List;

public class CircleGradientFill extends Fill
{
    private double innerRadius;
    private double outerRadius;

    private List<GradientStop> gradientStops = new ArrayList<>();

    public CircleGradientFill()
    {
    }

    public CircleGradientFill(double innerRadius, double outerRadius)
    {
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        type = FillType.GRADIENT;
    }

    public double getInnerRadius()
    {
        return innerRadius;
    }

    public CircleGradientFill setInnerRadius(double innerRadius)
    {
        this.innerRadius = innerRadius;
        return this;
    }

    public CircleGradientFill addStop(GradientStop stop)
    {
        gradientStops.add(stop);
        return this;
    }

    public double getOuterRadius()
    {
        return outerRadius;
    }

    public List<GradientStop> getGradientStops()
    {
        return gradientStops;
    }

    public CircleGradientFill setOuterRadius(double outerRadius)
    {
        this.outerRadius = outerRadius;
        return this;
    }

    public CircleGradientFill setGradientStops(List<GradientStop> gradientStops)
    {
        this.gradientStops = gradientStops;
        return this;
    }

    @Override
    public String toString()
    {
        return "CircleGradientFill{" +
                "innerRadius=" + innerRadius +
                ", outerRadius=" + outerRadius +
                ", gradientStops=" + gradientStops +
                '}';
    }
}
