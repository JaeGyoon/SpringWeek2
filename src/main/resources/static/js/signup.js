$(document).ready(function () {

    let errorText =  $('#errorText').text();

    if ( errorText != "")
    {
        alert(errorText);
        $('#errorText').empty();
    }

    usercheck();
})

function usercheck() {
    $.ajax({
        type: "GET",
        url: "/user/userCheck",
        success: function (response) {

            if (response)
            {
                window.location.replace("/")
                alert("이미 로그인되었습니다")
            }
        }
    });
}