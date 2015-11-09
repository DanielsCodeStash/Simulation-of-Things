package world.draw.base;

import util.ColorUtil;
import world.draw.Point;
import world.draw.Primitive;

public class Line extends Primitive
{
    private Point from;
    private Point to;

    private String color;
    private Double lineWidth;

    public Line(double xFrom, double yFrom, double xTo, double yTo)
    {
        from = new Point(xFrom, yFrom);
        to = new Point(xTo, yTo);
    }

    public Point getFrom()
    {
        return from;
    }

    public void setFrom(Point from)
    {
        this.from = from;
    }

    public Point getTo()
    {
        return to;
    }

    public void setTo(Point to)
    {
        this.to = to;
    }

    public String getColor()
    {
        return color;
    }

    public Line setColor(String color)
    {
        this.color = color;
        return this;
    }

    public Line setColor(String color, double alpha)
    {
        this.color = ColorUtil.hexAlpha(color, alpha);
        return this;
    }

    public Double getLineWidth()
    {
        return lineWidth;
    }

    public Line setLineWidth(Double lineWidth)
    {
        this.lineWidth = lineWidth;
        return this;
    }

    @Override
    public String toString()
    {
        return "Line{" +
                "from=" + from +
                ", to=" + to +
                ", color='" + color + '\'' +
                ", lineWidth=" + lineWidth +
                '}';
    }
}
