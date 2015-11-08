$('document').ready(function() {

    var data = {
        version: "0.000001"
    };

    var html = JST["../modules/footer/main_footer.hbs"](data);
    $("#footer").html(html);
});
