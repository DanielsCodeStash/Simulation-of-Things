sim.canvas.background_loaded = false;

sim.canvas.clear = function() {
    sim.canvas.ctx.fillStyle = "#8FAFBA";
    sim.canvas.ctx.fillRect(0, 0, sim.canvas.h, sim.canvas.w);

    if (sim.canvas.background_loaded) {
        sim.canvas.ctx.drawImage(sim.canvas.background, 0, 0);
    } else {
        sim.canvas.background = new Image();
        sim.canvas.background.onload = function() {
            sim.canvas.background_loaded = true;
            sim.canvas.ctx.drawImage(sim.canvas.background, 0, 0);
        };
        sim.canvas.background.src = 'http://i.imgur.com/9DQD4F6.png';
    }
};
