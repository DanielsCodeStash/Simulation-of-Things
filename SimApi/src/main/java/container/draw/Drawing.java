package container.draw;

import java.util.ArrayList;
import java.util.List;

public class Drawing
{
    private List<Primitive> primitives = new ArrayList<>();

    public Drawing add(Primitive primitive)
    {
        primitives.add(primitive);
        return this;
    }

    public List<Primitive> getPrimitives()
    {
        return primitives;
    }

    @Override
    public String toString()
    {
        return "Drawable{" +
                "primitives=" + primitives +
                '}';
    }
}
