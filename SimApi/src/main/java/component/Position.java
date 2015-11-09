package component;

public class Position extends Component
{
    private Double x;
    private Double y;

    public Position()
    {
    }

    public Position(Double x, Double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public Position setX(Double x)
    {
        this.x = x;
        return this;
    }

    public Position set(double x, double y)
    {
        this.x = x;
        this.y = y;
        return this;
    }

    public Double getY()
    {
        return y;
    }

    public Position setY(double y)
    {
        this.y = y;
        return this;
    }

    @Override
    public String toString()
    {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
