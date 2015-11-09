package world.draw.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import world.draw.Point;
import world.draw.Primitive;
import world.draw.fill.Fill;
import util.ColorUtil;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Circle extends Primitive
{
    private Point midPoint;
    private double radius;

    private Boolean noStroke;
    private String color;
    private Double lineWidth;

    private Fill fill;

    public Circle(Point midPoint, double radius)
    {
        this.midPoint = midPoint;
        this.radius = radius;
    }

    public Circle(double midX, double midY, double radius)
    {
        this.midPoint = new Point(midX, midY);
        this.radius = radius;
    }

    public Circle(double midX, double midY, double radius, String color)
    {
        this.midPoint = new Point(midX, midY);
        this.radius = radius;
        this.color = color;
    }

    public Circle(double midX, double midY, double radius, String color, double alpha)
    {
        this.midPoint = new Point(midX, midY);
        this.radius = radius;
        this.color = ColorUtil.hexAlpha(color, alpha);
    }

    public Point getMidPoint()
    {
        return midPoint;
    }

    public Circle setMidPoint(Point midPoint)
    {
        this.midPoint = midPoint;
        return this;
    }

    public double getRadius()
    {
        return radius;
    }

    public Circle setRadius(double radius)
    {
        this.radius = radius;
        return this;
    }

    public String getColor()
    {
        return color;
    }

    public Circle setColor(String color)
    {
        this.color = color;
        return this;
    }

    public Circle setColor(String color, double alpha)
    {
        this.color = ColorUtil.hexAlpha(color, alpha);
        return this;
    }

    public Double getLineWidth()
    {
        return lineWidth;
    }

    public Circle setLineWidth(Double lineWidth)
    {
        this.lineWidth = lineWidth;
        return this;
    }

    public Fill getFill()
    {
        return fill;
    }

    public Circle setFill(Fill fill)
    {
        this.fill = fill;
        return this;
    }


    @Override
    public String toString()
    {
        return "Circle{" +
                "midPoint=" + midPoint +
                ", radius=" + radius +
                ", noStroke=" + noStroke +
                ", color='" + color + '\'' +
                ", lineWidth=" + lineWidth +
                ", fill=" + fill +
                '}';
    }

    public Boolean getNoStroke()
    {
        return noStroke;
    }

    public Circle setNoStroke(Boolean noStroke)
    {
        this.noStroke = noStroke;
        return this;
    }
}
