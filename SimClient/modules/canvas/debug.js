sim.canvas.debug = function(canvas, event) {
    var rect = canvas.getBoundingClientRect();
    var x = event.clientX - rect.left;
    var y = event.clientY - rect.top;
    console.log("x: " + x / sim.canvas.w * 100 + " y: " + y / sim.canvas.h * 100);

};
