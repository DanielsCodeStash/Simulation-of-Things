package container.draw;

import container.draw.base.Circle;
import container.draw.base.Line;

import java.util.ArrayList;
import java.util.List;

public class Canvas
{
    private double width;
    private double height;

    private List<Line> lines = new ArrayList<>();
    private List<Circle> circles = new ArrayList<>();

    public Canvas(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public Canvas addLine(Line line)
    {
        lines.add(line);
        return this;
    }

    public Canvas addCircle(Circle circle)
    {
        circles.add(circle);
        return this;
    }

    public Canvas addDrawable(Drawable drawable)
    {
        for(Primitive primitive : drawable.getDrawing().getPrimitives())
        {
            if(primitive instanceof Circle)
            {
                addCircle((Circle) primitive);
            }
            else if(primitive instanceof Line)
            {
                addLine((Line) primitive);
            }
            else
            {
                throw new IllegalArgumentException("Unknown drawable type");
            }
        }

        return this;
    }

    public List<Line> getLines()
    {
        return lines;
    }

    public void setLines(List<Line> lines)
    {
        this.lines = lines;
    }

    public double getWidth()
    {
        return width;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public List<Circle> getCircles()
    {
        return circles;
    }

    public void setCircles(List<Circle> circles)
    {
        this.circles = circles;
    }
}
