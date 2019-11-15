function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/basket?direction=ASC&page=' + page + '&size=5&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            var commodities = response.data[0].commodities;
            for (var i = 0; i < commodities.length; i++) {
                data +=
                    '<tr>' +
                    '<td>' + commodities[i].name + '</td>' +
                    '<td>' + commodities[i].brand + '</td>' +
                    '<td>' + commodities[i].price + '</td>' +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + commodities[i].id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#basket tbody').html(data);
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

//remove brand by id
function remove(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/basket?id=' + id,
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

function buyAllCommodities() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/basket/buy',
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