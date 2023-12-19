function login()
	{
		var uname = document.getElementById("email").value;
		var pwd = document.getElementById("pass").value;
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		clearErrors();
		
		if(uname =='')
		{
			 displayError("emailError", "please enter user name.");
                return false;
		}
		
		else if(!filter.test(uname))
		{
			displayError("emailError", "Enter valid email id.");
                return false;
		}
		else if (!uname.endsWith("@gmail.com")) {
                displayError("emailError", "Email must end with @gmail.com");
                return false;
            }
         else if (pwd === "") {
                displayError("passwordError", "Password cannot be empty");
                return false;
            }
           else if (!isPasswordValid(pwd)) {
                displayError("passwordError", "Password must contain at least one uppercase letter, one lowercase letter, one special character, and one numeric character, and be between 8 and 15 characters");
                return false;
            }
		return true;
	}
	 function isPasswordValid(password) {
            // Password must contain at least one uppercase letter, one lowercase letter, one special character, and one numeric character
            // and be between 8 and 15 characters
            var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$/;
            return regex.test(password);
        }
        function displayError(elementId, errorMessage) {
            var errorElement = document.getElementById(elementId);
            errorElement.style.color = "red";
            errorElement.innerHTML = errorMessage;
        }
	//Reset Inputfield code.
	function clearFunc()
	{
		document.getElementById("email").value="";
		document.getElementById("pwd1").value="";
	}	
	function clearErrors() {
            // Clear all error messages
            var errorElements = document.getElementsByClassName("error-message");
            for (var i = 0; i < errorElements.length; i++) {
                errorElements[i].innerHTML = "";
            }
        }