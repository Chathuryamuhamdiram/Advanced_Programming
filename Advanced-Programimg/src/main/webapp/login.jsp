
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
    display: flex;
    justify-content: center; /* Center horizontally */
    align-items: center; /* Center vertically */
    min-height: 100vh; /* Ensure the body covers the entire viewport height */
    background-color: #f0f0f0; /* Gray background color */
    font-family: Arial, sans-serif; /* Specify a font family */
}

/* Create a container for the login form and center it on the page */
.container {
    width: 100%; /* Make the container fill the available width */
    max-width: 400px; /* Set a maximum width for the container */
    background-color: #fff; /* Light blue background color */
    border-radius: 5px; /* Rounded corners for the container */
    padding: 20px; /* Add some padding to the container */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Add a slight shadow */
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
    width: 90%; /* Make inputs fill the container */
    padding: 10px; /* Add padding to inputs */
    margin-bottom: 10px; /* Add space between inputs */
    border: 1px solid #ccc; /* Gray border */
    border-radius: 3px; /* Rounded corners for inputs */
}

button {
    width: 95%; /* Make the button fill the container */
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
