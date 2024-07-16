<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page language="java" import="java.util.Arrays" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <script>
            function validateForm() {
                let isValid = true;
                const password = document.getElementById("password").value;
                const email = document.getElementById("email").value;
                const phoneNumber = document.getElementById("phone_number").value;
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                const phonePattern = /^0\d+$/;

                document.getElementById("passwordError").innerHTML = "";
                document.getElementById("emailError").innerHTML = "";
                document.getElementById("nameError").innerHTML = "";
                document.getElementById("usernameError").innerHTML = "";
                document.getElementById("phoneError").innerHTML = "";
                document.getElementById("genderError").innerHTML = "";
                document.getElementById("hobbiesError").innerHTML = "";

                if (password.length <= 6) {
                    document.getElementById("passwordError").innerHTML = "Password must be more than 6 characters.";
                    isValid = false;
                }

                if (!emailPattern.test(email)) {
                    document.getElementById("emailError").innerHTML = "Invalid email format.";
                    isValid = false;
                }

                if (!phonePattern.test(phoneNumber)) {
                    document.getElementById("phoneError").innerHTML = "Phone number is required and must start with 0.";
                    isValid = false;
                }

                if (document.getElementById("full_name").value.trim() === "") {
                    document.getElementById("nameError").innerHTML = "Full Name is required.";
                    isValid = false;
                }

                if (document.getElementById("username").value.trim() === "") {
                    document.getElementById("usernameError").innerHTML = "Username is required.";
                    isValid = false;
                }

                const genderSelected = document.querySelector('input[name="gender"]:checked');
                if (!genderSelected) {
                    document.getElementById("genderError").innerHTML = "Gender is required.";
                    isValid = false;
                }

                const hobbiesSelected = document.querySelectorAll('input[name="hobbies"]:checked');
                if (hobbiesSelected.length === 0) {
                    document.getElementById("hobbiesError").innerHTML = "At least one hobby must be selected.";
                    isValid = false;
                }

                return isValid;
            }
        </script>
    </head>
    <body>
        <h2>Register</h2>
        <form action="register" method="post" onsubmit="return validateForm();">
            <label for="full_name">Full Name:</label>
            <input type="text" id="full_name" name="full_name" value="<%= session.getAttribute("fullName") != null ? session.getAttribute("fullName") : "" %>">
            <span id="nameError" style="color: red;"></span><br><br>

            <label>Gender:</label>
            <input type="radio" id="male" name="gender" value="male" <%= "male".equals(session.getAttribute("gender")) ? "checked" : "" %>>
            <label for="male">Male</label>
            <input type="radio" id="female" name="gender" value="female" <%= "female".equals(session.getAttribute("gender")) ? "checked" : "" %>>
            <label for="female">Female</label>
            <span id="genderError" style="color: red;"></span><br><br>

            <label>Hobbies:</label>
            <input type="checkbox" id="fishing" name="hobbies" value="fishing" <%= session.getAttribute("hobbies") != null && Arrays.asList((String[]) session.getAttribute("hobbies")).contains("fishing") ? "checked" : "" %>>
            <label for="fishing">Fishing</label>
            <input type="checkbox" id="walking" name="hobbies" value="walking" <%= session.getAttribute("hobbies") != null && Arrays.asList((String[]) session.getAttribute("hobbies")).contains("walking") ? "checked" : "" %>>
            <label for="walking">Walking</label>
            <input type="checkbox" id="reading" name="hobbies" value="reading" <%= session.getAttribute("hobbies") != null && Arrays.asList((String[]) session.getAttribute("hobbies")).contains("reading") ? "checked" : "" %>>
            <label for="reading">Reading</label>
            <input type="checkbox" id="swimming" name="hobbies" value="swimming" <%= session.getAttribute("hobbies") != null && Arrays.asList((String[]) session.getAttribute("hobbies")).contains("swimming") ? "checked" : "" %>>
            <label for="swimming">Swimming</label>
            <span id="hobbiesError" style="color: red;"></span><br><br>

            <label for="job">Job:</label>
            <select id="job" name="job">
                <option value="teacher" <%= "teacher".equals(session.getAttribute("job")) ? "selected" : "" %>>Teacher</option>
                <option value="student" <%= "student".equals(session.getAttribute("job")) ? "selected" : "" %>>Student</option>
                <option value="developer" <%= "developer".equals(session.getAttribute("job")) ? "selected" : "" %>>Developer</option>
            </select><br><br>

            <label for="username">Username:</label>
            <input type="text" id="username" name="username" value="<%= session.getAttribute("username") != null ? session.getAttribute("username") : "" %>">
            <span id="usernameError" style="color: red;"></span><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <span id="passwordError" style="color: red;"></span><br><br>

            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="<%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>">
            <span id="emailError" style="color: red;"></span><br><br>

            <label for="phone_number">Phone Number:</label>
            <input type="text" id="phone_number" name="phone_number" value="<%= session.getAttribute("phoneNumber") != null ? session.getAttribute("phoneNumber") : "" %>">
            <span id="phoneError" style="color: red;"></span><br><br>

            <input type="submit" value="Register">
        </form>
        <% 
            if (session.getAttribute("errorMessage") != null) {
                out.println("<div style='color: red;'>" + session.getAttribute("errorMessage") + "</div>");
                session.removeAttribute("errorMessage");
            }
        %>
    </body>
</html>
