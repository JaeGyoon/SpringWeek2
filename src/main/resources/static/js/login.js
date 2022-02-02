$(document).ready(function () {
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
