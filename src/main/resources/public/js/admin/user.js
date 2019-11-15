function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/user?direction=ASC&page=' + page + '&size=5&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data;
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var firstName = response.data[i].firstName;
                var secondName = response.data[i].secondName;
                var age = response.data[i].age;
                var phone = response.data[i].phone;
                var email = response.data[i].email;
                data +=
                    '<tr>' +
                    '<td>' + id + '</td>' +
                    '<td>' + firstName + '</td>' +
                    '<td>' + secondName + '</td>' +
                    '<td>' + age + '</td>' +
                    '<td>' + phone + '</td>' +
                    '<td>' + email + '</td>' +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#users tbody').html(data);
            var paginationData = '';

            for (var i = 0; i <= response.numberOfPages - 1; i++) {
                var j = i + 1;
                if (i === page) {
                    paginationData += "<li class='page-item'><span class='page-link'>" + j + "<span class='sr-only'>(current)</span></span></li>";
                } else {
                    paginationData += "<li class='page-item'><a class='page-link' onclick='init(" + i + ")'>" + j + "</a></li>";
                }
            }

            $('#pagination').html(paginationData);
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

init(0);

//remove user by id
function remove(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/user?id=' + id,
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}

function logout() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/logout',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            window.location.replace("../../html/login.html");
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}
