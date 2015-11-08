sim.canvas.render = function(data) {

    sim.canvas.clear();
    var ctx = sim.canvas.ctx;

    // lines
    sim.canvas.render_line(data.lines, ctx, data.width, data.height);

    // circles
    sim.canvas.render_circle(data.circles, ctx, data.width, data.height);

    
};
