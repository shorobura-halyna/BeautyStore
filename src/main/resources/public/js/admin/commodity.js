function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/commodity?direction=ASC&page=' + page + '&size=5&sortBy=id',
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
                    "<td><button type='button' class='btn btn-primary btn-sm' onclick='update (" + id + ",\"" + name + "\",\"" + price + "\",\"" + brand + "\",\"" + subcategory + "\")'>update</button></td>" +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#commodities tbody').html(data);
            initSubcategoryDropdown();
            initBrandDropdown();
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
    event.preventDefault();
    var commodityName = $('#commodityName').val();
    var commodityPrice = $('#commodityPrice').val();
    var subcategoryId = $('#subcategoryDropdown').val();
    var brandId = $('#brandDropdown').val();
    var files = document.getElementById("picture").files;
    var pictureParam = files.length > 0 ? files[0] : null;

    var fromData = new FormData();
    fromData.append("name", commodityName);
    fromData.append("price", commodityPrice);
    fromData.append("subcategoryId", subcategoryId);
    fromData.append("brandId", brandId);
    fromData.append("file", pictureParam);

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/commodity',
        // contentType: 'application/json; charset=UTF-8',
        // dataType: 'json',
        processData: false,
        contentType: false,
        data: fromData,
        // headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#commodityName').val(''); //clean val from input
            $('#commodityPrice').val(''); //clean val from input
            init(0);
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
            init(0);
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}


//put old commodity name value into input
function update(id, name, price, brand, subcategory) {
    console.log(id);
    console.log(name);
    console.log(price);
    $('#commodityName').val(name);
    $('#commodityPrice').val(price);
    $("#brandDropdown option:contains(" + brand +")").attr("selected", true);
    $("#subcategoryDropdown option:contains(" + subcategory +")").attr("selected", true);
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
            init(0);
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
