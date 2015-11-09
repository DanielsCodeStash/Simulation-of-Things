sim.canvas.render_line = function(lines, ctx, cWidth, cHeight) {
    for (i = 0; i < lines.length; i++) {

        var l = lines[i];

        var from = l.from;
        var to = l.to;

        ctx.beginPath();

        var xFrom = from.x / cWidth * sim.canvas.w;
        var yFrom = from.y / cHeight * sim.canvas.h;

        ctx.moveTo(xFrom, yFrom);

        var xTo = to.x / cWidth * sim.canvas.w;
        var yTo = to.y / cHeight * sim.canvas.h;
        ctx.lineTo(xTo, yTo);

        var lineWidth = 2;
        if(l.lineWidth)
        {
            lineWidth = l.lineWidth;
        }
        ctx.lineWidth = lineWidth;

        var color = "black";
        if (l.color) 
        {
            color = l.color;
        }

        ctx.strokeStyle = color;

        ctx.stroke();
    }
};
