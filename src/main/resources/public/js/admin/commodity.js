function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/commodity?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                var price = response.data[i].price;
                var brand = response.data[i].brand;
                var subcategory = response.data[i].subcategory;
                data +=
                    '<tr>' +
                    '<td>' + id + '</td>' +
                    '<td>' + name + '</td>' +
                    '<td>' + price + '</td>' +
                    '<td>' + brand + '</td>' +
                    '<td>' + subcategory + '</td>' +
                    "<td><button type='button' class='btn btn-primary btn-sm' onclick='update (" + id + ",\"" + name + "\",\"" + price + "\")'>update</button></td>" +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#commodities tbody').html(data);
            initSubcategoryDropdown();
            initBrandDropdown();
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

init();

function initSubcategoryDropdown() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/subcategory/all', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '<option disabled selected>Choose subcategory</option>';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                data += '<option value=' + id + '>' + name + '</option>';
            }
            $('#subcategoryDropdown').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

function initBrandDropdown() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/brand/all', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '<option disabled selected>Choose brand</option>';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                data += '<option value=' + id + '>' + name + '</option>';
            }
            $('#brandDropdown').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

function save() {
    var commodityName = $('#commodityName').val();
    var commodityPrice = $('#commodityPrice').val();
    var subcategoryId = $('#subcategoryDropdown').val();
    var brandId = $('#brandDropdown').val();

    var obj = {
        'name': commodityName,
        'price': commodityPrice,
        'subcategoryId': subcategoryId,
        'brandId': brandId
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/commodity',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#commodityName').val(''); //clean val from input
            $('#commodityPrice').val(''); //clean val from input
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}

//remove commodity by id
function remove(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/commodity?id=' + id,
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


//put old commodity name value into input
function update(id, name, price) {
    console.log(id);
    console.log(name);
    console.log(price);
    $('#commodityName').val(name);
    $('#commodityPrice').val(price);
    $('#saveCommodity').html("<button id='updateSubcategory' class='btn btn-success mx-sm-3 mb-2' onclick='saveUpdatedCommodity(" + id + ")'>Update commodity</button>" +
        "<button id='cancel' class='btn btn-secondary mx-sm-3 mb-2' onclick='cancel()'>Cancel</button>");
}

//cancel update
function cancel() {
    $('#saveCommodity').html("<button class='btn btn-success mb-2' onclick='save()'>Add subcategory</button>");
    $('#commodityName').val(''); //clean val from input
    $('#commodityPrice').val(''); //clean val from input
    initBrandDropdown();
    initSubcategoryDropdown();
}

//save new value of category
function saveUpdatedCommodity(id) {
    var updatedCommodityName = $('#commodityName').val();
    var updatedCommodityPrice = $('#commodityPrice').val();
    var brandId = $('#brandDropdown').val();
    var subcategoryId = $('#subcategoryDropdown').val();
    var obj = {
        'id': id,
        'name': updatedCommodityName,
        'price': updatedCommodityPrice,
        'brandId': brandId,
        'subcategoryId': subcategoryId
    };

    $.ajax({
        type: 'PUT',
        url: 'http://localhost:8080/commodity',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#commodityName').val(''); //clean val from input
            $('#commodityPrice').val(''); //clean val from input
            $('#saveCommodity').html("<button class='btn btn-success mb-2' onclick='save()'>Add commodity</button>");
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}
