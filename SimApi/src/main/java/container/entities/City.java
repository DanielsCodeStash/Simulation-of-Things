package container.entities;

import container.Entity;
import container.Position;
import container.ResourcePoint;

import java.util.Date;
import java.util.function.Function;
import java.util.function.Supplier;

public class City extends Entity
{
    private String name;
    private Position position = new Position();
    private long population;

    public City()
    {
        double resourceStrength = population / 700;
        double resourceRadius = population / 100 + 5;

        components.add(new ResourcePoint(this, () -> (double) this.getPopulation())
                            .setRadius(resourceRadius)
                            .setResourceEffect(resourceStrength)
                            .setResourceDissipation(0.5));

        components.add(new CityDrawable(this));
        components.add(position);

    }


    public String getName()
    {
        return name;
    }

    public City setName(String name)
    {
        this.name = name;
        return this;
    }

    public long getPopulation()
    {
        return population;
    }

    public City setPopulation(long population)
    {
        this.population = population;
        return this;
    }


    public City setPosition(double x, double y)
    {
        position.set(x, y);
        return this;
    }
}
