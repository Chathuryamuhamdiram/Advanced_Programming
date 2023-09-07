
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    text-align: center;
    margin: 0;
    padding: 0;
}

h2 {
    color: #333;
}

#loginForm {
    background-color: #fff;
    border-radius: 10px;
    width: 300px;
    margin: 0 auto;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

label {
    display: block;
    text-align: left;
    margin-bottom: 5px;
    font-weight: bold;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 15px;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    cursor: pointer;
    transition: background-color 0.3s;
}

button:hover {
    background-color: #0056b3;
}

#message {
    color: #d9534f;
    font-weight: bold;
    margin-top: 10px;
}
  nav {
      display: flex;
      justify-content: space-between;
      align-items: center;
      margin: 0 auto;
      max-width: 1200px;
      padding: 0 20px;
    }

    nav ul {
      list-style-type: none;
      margin: 0;
      padding: 0;
      display: flex;
    }

    nav ul li {
      margin-right: 20px;
    }

    nav ul li a {
      color: white;
      text-decoration: none;
      font-weight: bold;
      transition: color 0.3s ease;
    }

    nav ul li a:hover {
      color: #007bff;
    }

    </style>
    <title>Login Page</title>
    <script>
        function login() {
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const credentials = {
                email: email,
                password: password
            };

           
            fetch('http://localhost:8080/Advanced-Programming-Rest-Service/resources/login/', {
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
