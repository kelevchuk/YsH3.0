
$(document).ready(function() {
    $.ajax({
        url: "value"
    }).then(function(data) {
        $('.value-sport').append(data.content);
    });
});