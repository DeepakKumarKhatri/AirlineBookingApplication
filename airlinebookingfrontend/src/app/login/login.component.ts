import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, RouterModule } from '@angular/router';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { SignupComponent } from '../signup/signup.component';
import { AdminComponent } from '../admin/admin.component';
import { HomePageComponent } from '../home-page/home-page.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    DashboardComponent,
    LoginComponent,
    SignupComponent,
    AdminComponent,
    HomePageComponent,
    RouterModule,
    CommonModule
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  admins: any[] = [];

  constructor(private http: HttpClient, private router: Router) {
    this.fetchAdmins();
  }

  fetchAdmins() {
    this.http.get<any[]>('http://localhost:8080/admins/all').subscribe(
      (admins) => {
        this.admins = admins;
        console.log('Admins fetched successfully', this.admins);
      },
      (error) => {
        console.error('Error fetching admins:', error);
      }
    );
  }

  login(email: string, password: string) {
    const admin = this.admins.find(
      (admin) => admin.email === email && admin.password === password
    );
    if (admin) {
      alert('Login successful');
      this.router.navigate(['/dashboard']);
    } else {
      alert('Invalid email or password. Please try again.');
    }
  }
}
