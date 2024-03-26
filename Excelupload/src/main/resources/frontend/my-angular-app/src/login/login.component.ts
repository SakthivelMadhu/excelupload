// login.component.ts
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html'
})
export class LoginComponent {
  username: string;
  password: string;

  constructor(private router: Router) {}

  login() {
    // Implement login logic here
    if (this.username === 'admin' && this.password === 'password') {
      this.router.navigateByUrl('/dashboard');
    } else {
      alert('Invalid username or password');
    }
  }
}
