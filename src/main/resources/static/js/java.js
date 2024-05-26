document.addEventListener('DOMContentLoaded', () => {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const signInFormButton = document.getElementById('signInButton');
    const container = document.getElementById('container');

    signUpButton.addEventListener('click', () => {
        container.classList.add('right-panel-active');
    });

    signInButton.addEventListener('click', () => {
        container.classList.remove('right-panel-active');
    });

    function switchToSignInPanel() {
        container.classList.remove('right-panel-active');
    }

    function submitSignUpForm() {
        const userName = document.getElementById('userName').value;
        const firstName = document.getElementById('firstName').value;
        const lastName = document.getElementById('lastName').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const phoneNum = document.getElementById('phone_num').value;
        const jobName = document.getElementById('jobName').value;

        const data = {
            user_name: userName,
            firstName: firstName,
            lastName: lastName,
            email: email,
            password: password,
            phone_num: phoneNum,
            job: {jobName: jobName}
        };

        fetch('/api/user/newUser', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Something went wrong');
                }
            })
            .then(data => {
                console.log('Success:', data);
                switchToSignInPanel(); // Switch to sign-in panel after successful sign-up
            })
            .catch(error => {
                console.error('Error:', error);
            });
    }

    function submitSignInForm() {
        const email = document.getElementById('signInEmail').value;
        const password = document.getElementById('signInPassword').value;

        const data = {
            email: email,
            password: password
        };

        fetch('/api/user/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Invalid email or password');
                }
            })
            .then(data => {
                console.log('Success:', data);
                window.location.href = '/index?userId=' + data.id; // Redirect to the home endpoint
            })
            .catch(error => {
                console.error('Error:', error);
                alert('Invalid email or password');
            });
    }

    document.getElementById('signUpForm').addEventListener('submit', (event) => {
        event.preventDefault();
        submitSignUpForm();
    });

    document.getElementById('signInForm').addEventListener('submit', (event) => {
        event.preventDefault();
        submitSignInForm();
    });
});