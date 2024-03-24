// Mock data (replace with actual data fetched from backend)
const data = [
    { id: 1, name: 'John Doe', email: 'john@example.com' },
    { id: 2, name: 'Jane Smith', email: 'jane@example.com' },
    { id: 3, name: 'Bob Johnson', email: 'bob@example.com' }
];

// Function to display data in the grid
function displayData() {
    const gridBody = document.querySelector('#data-grid tbody');
    gridBody.innerHTML = '';
    
    data.forEach(item => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.email}</td>
        `;
        gridBody.appendChild(row);
    });
}

// Event listener for login form submission
document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    
    // Mock authentication logic (replace with actual authentication logic)
    if (username === 'admin' && password === 'password') {
        alert('Login successful!');
        displayData();
    } else {
        alert('Invalid username or password. Please try again.');
    }
});
