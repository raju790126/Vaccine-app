function validateForm() {
 	  var name = document.forms["addMemberForm"]["memname"].value;
 	  var idProof = document.forms["addMemberForm"]["proofno"].value;
 	  
 
      // Simple name validation (not empty)
      if (name.trim() === '') {
        alert('Please enter a valid name.');
        displayError("idError", "Please enter a valid name.");
        return false;
      }

      // ID proof number validation (not empty and max length of 12)
      if (idProof.trim() === '') {
        displayError("idError", "Please enter a valid ID proof number.");
        return false;
      }

      if (idProof.length > 12) {
        displayError("idError", "ID proof number should not exceed 12 characters.");
        return false;
      }

      // If all validations pass, the form will be submitted
      return true;
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