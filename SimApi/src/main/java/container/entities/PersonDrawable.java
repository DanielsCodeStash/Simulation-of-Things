package container.entities;

import container.Component;
import container.Entity;
import container.Position;
import container.draw.Drawable;
import container.draw.Drawing;
import container.draw.base.Circle;

public class PersonDrawable extends Component implements Drawable
{

    public PersonDrawable(Entity e)
    {
        super(e);
    }

    @Override
    public Drawing getDrawing()
    {
        Position p = entity.getPosition();

        return new Drawing()
                .add(new Circle(p.getX(), p.getY(), 0.5, "#1F1F1F"))
                .add(new Circle(p.getX(), p.getY(), 1, "#1F1F1F"));

    }
}