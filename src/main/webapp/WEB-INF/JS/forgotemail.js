function validateForm() {
        var email = document.forms["forgotForm"]["useremail"].value;
        var password = document.forms["forgotForm"]["newpassword"].value;
        var confirmPassword = document.forms["forgotForm"]["confirmpassword"].value;

        // Clear previous error messages
        clearErrors();
		
        // Email validation
        if (!email.endsWith("@gmail.com")) {
            displayError("emailError", "Email must end with @gmail.com");
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