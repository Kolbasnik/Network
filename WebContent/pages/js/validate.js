	function validate() {
		var login = document.getElementById("email");
		var password = document.getElementById("password");

		if (login.value == "") {
			alert('Enter email');
			return false;
		}
		if (password.value == "") {
			alert('Enter password');
			return false;
		}
		return true;
	}
