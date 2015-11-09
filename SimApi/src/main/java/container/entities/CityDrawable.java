package container.entities;

import container.Component;
import container.Position;
import container.draw.Drawable;
import container.draw.Drawing;
import container.draw.Point;
import container.draw.base.Circle;
import container.draw.base.Text;
import container.draw.fill.CircleGradientFill;
import container.draw.fill.GradientStop;

public class CityDrawable extends Component implements Drawable
{
    private City city;

    public CityDrawable(City city)
    {
        super(city);
        this.city = city;
    }

    @Override
    public Drawing getDrawing()
    {
        double maxRadius = city.getPopulation() / 100;

        double x = city.get(Position.class).getX();
        double y = city.get(Position.class).getY();


        CircleGradientFill mainFill = new CircleGradientFill(0, maxRadius)
                .addStop(new GradientStop(0, "#FF0048", 0.9))
                .addStop(new GradientStop(1, "#FF0048", 0.1));

        return new Drawing()
                .add(new Circle(x, y, maxRadius)
                        .setFill(mainFill)
                        .setColor("#A3A3A3", 0.7))
                .add(new Circle(x, y, maxRadius/5)
                        .setColor("#4A4A4A", 0.2))
                .add(new Text()
                    .setText(city.getName())
                    .setPos(new Point(x, y-2)));
    }
}
