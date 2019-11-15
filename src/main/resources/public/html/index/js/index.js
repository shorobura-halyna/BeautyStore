function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/commodity?direction=ASC&page=' + page + '&size=8&sortBy=id', //  TODO: add pagination f...
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
                var pictureUrl = response.data[i].urlToPicture;
                data +=
                    '<div class="col-lg-3 col-md-6 mb-4">' +
                    '<div class="card h-100">' +
                    '<img id="commodityImage" class="card-img-top" src="http://localhost:8080/' + pictureUrl + '" alt="pic" width="500" height="325">' +
                    '<div class="card-body">' +
                    '<h4 class="card-title"><b>' + name + '</b></h4>' +
                    '<h6 class="card-title">' + brand + '</h6>' +
                    '<h6 class="card-title">' + subcategory + '</h6>' +
                    '<h6 class="card-title"><b>' + price + '</b></h6>' +
                    '</div>' +
                    '<div class="card-footer">' +
                    '<a href="#" class="btn btn-primary">add to cart</a> ' +
                    "<a href='#' class='btn btn-primary' onclick='details(" + id + ")'>details</a>" +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
            }
            $('#commodities').html(data);
            var paginationData = '';

            for (var i = 0; i <= response.numberOfPages - 1; i++) {
                var j = i + 1;
                if (i === page) {
                    paginationData += "<li class='page-item'><span id='currentPage' class='page-link'>" + j + "<span class='sr-only'>(current)</span></span></li>";
                } else {
                    paginationData += "<li class='page-item'><a class='page-link' onclick='init(" + i + ")'>" + j + "</a></li>";
                }
            }

            $('#pagination').html(paginationData);
            initPriceFilter();
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

init(0);

function details(id) {
    $('#index').html('');
    $('#footer').remove();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/commodity/one?id=' + id,
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log(response);
            renderProductDetails(response);
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

function renderProductDetails(commodity) {
    var productDetails =
        '<div id="products" class="row list-group">\n' +
        '        <div class="item  col-xs-4 col-lg-4">\n' +
        '            <div class="thumbnail">\n' +
        '                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />\n' +
        '                <div class="caption">\n' +
        '                    <h4 class="group inner list-group-item-heading">' + commodity.name + '</h4>\n' +
        '                    <h6 class="group inner list-group-item-heading">' + commodity.brand + '</h6>\n' +
        '                    <h6 class="group inner list-group-item-heading">' + commodity.subcategory + '</h6>\n' +
        '                    <div class="row">\n' +
        '                        <div class="col-xs-12 col-md-6">\n' +
        '                            <p class="lead">' + commodity.price + '$</p>\n' +
        '                        </div>\n' +
        '                        <div class="col-xs-12 col-md-6">\n' +
        '                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>\n' +
        '                        </div>\n' +
        '                    </div>\n' +
        '                </div>\n' +
        '            </div>\n' +
        '        </div>' +
        '</div>';

    $('#index').html(productDetails);
}

function initPriceFilter() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/commodity/price/max',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            $('#priceFilter').attr({"max": response});
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

function applyRangeFilter() {
    var value = $('#priceFilter').val();
    var page = $('#currentPage').html()[0] - 1;
    console.log(value);
    console.log(page);

    var obj = {
        'oneFilterCommodityRequests': [
            {
                'commoditySearchCriteria': 'BY_PRICE_LESS_THEN',
                'firstValue': value,
                'secondValue': ''
            }
        ]
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/commodity/filter?direction=ASC&page=' + page + '&size=8&sortBy=id',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        data: JSON.stringify(obj),
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                var price = response.data[i].price;
                var brand = response.data[i].brand;
                var subcategory = response.data[i].subcategory;
                var pictureUrl = response.data[i].urlToPicture;
                data +=
                    '<div class="col-lg-3 col-md-6 mb-4">' +
                    '<div class="card h-100">' +
                    '<img id="commodityImage" class="card-img-top" src="http://localhost:8080/' + pictureUrl + '" alt="pic" width="500" height="325">' +
                    '<div class="card-body">' +
                    '<h4 class="card-title"><b>' + name + '</b></h4>' +
                    '<h6 class="card-title">' + brand + '</h6>' +
                    '<h6 class="card-title">' + subcategory + '</h6>' +
                    '<h6 class="card-title"><b>' + price + '</b></h6>' +
                    '</div>' +
                    '<div class="card-footer">' +
                    '<a href="#" class="btn btn-primary">add to cart</a> ' +
                    "<a href='#' class='btn btn-primary' onclick='details(" + id + ")'>details</a>" +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
            }
            $('#commodities').html(data);
            var paginationData = '';

            for (var i = 0; i <= response.numberOfPages - 1; i++) {
                var j = i + 1;
                if (i === page) {
                    paginationData += "<li class='page-item'><span id='currentPage' class='page-link'>" + j + "<span class='sr-only'>(current)</span></span></li>";
                } else {
                    paginationData += "<li class='page-item'><a class='page-link' onclick='changePageWithFilter(" + i + ")'>" + j + "</a></li>";
                }
            }

            $('#pagination').html(paginationData);
            initPriceFilter();
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}


function changePageWithFilter(page) {
    var value = $('#priceFilter').val();

    var obj = {
        'oneFilterCommodityRequests': [
            {
                'commoditySearchCriteria': 'BY_PRICE_LESS_THEN',
                'firstValue': value,
                'secondValue': ''
            }
        ]
    };
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/commodity/filter?direction=ASC&page=' + page + '&size=8&sortBy=id',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        data: JSON.stringify(obj),
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                var price = response.data[i].price;
                var brand = response.data[i].brand;
                var subcategory = response.data[i].subcategory;
                var pictureUrl = response.data[i].urlToPicture;
                data +=
                    '<div class="col-lg-3 col-md-6 mb-4">' +
                    '<div class="card h-100">' +
                    '<img id="commodityImage" class="card-img-top" src="http://localhost:8080/' + pictureUrl + '" alt="pic" width="500" height="325">' +
                    '<div class="card-body">' +
                    '<h4 class="card-title"><b>' + name + '</b></h4>' +
                    '<h6 class="card-title">' + brand + '</h6>' +
                    '<h6 class="card-title">' + subcategory + '</h6>' +
                    '<h6 class="card-title"><b>' + price + '</b></h6>' +
                    '</div>' +
                    '<div class="card-footer">' +
                    '<a href="#" class="btn btn-primary">add to cart</a> ' +
                    "<a href='#' class='btn btn-primary' onclick='details(" + id + ")'>details</a>" +
                    '</div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
            }
            $('#commodities').html(data);
            var paginationData = '';

            for (var i = 0; i <= response.numberOfPages - 1; i++) {
                var j = i + 1;
                if (i === page) {
                    paginationData += "<li class='page-item'><span id='currentPage' class='page-link'>" + j + "<span class='sr-only'>(current)</span></span></li>";
                } else {
                    paginationData += "<li class='page-item'><a class='page-link' onclick='changePageWithFilter(" + i + ")'>" + j + "</a></li>";
                }
            }

            $('#pagination').html(paginationData);
            initPriceFilter();
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

function showPriceFilterValue() {
    var value = $('#priceFilter').val();
    $('#priceFilterValue').html(value);
}

function dropAllFilters() {
    init(0);
    $('#priceFilter').val(0);
    $('#priceFilterValue').html(0);
}