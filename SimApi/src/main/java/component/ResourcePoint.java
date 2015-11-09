package component;

import world.draw.Drawable;
import world.draw.Drawing;
import world.draw.base.Circle;
import entity.Entity;

import java.util.function.Supplier;

public class ResourcePoint extends Component implements Drawable
{
    private Double resourceEffect;
    private Double radius;
    private Double resourceDissipation;
    private Supplier<Double> strengthFaction;

    public ResourcePoint(Entity e)
    {
        super(e);
    }

    public ResourcePoint(Entity e, Supplier<Double> strengthFaction)
    {
        super(e);
        this.strengthFaction = strengthFaction;
    }

    @Override
    public Drawing getDrawing()
    {
        Position position = entity.get(Position.class, Option.REQUIRED);

        return new Drawing()
                .add(new Circle(position.getX(), position.getY(), strengthFaction.get() / 100)
                        .setColor("#5FCC2D", 0.5));
    }

    public Double getResourceEffect()
    {
        return resourceEffect;
    }

    public ResourcePoint setResourceEffect(Double resourceEffect)
    {
        this.resourceEffect = resourceEffect;
        return this;
    }

    public Double getRadius()
    {
        return radius;
    }

    public ResourcePoint setRadius(Double radius)
    {
        this.radius = radius;
        return this;
    }

    public Double getResourceDissipation()
    {
        return resourceDissipation;
    }

    public ResourcePoint setResourceDissipation(Double resourceDissipation)
    {
        this.resourceDissipation = resourceDissipation;
        return this;
    }


}
