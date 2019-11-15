function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/category?direction=ASC&page=' + page + '&size=5&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
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
            $('#categories tbody').html(data);
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

function save() {

    var categoryName = $('#categoryName').val();

    var obj = {
        'name': categoryName
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/category',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#categoryName').val(''); //clean val from input
            init(0);
        },
        error: function (e) {
            console.log('error', e);
        }
    });

}

function remove(id) {
    console.log(id);
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/category?id=' + id,
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            init(0);
        },
        error: function (e) {
            console.log('error', e);
        }
    });

}

//put old category name value into input
function update(id, name) {
    console.log(id);
    console.log(name);
    $('#categoryName').val(name);
    $('#saveCategory').html("<button id='updateCategory' class='btn btn-success mx-sm-3 mb-2' onclick='saveUpdatedCategory(" + id + ")'>Update category</button>" +
        "<button id='cancel' class='btn btn-secondary mx-sm-3 mb-2' onclick='cancel()'>Cancel</button>");

}

//cancel update
function cancel() {
    $('#saveCategory').html("<button class='btn btn-success mb-2' onclick='save()'>Add category</button>");
    $('#categoryName').val(''); //clean val from input
}

//save new value of category
function saveUpdatedCategory(id) {
    var updatedCategoryName = $('#categoryName').val();
    var obj = {
        'id': id,
        'name': updatedCategoryName
    };

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/category',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#categoryName').val(''); //clean val from input
            $('#saveCategory').html("<button class='btn btn-success mb-2' onclick='save()'>Add category</button>");
            init(0);
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}