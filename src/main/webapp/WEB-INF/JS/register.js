
        function validateForm() {
        	var id = document.forms["registrationForm"]["id"].value;
            var name = document.forms["registrationForm"]["username"].value;
            var email = document.forms["registrationForm"]["email"].value;
            var password = document.forms["registrationForm"]["password"].value;
            var confirmPassword = document.forms["registrationForm"]["confirmPassword"].value;
            var mobileNumber = document.forms["registrationForm"]["mobile"].value;
			var emailSuffixes = ["@bvcgroup.in", "@gmail.com"];
			var validEmail = emailSuffixes.some(suffix => email.endsWith(suffix));

            // Clear previous error messages
            clearErrors();
			
            if (id === "" || parseInt(id) <= 0 || isNaN(parseInt(id))) {
                displayError("idError", "ID must not be null, and should be a positive integer");
                return false;
            }

            // Name validation
            if (name == "" || name.trim() == "") {
                displayError("nameError", "Name must not be null or consist of only spaces");
                return false;
            }
            // Email validation
            if (!validEmail) {
                displayError("emailError", "Email must end with @gmail.com or @bvcgroup.in");
                return false;
            }

            // Password validation
            if (password === "") {
                displayError("passwordError", "Password cannot be empty");
                return false;
            }
            if (!isPasswordValid(password)) {
                displayError("passwordError", "Password must contain at least one uppercase letter, one lowercase letter, one special character, and one numeric character, and be between 8 and 15 characters");
                return false;
            }

            // Confirm password validation
            if (confirmPassword !== password) {
                displayError("confirmPasswordError", "Passwords do not match");
                return false;
            }

            // Mobile number validation
            if (!/^([6-9])\d{9}$/.test(mobileNumber)) {
                displayError("mobileError", "Phone number must start with 6, 7, 8, or 9 and have 10 digits in total");
                return false;
            }

            // Add more validations as needed

            return true; // Submit the form if all validations pass
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

        function clearErrors() {
            // Clear all error messages
            var errorElements = document.getElementsByClassName("error-message");
            for (var i = 0; i < errorElements.length; i++) {
                errorElements[i].innerHTML = "";
            }
        }
