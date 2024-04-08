import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css',
})
export class SignupComponent {
  constructor(private http: HttpClient, private router: Router) {}

  signUp(
    event: Event,
    fullName: string,
    email: string,
    password: string,
    confirmPassword: string
  ) {
    event.preventDefault();
    const userData = {
      fullName: fullName,
      email: email,
      password: password,
      confirmPassword: confirmPassword,
    };

    this.http.post('http://localhost:8080/admins/create', userData).subscribe(
      (response) => {
        alert('Signup successful');
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Signup Failed');
      }
    );
  }
}
