function init(page) {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/purchase?direction=ASC&page=' + page + '&size=5&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var totalAmount = response.data[i].totalAmount;
                var date = response.data[i].date;
                var commodities = response.data[i].commodityResponses;

                var comms = '';
                for (var j = 0; j < commodities.length; j++) {
                    comms += commodities[j].name + ' ' + commodities[j].brand + ' ' + commodities[j].price + '<br>';
                }

                data +=
                    '<tr>' +
                    '<td>' + id + '</td>' +
                    '<td>' + totalAmount + '</td>' +
                    '<td>' + date + '</td>' +
                    '<td>' + comms + '</td>' +
                    '</tr>';
            }
            if (!data) {
                data = '<tr></tr>';
            }
            $('#purchases tbody').html(data);
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

//remove purchase by id
function remove(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/purchase?id=' + id,
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
