function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/purchase?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination f...
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data = '';
            for (var i = 0; i < response.data.length; i++) {
                var totalAmount = response.data[i].totalAmount;
                var date = response.data[i].date;
                var commodities = response.data[i].commodityResponses;

                var comms = '';
                for (var j = 0; j < commodities.length; j++){
                    comms += commodities[j].name + ' ' + commodities[j].brand + ' ' + commodities[j].price + '<br>';
                }

                data +=
                    '<tr>' +
                    '<td>' + totalAmount + '</td>' +
                    '<td>' + date + '</td>' +
                    '<td>' + comms + '</td>' +
                    '</tr>';
            }
            if (!data){
                data = '<tr></tr>';
            }
            $('#purchases tbody').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }

    })
}

init();