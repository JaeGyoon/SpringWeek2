$(document).ready(function () {
    getMessages();
})

function getMessages() {
//            $('#cards-box').empty();
    $.ajax({
        type: "GET",
        url: "/view/memos",
        data: {},
        success: function (response) {
            for (let i = 0; i < response.length; i++) {
                let post = response[i];
                let id = post['id'];
                let postName = post['postName'];
                let userName = post['userName'];
                let postText = post['postText'];
                let createdAt = post['createdAt'];
                addHTML(id, postName, userName, postText,createdAt);
            }
        }
    });
}

function addHTML(id, postName, userName, postText, createdAt)
{
    let tempHtml = makeMessage(id, postName, userName, postText, createdAt);
//            $('#cards-box').append(tempHtml);

    $('#tablebody').append(tempHtml);
}

function makeMessage(id, postName, userName, postText,createdAt, i)
{
    return `<tr class="tableColor">
                                        <td scope="row" class="tbPostNum"> ${id} </td>
                                        <td scope="row" class="tbPostName" onclick="readPost(${id})"> ${postName} </td>
                                        <td scope="row" class="tbUserName"> ${userName} </td>
                                        <td scope="row" class="tbWriteDay"> ${createdAt} </td>
                                    </tr>`
}

