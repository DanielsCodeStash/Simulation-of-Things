package container.entities;

import container.Component;
import container.draw.Drawable;
import container.draw.Drawing;
import container.draw.base.Circle;
import container.draw.fill.CircleGradientFill;
import container.draw.fill.GradientStop;
import container.draw.fill.SolidFill;

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

        double x = city.getPosition().getX();
        double y = city.getPosition().getY();

        /*return new Drawing()
                .add(new Circle(x, y, maxRadius, "#FF0000", 0.2)
                        .setLineWidth(4.0)
                )
                .add(new Circle(x, y, maxRadius/2, "#FF0000", 0.4))
                .add(new Circle(x, y, maxRadius/4, "#FF0000", 0.5))
                .add(new Circle(x, y, maxRadius/7, "#FF0000"))
                .add(new Circle(x, y, 0.5, "#FF0000"))
                .add(new Circle(x, y, 0.2, "#FF0000"));
                */

        Circle test;
        if(city.getName().equals("Stockholm"))
        {
            CircleGradientFill fill = new CircleGradientFill(maxRadius/2, maxRadius-0.5)
                    .addStop(new GradientStop(0, "#87A891"))
                    .addStop(new GradientStop(0.5, "#BD6283"))
                    .addStop(new GradientStop(1, "rgba(150,150,150,0.5)"));

            test = new Circle(x, y, maxRadius)
                    .setNoStroke(true)
                    .setFill(fill);

        }
        else if(city.getName().equals("Umeå"))
        {

            test = new Circle(x, y, maxRadius)
                    .setFill(new SolidFill("#58BADB"));
        }
        else
        {
            test = new Circle(x, y, maxRadius)
                    .setFill(new SolidFill("#ACE3BE", 0.3));
        }


        return new Drawing()
                .add(test);
    }
}
