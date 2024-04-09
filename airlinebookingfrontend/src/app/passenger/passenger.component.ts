import { Component, OnInit } from '@angular/core';
import { Passenger } from './passenger.model';
import { PassengerService } from './passenger.service';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { AdminComponent } from '../admin/admin.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { AirportComponent } from '../airport/airport.component';
import { HomePageComponent } from '../home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-passenger',
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
  templateUrl: './passenger.component.html',
  styleUrl: './passenger.component.css',
})
export class PassengerComponent implements OnInit {
  passengers: Passenger[] = [];
  newPassenger: Passenger = { firstName: '', lastName: '', email: '' };
  showAddForm: boolean = false;
  showEditForm: boolean = false;
  selectedPassenger: Passenger | null = null;

  constructor(private passengerService: PassengerService) {}

  ngOnInit(): void {
    this.loadPassengers();
  }

  loadPassengers() {
    this.passengerService.getAllPassengers().subscribe(
      (passengers) => {
        this.passengers = passengers;
      },
      (error) => {
        console.error('Error loading passengers:', error);
      }
    );
  }

  editPassenger(passenger: Passenger) {
    this.selectedPassenger = { ...passenger };
    this.showEditForm = true;
  }

  showAddPassengerForm() {
    this.showAddForm = true;
  }

  deletePassenger(id: number | undefined) {
    if (id !== undefined) {
      this.passengerService.deletePassenger(id).subscribe(
        () => {
          this.loadPassengers();
        },
        (error) => {
          console.error('Error deleting passenger:', error);
        }
      );
    } else {
      console.error('Passenger ID is undefined');
    }
  }

  addPassenger() {
    this.passengerService.addPassenger(this.newPassenger).subscribe(
      () => {
        alert('Passenger added successfully');
        this.loadPassengers();
        this.showAddForm = false;
      },
      (error) => {
        console.error('Error adding passenger:', error);
      }
    );
  }

  updatePassenger() {
    if (this.selectedPassenger && this.selectedPassenger.id !== undefined) {
      const passengerId = this.selectedPassenger.id;

      this.passengerService
        .updatePassenger(passengerId, this.selectedPassenger)
        .subscribe(
          () => {
            alert('Passenger updated successfully');
            this.loadPassengers();
            this.showEditForm = false;
          },
          (error) => {
            console.error('Error updating passenger:', error);
          }
        );
    } else {
      console.error(
        'No passenger selected for editing or passenger ID is undefined'
      );
    }
  }
}