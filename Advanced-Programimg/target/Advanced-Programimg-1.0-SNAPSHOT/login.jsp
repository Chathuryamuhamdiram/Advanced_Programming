<%-- 
    Document   : login
    Created on : Aug 7, 2023, 5:09:01 PM
    Author     : ashinka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <script>
        function login() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const credentials = {
                email: email,
                password: password
            };

           
            fetch('http://localhost:8080/sessionhandling-rest-service/api/login/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(credentials)
            })
            .then(response => {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error('Login failed');
                }
            })
            .then(token => {
    const parsedToken = token.split('|');
    const receivedToken = parsedToken[0];
    const userType = parsedToken[1];

    localStorage.setItem('token', receivedToken);

    if (userType === 'job_seekers') {
        window.location.href = `jobseekerdashboard.html?token=${receivedToken}`;
    } else if (userType === 'consultant') {
        window.location.href = `consultantdashboard.html?token=${receivedToken}`;
    } else if (userType === 'admin') {
        window.location.href = `admindashboard.html?token=${receivedToken}`;
    } else {
        console.error('Unknown user type:', userType);
    }
})
            .catch(error => {
                console.error('Error:', error);
                document.getElementById('message').innerHTML = 'Invalid credentials.';
            });
        }
    </script>
</head>
<body>
    <h2>Login</h2>
    <form id="loginForm">
        <label for="email">Email</label>
        <input type="text" id="email" name="email"><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>
        <button type="button" onclick="login()">Login</button>
    </form>
    <div id="message"></div>
</body>
</html>
