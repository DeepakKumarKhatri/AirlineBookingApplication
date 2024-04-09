import { Component, OnInit } from '@angular/core';
import { Flight } from './flight.model';
import { FlightService } from './flight.service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { AdminComponent } from '../admin/admin.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { HomePageComponent } from '../home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { AirportComponent } from '../airport/airport.component';

@Component({
  selector: 'app-flight',
  standalone: true,
  imports: [
    CommonModule,
    DashboardComponent,
    AdminComponent,
    LoginComponent,
    SignupComponent,
    AirportComponent,
    HomePageComponent,
    FormsModule,
    RouterModule,
  ],
  templateUrl: './flight.component.html',
  styleUrl: './flight.component.css',
})
export class FlightComponent implements OnInit {
  flights: Flight[] = [];
  newFlight: Flight = {
    flightNumber: '',
    departureAirport: '',
    arrivalAirport: '',
    departureTime: '',
    arrivalTime: '',
  };
  selectedFlight: Flight | null = null;
  showAddForm: boolean = false;
  showEditForm: boolean = false;

  constructor(private flightService: FlightService) {}

  ngOnInit(): void {
    this.loadFlights();
  }

  loadFlights() {
    this.flightService.getAllFlights().subscribe(
      (flights) => {
        this.flights = flights;
      },
      (error) => {
        console.error('Error loading flights:', error);
      }
    );
  }

  showAddFlightForm() {
    this.showAddForm = true;
  }

  addFlight() {
    this.flightService.createFlight(this.newFlight).subscribe(
      (response) => {
        alert('Flight created successfully');
        this.loadFlights();
        this.showAddForm = false;
      },
      (error) => {
        console.error('Error creating flight:', error);
      }
    );
  }

  editFlight(flight: Flight) {
    this.selectedFlight = { ...flight };
    this.showEditForm = true;
  }

  createFlight() {
    this.flightService.createFlight(this.newFlight).subscribe(
      (response) => {
        alert('Flight created successfully');
        this.loadFlights();
      },
      (error) => {
        console.error('Error creating flight:', error);
      }
    );
  }

  updateFlight() {
    if (this.selectedFlight) {
      this.flightService
        .updateFlight(this.selectedFlight.id!, this.selectedFlight)
        .subscribe(
          (response) => {
            alert('Flight updated successfully');
            this.loadFlights();
            this.showEditForm = false;
          },
          (error) => {
            console.error('Error updating flight:', error);
          }
        );
    } else {
      console.error('No flight selected for editing');
    }
  }

  deleteFlight(id: number | undefined) {
    if (id !== undefined) {
      this.flightService.deleteFlight(id).subscribe(
        () => {
          this.loadFlights();
        },
        (error) => {
          console.error('Error deleting flight:', error);
        }
      );
    } else {
      console.error('Flight ID is undefined');
    }
  }
}
