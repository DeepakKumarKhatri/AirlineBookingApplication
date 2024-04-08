import { Routes } from '@angular/router';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AdminComponent } from './admin/admin.component';
import { AirportComponent } from './airport/airport.component';
import { FlightComponent } from './flight/flight.component';
import { PassengerComponent } from './passenger/passenger.component';
import { PilotComponent } from './pilots/pilots.component';

export const routes: Routes = [
  {
    path: '',
    component: HomePageComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'dashboard',
    component: DashboardComponent,
  },
  {
    path: 'admin',
    component: AdminComponent,
  },
  {
    path: 'airport',
    component: AirportComponent,
  },
  {
    path: 'flight',
    component: FlightComponent,
  },
  {
    path: 'passenger',
    component: PassengerComponent,
  },
  {
    path: 'pilot',
    component: PilotComponent,
  },
];
