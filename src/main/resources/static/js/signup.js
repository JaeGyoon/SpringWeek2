$(document).ready(function () {

    let errorText =  $('#errorText').text();

    if ( errorText != "")
    {
        alert(errorText);
        $('#errorText').empty();
    }

})