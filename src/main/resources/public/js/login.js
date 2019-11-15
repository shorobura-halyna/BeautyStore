$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

//create user
function create() {
   var userName = $('#userName').val();
   var userPassword = $('#userPassword').val();
   var userEmail = $('#userEmail').val();

   var obj = {
      'firstName': userName,
      'password': userPassword,
      'email': userEmail
   };

   $.ajax({
      type: 'POST',
      url: 'http://localhost:8080/user',
      contentType: 'application/json; charset=UTF-8',
      dataType: 'json',
      data: JSON.stringify(obj),
      headers: {'Access-Control-Allow-Origin': '*'},
      success: function (response) {
         console.log('response', response);
         $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
      },
      error: function (e) {
         console.log('error', e);
      }
   });
}