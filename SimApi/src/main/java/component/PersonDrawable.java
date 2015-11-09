package component;

import world.draw.Drawable;
import world.draw.Drawing;
import world.draw.base.Circle;
import world.draw.fill.SolidFill;
import entity.Entity;

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
                .add(new Circle(p.getX(), p.getY(), 0.5, "#1F1F1F")
                        .setFill(new SolidFill("#8F8F8F")))
                .add(new Circle(p.getX(), p.getY(), 1, "#1F1F1F"));

    }
}
