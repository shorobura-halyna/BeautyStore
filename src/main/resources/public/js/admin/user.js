function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/user?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
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
            if (!data){
                data = '<tr></tr>';
            }
            $('#users tbody').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

function save() {
    var firstName = $('#firstName').val();
    var secondName = $('#secondName').val();
    var age = $('#age').val();
    var phone = $('#phone').val();
    var email = $('#email').val();

    var obj = {
        'firstName': firstName,
        'secondName': secondName,
        'age': age,
        'phone': phone,
        'email': email
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/user',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#firstName').val(''); //clean val from input
            $('#secondName').val('');
            $('#age').val('');
            $('#phone').val('');
            $('#email').val('');
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}

init();

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
