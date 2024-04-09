import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pilot } from './pilots.model';

@Injectable({
  providedIn: 'root',
})
export class PilotService {
  private apiUrl = 'http://localhost:8080/pilots';

  constructor(private http: HttpClient) {}

  getPilotById(id: number): Observable<Pilot> {
    return this.http.get<Pilot>(`${this.apiUrl}/${id}`);
  }

  getAllPilots(): Observable<Pilot[]> {
    return this.http.get<Pilot[]>(`${this.apiUrl}/all`);
  }

  createPilot(pilot: Pilot): Observable<Pilot> {
    return this.http.post<Pilot>(`${this.apiUrl}/create`, pilot);
  }

  updatePilot(id: number, updatedPilot: Pilot): Observable<Pilot> {
    return this.http.put<Pilot>(`${this.apiUrl}/${id}`, updatedPilot);
  }

  deletePilot(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
