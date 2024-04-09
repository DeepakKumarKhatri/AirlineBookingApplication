// flight.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Flight } from './flight.model';

@Injectable({
  providedIn: 'root',
})
export class FlightService {
  private baseUrl = 'http://localhost:8080/flights';

  constructor(private http: HttpClient) {}

  getFlight(id: number): Observable<Flight> {
    return this.http.get<Flight>(`${this.baseUrl}/${id}`);
  }

  getAllFlights(): Observable<Flight[]> {
    return this.http.get<Flight[]>(`${this.baseUrl}/all`);
  }

  createFlight(flight: Flight): Observable<Flight> {
    return this.http.post<Flight>(`${this.baseUrl}/create`, flight);
  }

  updateFlight(id: number, flight: Flight): Observable<Flight> {
    return this.http.put<Flight>(`${this.baseUrl}/${id}`, flight);
  }

  deleteFlight(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
