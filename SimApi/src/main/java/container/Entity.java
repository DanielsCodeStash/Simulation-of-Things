package container;

import java.util.ArrayList;
import java.util.List;

public class Entity
{
    protected List<Component> components = new ArrayList<>();

    public Position getPosition()
    {
        for(Component c : components)
        {
            if(c instanceof Position)
            {
                return (Position) c;
            }
        }

        return null;
    }

    public List<Component> getComponents()
    {
        return components;
    }
}
