function isValidPostName(postName) {
    if (postName == '') {
        alert('글 제목을 입력해주세요');
        return false;
    }
    if (postName.trim().length > 30) {
        alert('글 제목을 공백 포함 30자 이하로 입력해주세요');
        return false;
    }
    return true;
}

function isValidUserName(userName) {
    if (userName == '') {
        alert('유저 이름을 입력해주세요');
        return false;
    }
    if (userName.trim().length > 10) {
        alert('유저 이름을 공백 포함 10자 이하로 입력해주세요');
        return false;
    }
    return true;
}



function isValidContents(contents) {
    if (contents == '') {
        alert('내용을 입력해주세요');
        return false;
    }
    if (contents.trim().length > 140)
    {
        alert('내용을 공백 포함 140자 이하로 입력해주세요');
        return false;
    }
    return true;
}


function writePost() {
    let postName = $('#postName').val();
    let userName = $('#userName').val();
    let postText = $('#contents').val();

    alert(postName + userName + postText);

    if (isValidPostName(postName) == false)
    {
        return;
    }
    else if (isValidUserName(userName) == false)
    {
        return;
    }
    else if (isValidContents(postText) == false)
    {
        return;
    }

    let data = {'postName' : postName, 'userName': userName, 'postText': postText};

    $.ajax({
        type: "POST",
        url: "/view/memos",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            alert('메시지가 성공적으로 작성되었습니다.');
            window.location.href='/';

        }
    });
}

