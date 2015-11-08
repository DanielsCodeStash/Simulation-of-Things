sim.canvas.render_circle = function(circles, ctx, cWidth, cHeight)
{
	for (i = 0; i < circles.length; i++) 
	{

		var c = circles[i];

		var x = c.midPoint.x / cWidth * sim.canvas.w;
		var y = c.midPoint.y / cHeight * sim.canvas.h;
		var radius = c.radius / cWidth * sim.canvas.w;



		ctx.beginPath();

		ctx.arc(x, y, radius, 0, 2 * Math.PI, false);

		if(!c.noStroke)
		{
			var lineWidth = 1;
			if (c.lineWidth) 
			{
				lineWidth = c.lineWidth;
			}

			var color = "black";
			if(c.color)
			{
				color = c.color;
			}

			ctx.lineWidth = lineWidth;
			ctx.strokeStyle = color;
			ctx.stroke();

		}

		if(c.fill)
		{
			var type = c.fill.type;

			if(type === "solid")
			{
				ctx.fillStyle = c.fill.color;
      			ctx.fill();
			}
			else if(type === "gradient")
			{

				var inner = c.fill.innerRadius / cWidth * sim.canvas.w;
				var outer = c.fill.outerRadius / cWidth * sim.canvas.w;
				var gradient = ctx.createRadialGradient(x, y, inner, x, y, outer);

				for(j = 0; j < c.fill.gradientStops.length; j++)
				{
					var stop = c.fill.gradientStops[j];
					gradient.addColorStop(stop.point, stop.color);

				}

				ctx.fillStyle = gradient;
				ctx.fill();
			}
		}


	}
};