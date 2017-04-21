
$(document).ready(function() {
    $.ajax({
        url: "/address"
    }).then(function(data) {
        $('.address-sport').append(data.sport);
    });
});