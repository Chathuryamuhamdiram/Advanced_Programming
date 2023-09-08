
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        
/* Reset default margin and padding for the entire page */
body, h2, form {
    margin: 0;
    padding: 0;
}

/* Apply gray background to the entire body */
body {
    background-color: lightskyblue; /* Gray background color */
    font-family: Arial, sans-serif; /* Specify a font family */
}

header {
    background-color: gray; /* Set your desired background color */
    padding: 20px 0;
    width: 100%;
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

    .auth-buttons a {
      margin-left: 20px;
      padding: 8px 20px;
      border: 1px solid white;
      border-radius: 5px;
      text-decoration: none;
      color: white;
      transition: background-color 0.3s ease;
    }

    .auth-buttons a:hover {
      background-color: #007bff;
    }

/* Create a container for the login form and center it on the page */
.container {
    width: 100%; /* Make the container fill the available width */
    max-width: 400px; /* Set a maximum width for the container */
    background-color: #fff; /* Light blue background color */
    margin: 0 auto; /* Center the container horizontally */
    padding: 40px; /* Add some padding to the container */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add a slight shadow */
    position: absolute; /* Position the container */
    top: 50%; /* Move the container down by 50% of its height */
    left: 50%; /* Move the container right by 50% of its width */
    transform: translate(-50%, -50%); /* Center the container both horizontally and vertically */
}

/* Style the h2 header */
h2 {
    text-align: center; /* Center the text */
    color: #333; /* Dark gray text color */
}

/* Style form elements */
form label {
    display: block; /* Display labels as blocks */
    margin-bottom: 5px; /* Add space below labels */
    color: #333; /* Dark gray text color */
}

form input[type="text"],
form input[type="password"] {
    width: 100%; /* Make inputs fill the container */
    padding: 10px; /* Add padding to inputs */
    margin-bottom: 10px; /* Add space between inputs */
    border: 1px solid #ccc; /* Gray border */
    border-radius: 3px; /* Rounded corners for inputs */
}

button {
    width: 100%; /* Make the button fill the container */
    padding: 10px; /* Add padding to the button */
    background-color: #2196F3; /* Blue button color */
    color: #fff; /* White text color */
    border: none; /* Remove button border */
    border-radius: 3px; /* Rounded corners for the button */
    cursor: pointer; /* Add a pointer cursor on hover */
}

button:hover {
    background-color: #0e7ac4; /* Darker blue on hover */
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
    <header>
        <nav>
            <ul>
                <li><a href="Home.html">Home</a></li>
                <li><a href="#">About</a></li>
                <li><a href="#">Services</a></li>
                <li><a href="#">Contact</a></li>
            </ul>
            <div class="auth-buttons">
                <a href="login.jsp" class="login-button">Login</a>
                <a href="registration.html" class="register-button">Register</a>
            </div>
        </nav>
    </header>
    <div class="container">
        <h2>Login</h2>
        <form id="loginForm">
            <label for="email">Email</label>
            <input type="text" id="email" name="email"><br><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br><br>
            <button type="button" onclick="login()">Login</button>
        </form>
        <div id="message"></div>
    </div>
</body>
</html>
