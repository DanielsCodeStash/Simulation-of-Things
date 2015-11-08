$('document').ready(function() {

    var data = {
        status: "Paused"
    };

    var html = JST["../modules/control/main_control.hbs"](data);
    $("#control").html(html);
});




function get() {

    $.ajax({

        url: sim.url + "/canvas",

        success: function(data, textStatus, xhr) {
            sim.canvas.render(data);
        },

        error: function(xhr, textStatus) {}
    });
}
