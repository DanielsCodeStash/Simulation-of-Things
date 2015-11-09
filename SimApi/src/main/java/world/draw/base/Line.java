package world.draw.base;

import world.draw.Point;
import world.draw.Primitive;

public class Line extends Primitive
{
    private Point from;
    private Point to;

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

    @Override
    public String toString()
    {
        return "Line{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
