package component;

import entity.Entity;

public class Component
{
    protected Entity entity;

    public Component()
    {
    }

    public Component(Entity entity)
    {
        this.entity = entity;
    }
}
