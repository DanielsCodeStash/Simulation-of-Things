package world;

import entity.City;
import entity.Entity;
import entity.Person;

import java.util.ArrayList;
import java.util.List;

public class World
{
    private List<Entity> entities = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("hej");
    }

    public World()
    {
        entities.addAll(getCities());
        entities.add(new Person(55, 40));
    }

    public List<City> getCities()
    {
        List<City> cities = new ArrayList<>();

        cities.add(new City()
                .setName("Stockholm")
                .setPopulation(789)
                .setPosition(63, 74));

        cities.add(new City()
                .setName("Umeå")
                .setPopulation(300)
                .setPosition(73, 42));

        cities.add(new City()
                .setName("Sollefteå")
                .setPopulation(200)
                .setPosition(61, 50));

        return cities;
    }

    public World addEntity(Entity entity)
    {
        entities.add(entity);
        return this;
    }

    public List<Entity> getEntities()
    {
        return entities;
    }

}
