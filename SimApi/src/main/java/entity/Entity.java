package entity;

import component.CityDrawable;
import component.Component;
import component.Option;
import component.Position;

import java.util.ArrayList;
import java.util.List;

public class Entity
{
    protected List<Component> components = new ArrayList<>();

    public static void main(String[] args)
    {
        Entity e = new Entity();
        e.getComponents().add(new Position(1.0, 1.0));
        e.getComponents().add(new CityDrawable(null));
        System.out.println(e.get(Position.class));
    }

    public Position getPosition()
    {
        return get(Position.class, Option.REQUIRED);
    }

    public <T extends Component> T get(Class<T> type)
    {
        return get(type, Option.OPTIONAL);
    }

    public <T extends Component> T get(Class<T> type, Option option)
    {
        for (Component c : components)
        {
            if (c.getClass().equals(type))
            {
                return type.cast(c);
            }
        }

        if (option == Option.REQUIRED)
        {
            throw new RuntimeException("Missing Component: " + type.getName() + "(" + option + ")");
        }

        return null;
    }

    public List<Component> getComponents()
    {
        return components;
    }
}
