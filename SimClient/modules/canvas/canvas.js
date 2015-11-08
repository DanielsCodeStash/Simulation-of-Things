sim.canvas.h = 700;
sim.canvas.w = 700;

$('document').ready(function() {

    var canvas = document.getElementById("canvas");
    sim.canvas.ctx = canvas.getContext("2d");

    canvas.style.width = sim.canvas.w + "px";
    canvas.style.height = sim.canvas.h + "px";
    canvas.width = sim.canvas.h;
    canvas.height = sim.canvas.w;

    canvas.addEventListener('click', function(event) {
        sim.canvas.debug(canvas, event);
    }, false);

    sim.canvas.clear();

});
