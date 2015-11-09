package entity;

import component.PersonDrawable;
import component.Position;

public class Person extends Entity
{

    public Person(double x, double y)
    {
        components.add(new Position(x, y));
        components.add(new PersonDrawable(this));
    }
}
