function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/subcategory?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            initCategoryDropdown();
            var data;
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                var category = response.data[i].category;
                data +=
                    '<tr>' +
                    '<td>' + id + '</td>' +
                    '<td>' + name + '</td>' +
                    '<td>' + category + '</td>' +
                    "<td><button type='button' class='btn btn-primary btn-sm' onclick='update (" + id + ",\"" + name + "\")'>update</button></td>" +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#subcategories tbody').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

function save() {
    var subcategoryName = $('#subcategoryName').val();
    var categoryId = $('#categoryDropdown').val();

    var obj = {
        'name': subcategoryName,
        'categoryId': categoryId
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/subcategory',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#subcategoryName').val(''); //clean val from input
            init();
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
        url: 'http://localhost:8080/subcategory?id=' + id,
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

init();

function initCategoryDropdown() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/category?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '<option selected>Choose category</option>';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                data += '<option value=' + id + '>' + name + '</option>';
            }
            $('#categoryDropdown').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

//put old subcategory name value into input
function update(id, name) {
    console.log(id);
    console.log(name);
    $('#subcategoryName').val(name);
    $('#saveSubcategory').html("<button id='updateSubcategory' class='btn btn-success mx-sm-3 mb-2' onclick='saveUpdatedSubcategory(" + id + ")'>Update subcategory</button>" +
        "<button id='cancel' class='btn btn-secondary mx-sm-3 mb-2' onclick='cancel()'>Cancel</button>");
}

//cancel update
function cancel() {
    $('#saveSubcategory').html("<button class='btn btn-success mb-2' onclick='save()'>Add subcategory</button>");
    $('#subcategoryName').val(''); //clean val from input
    initCategoryDropdown();

}

//save new value of category
function saveUpdatedSubcategory(id) {
    var updatedSubcategoryName = $('#subcategoryName').val();
    var categoryId = $('#categoryDropdown').val();
    var obj = {
        'id': id,
        'name': updatedSubcategoryName,
        'categoryId': categoryId
    };

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/subcategory',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#subcategoryName').val(''); //clean val from input
            $('#saveSubcategory').html("<button class='btn btn-success mb-2' onclick='save()'>Add subcategory</button>");
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}
