package world;

import entity.Entity;
import world.draw.Drawable;
import world.draw.Drawing;
import world.draw.Point;
import world.draw.base.Line;
import world.draw.base.Text;

public class ResourceAggregator  implements Drawable
{



    @Override
    public Drawing getDrawing()
    {
        Drawing drawing = new Drawing();

        // horizontal lines
        for(int i = 0; i <= 100; i += 5)
        {
            drawing.add(new Line(0, i, 100, i)
                            .setColor("#636363", 0.5)
                            .setLineWidth(0.5));

            drawing.add(new Line(i, 0, i, 100)
                    .setColor("#636363", 0.5)
                    .setLineWidth(0.5));

            if(i != 100)
            {
                double x = i + 2.5;
                for(double y = 3.5; y <= 100; y += 5)
                {
                    drawing.add(new Text()
                            .setText("1")
                            .setPos(new Point(x, y)));
                }
            }

        }



        return drawing;
    }
}
