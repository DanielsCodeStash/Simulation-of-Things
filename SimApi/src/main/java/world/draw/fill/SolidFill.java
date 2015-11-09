package world.draw.fill;

import util.ColorUtil;

public class SolidFill extends Fill
{
    private String color;

    public SolidFill(String color)
    {
        this.type = FillType.SOLID;
        this.color = color;
    }

    public SolidFill(String color, double alpha)
    {
        this.type = FillType.SOLID;
        this.color = ColorUtil.hexAlpha(color, alpha);
    }

    public String getColor()
    {
        return color;
    }
}
