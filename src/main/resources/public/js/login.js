$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

//create user
function create() {
   var login = $('#loginForRegistration').val();
   var userPassword = $('#passwordForRegistration').val();
   var userEmail = $('#userEmail').val();

   var obj = {
      'login': login,
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

function login() {
   var login = $('#loginForLogin').val();
   var userPassword = $('#passwordForLogin').val();

   var obj = {
      'login': login,
      'password': userPassword
   };

   $.ajax({
      type: 'POST',
      url: 'http://localhost:8080/login',
      contentType: 'application/json; charset=UTF-8',
      dataType: 'json',
      data: JSON.stringify(obj),
      headers: {'Access-Control-Allow-Origin': '*'},
      success: function (response) {
         console.log('response', response);
         if ('ADMIN' === response.role) {
            window.location.replace("../html/admin/brand.html");
         } else {
            window.location.replace("../html/index/index.html");
         }
      },
      error: function (e) {
         console.log('error', e);
      }
   });
}