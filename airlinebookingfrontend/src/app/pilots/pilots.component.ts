import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Pilot } from './pilots.model';
import { PilotService } from './pilots.service';
import { DashboardComponent } from '../dashboard/dashboard.component';
import { AdminComponent } from '../admin/admin.component';
import { LoginComponent } from '../login/login.component';
import { SignupComponent } from '../signup/signup.component';
import { AirportComponent } from '../airport/airport.component';
import { HomePageComponent } from '../home-page/home-page.component';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-pilots',
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
  templateUrl: './pilots.component.html',
  styleUrl: './pilots.component.css',
})
  
export class PilotComponent implements OnInit {
  pilots: Pilot[] = [];
  newPilot: Pilot = { firstName: '', lastName: '', email: '', phone: '' };
  showAddForm: boolean = false;
  showEditForm: boolean = false;
  selectedPilot: Pilot | null = null;

  constructor(private pilotService: PilotService) {}

  ngOnInit(): void {
    this.loadPilots();
  }

  loadPilots() {
    this.pilotService.getAllPilots().subscribe(
      (pilots) => {
        this.pilots = pilots;
      },
      (error) => {
        console.error('Error loading pilots:', error);
      }
    );
  }

  editPilot(pilot: Pilot) {
    this.selectedPilot = { ...pilot };
    this.showEditForm = true;
  }

  showAddPilotForm() {
    this.showAddForm = true;
  }

  deletePilot(id: number | undefined) {
    if (id !== undefined) {
      this.pilotService.deletePilot(id).subscribe(
        () => {
          this.loadPilots();
        },
        (error) => {
          console.error('Error deleting pilot:', error);
        }
      );
    } else {
      console.error('Pilot ID is undefined');
    }
  }

  addPilot() {
    this.pilotService.createPilot(this.newPilot).subscribe(
      (response) => {
        alert('Pilot added successfully');
        this.loadPilots();
        this.showAddForm = false;
      },
      (error) => {
        console.error('Error adding pilot:', error);
      }
    );
  }

  updatePilot() {
    if (this.selectedPilot && this.selectedPilot.id !== undefined) {
      const pilotId = this.selectedPilot.id;

      const updatedPilot: Pilot = {
        ...this.selectedPilot,
      };

      this.pilotService.updatePilot(pilotId, updatedPilot).subscribe(
        (response) => {
          alert('Pilot updated successfully');
          this.loadPilots();
          this.showEditForm = false;
        },
        (error) => {
          console.error('Error updating pilot:', error);
        }
      );
    } else {
      console.error('No pilot selected for editing');
    }
  }
}