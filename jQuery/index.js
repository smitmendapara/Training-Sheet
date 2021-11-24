$(document).ready(function() {
    var i = 0;
    $("button").click(function() {
        $("p").text("I am permenant!").css("color", "red");
        $("p").hover(function() {
            $(this).addClass("highlight");
        }, function() {
            $(this).removeClass("highlight");
        }
        );

    }); 
    $("#original").click(function() {
        $("p").text("This text is visible!");
        $("p").css("color", "blue");
        $("p").click(function() {
           $(this).slideUp();     
        });
    });

    $("input[type='text']").keypress(function() { // also we used keydown, keyup
        $("span").text(i += 1);
        $("#key").show().fadeOut();
    });

    $("input").focus(function() {
        $(this).next("span").show().fadeOut("slow");    
    });
});