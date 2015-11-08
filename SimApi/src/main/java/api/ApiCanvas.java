package api;

import container.Component;
import container.Entity;
import container.World;
import container.draw.Drawable;
import container.draw.base.Circle;
import container.draw.Canvas;
import container.draw.base.Line;
import util.json.JsonUtil;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/canvas")
public class ApiCanvas
{

    private static World world = new World();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getWorld()
    {
        Canvas canvas = new Canvas(100, 100);

        for(Entity entity : world.getEntities())
        {
            entity
                .getComponents()
                .stream()
                .filter(c -> c instanceof Drawable)
                .forEach(c -> canvas.addDrawable((Drawable) c));
        }

        return JsonUtil.mapToJson(canvas);
    }
}
