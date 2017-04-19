$(document).ready(function() {
    $.ajax({
        url: "/greeting"
    }).then(function(data) {
        $('.greeting-content').append(data.content);
    });
});

/*
$select=mysql_db_query("SELECT что FROM откуда WHERE параметры") or die(mysql_error());
echo "<SELECT NAME="">";
while($obj=mysql_fetch_object($select)){
    echo"<option value=$obj->поле из базы>$obj->поле из базы</option>";
}
echo"</SELECT>";*/
