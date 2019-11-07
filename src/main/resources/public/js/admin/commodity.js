function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/commodity?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data;
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                var price = response.data[i].price;
                data +=
                    '<tr>' +
                    '<td>' + id + '</td>' +
                    '<td>' + name + '</td>' +
                    '<td>' + price + '</td>' +
                    '<td><button type="button" class="btn btn-primary btn-sm">update</button></td>' +
                    '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data){
                data = '<tr></tr>';
            }
            $('#commodities tbody').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

init();