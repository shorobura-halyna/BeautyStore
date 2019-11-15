//get and render brands from rest service
function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/brand?direction=ASC&page=' + page + '&size=5&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                var obj = {
                    'id': id,
                    'name': name
                };
                data +=
                    '<tr>' +
                    '<td>' + id + '</td>' +
                    '<td>' + name + '</td>' +
                    "<td><button type='button' class='btn btn-primary btn-sm' onclick='update (" + id + ",\"" + name + "\")'>update</button></td>" +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#brands tbody').html(data);
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

//init brand page
init(0);

//save brand
function save() {
    var brandName = $('#brandName').val();

    var obj = {
        'name': brandName
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/brand',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#brandName').val(''); //clean val from input
            init(0);
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}

//put old brand name value into input 
function update(id, name) {
    console.log(id);
    console.log(name);
    $('#brandName').val(name);
    $('#saveBrand').html("<button id='updateBrand' class='btn btn-success mx-sm-3 mb-2' onclick='saveUpdatedBrand(" + id + ")'>Update brand</button>" +
        "<button id='cancel' class='btn btn-secondary mx-sm-3 mb-2' onclick='cancel()'>Cancel</button>");

}

//cancel update
function cancel() {
    $('#saveBrand').html("<button class='btn btn-success mb-2' onclick='save()'>Add brand</button>");
    $('#brandName').val(''); //clean val from input
}

//save new value of brand
function saveUpdatedBrand(id) {
    var updatedBrandName = $('#brandName').val();
    var obj = {
        'id': id,
        'name': updatedBrandName
    };

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/brand',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#brandName').val(''); //clean val from input
            $('#saveBrand').html("<button class='btn btn-success mb-2' onclick='save()'>Add brand</button>");
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}

//remove brand by id
function remove(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/brand?id=' + id,
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

