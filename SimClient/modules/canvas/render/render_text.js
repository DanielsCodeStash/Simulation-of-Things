sim.canvas.render_text = function(texts, ctx, cWidth, cHeight) 
{
    for (i = 0; i < texts.length; i++) 
    {

        var t = texts[i];

        ctx.font = "15px Arial";
        ctx.fillStyle = "black";
        ctx.textAlign = "center";

        var x = t.pos.x / cWidth * sim.canvas.w;
        var y = t.pos.y / cWidth * sim.canvas.w;


        ctx.fillText(t.text, x, y);

    }
};
