
// modal: Add to Cart
var myModal = document.getElementById('myModal')
var myInput = document.getElementById('myInput')

myModal.addEventListener('shown.bs.modal', function () {
  myInput.focus()
})
// end modal: Add to Cart

function validateSignInEmail() {
  var user = document.getElementById("sign-in-email").value;
  var user2 = document.getElementById("sign-in-email");
  var re = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
  if (re.test(user)) {
    alert("done");
    return true;
  } else {
    user2.style.border = "red solid 3px";
    return false;
  }
}

