function init() {
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/brand?direction=ASC&page=0&size=100&sortBy=id', //  TODO: add pagination feature
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            var data;
            for (var i = 0; i < response.data.length; i++) {
                var id = response.data[i].id;
                var name = response.data[i].name;
                data +=
                    '<tr>' +
                        '<td>' + id + '</td>' +
                        '<td>' + name + '</td>' +
                        '<td><button type="button" class="btn btn-primary btn-sm">update</button></td>' +
                        '<td><button type="button" class="btn btn-primary btn-sm btn-danger" onclick=remove(' + id + ')>delete</button></td>' +
                    '</tr>';
            }
            $('#brands tbody').html(data);
        },
        error: function (e) {
            console.log('error', e);
        }
    })
}

function save() {
    var brandName = $('#brandName').val();

    var obj = {
        'name': brandName
    };

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/brand',
        contentType: 'application/json; charset=UTF-8',
        dataType: 'json',
        data: JSON.stringify(obj),
        headers: {'Access-Control-Allow-Origin': '*'},
        success: function (response) {
            console.log('response', response);
            $('#brandName').val(''); //clean val from input
            init();
        },
        error: function (e) {
            console.log('error', e);
        }
    });
}

function update() {

}

function remove(id) {
    $.ajax({
        type: 'DELETE',
        url: 'http://localhost:8080/brand?id=' + id,
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