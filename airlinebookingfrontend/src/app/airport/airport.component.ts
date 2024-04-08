import { Component, OnInit } from '@angular/core';
import { Airport } from './airport.model';
import { AirportService } from './airport.service';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { AdminComponent } from '../admin/admin.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { HomePageComponent } from '../home-page/home-page.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-airport',
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
    RouterModule
  ],
  templateUrl: './airport.component.html',
  styleUrl: './airport.component.css',
})
export class AirportComponent implements OnInit {
  airports: Airport[] = [];
  newAirport: Airport = { code: '', name: '', country: '', city: '' };
  showAddForm: boolean = false;
  showEditForm: boolean = false;
  selectedAirport: Airport | null = null;

  constructor(private airportService: AirportService, private router: Router) {}

  ngOnInit(): void {
    this.loadAirports();
  }

  loadAirports() {
    this.airportService.getAllAirports().subscribe(
      (airports) => {
        this.airports = airports;
      },
      (error) => {
        console.error('Error loading airports:', error);
      }
    );
  }

  editAirport(airport: Airport) {
    this.selectedAirport = { ...airport };
    this.showEditForm = true;
  }
  showAddAirportForm() {
    this.showAddForm = true;
  }

  deleteAirport(id: number | undefined) {
    if (id !== undefined) {
      this.airportService.deleteAirport(id).subscribe(
        () => {
          this.loadAirports();
        },
        (error) => {
          console.error('Error deleting airport:', error);
        }
      );
    } else {
      console.error('Airport ID is undefined');
    }
  }

  addAirport() {
    this.airportService.addAirport(this.newAirport).subscribe(
      (response) => {
        alert('Airport added successfully');
        this.loadAirports();
        this.showAddForm = false;
      },
      (error) => {
        console.error('Error adding airport:', error);
      }
    );
  }

  updateAirport() {
    if (this.selectedAirport) {
      const airportId = this.selectedAirport.id;

      if (airportId !== undefined) {
        // Update the selectedAirport object with the new values from the form
        const updatedAirport: Airport = {
          ...this.selectedAirport,
          name: this.selectedAirport.name,
          country: this.selectedAirport.country,
          city: this.selectedAirport.city,
        };

        this.airportService.updateAirport(updatedAirport).subscribe(
          (response) => {
            alert('Airport updated successfully');
            this.loadAirports();
            this.showEditForm = false;
          },
          (error) => {
            console.error('Error updating airport:', error);
          }
        );
      } else {
        console.error('Airport ID is undefined');
      }
    } else {
      console.error('No airport selected for editing');
    }
  }
}
