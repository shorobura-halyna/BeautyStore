function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/basket?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            var commodities = response.data[0].commodities;
            for (var i = 0; i < commodities.length; i++){
                data +=
                    '<tr>' +
                        '<td>' + commodities[i].name + '</td>' +
                        '<td>' + commodities[i].brand + '</td>' +
                        '<td>' + commodities[i].price + '</td>' +
                        '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + commodities[i].id + ')>delete</button></td>' +
                    '</tr>';
            }
            if (!data){
                data = '<tr></tr>';
            }
            $('#basket tbody').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

init();

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