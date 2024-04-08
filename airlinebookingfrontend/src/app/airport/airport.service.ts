import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Airport } from './airport.model';

@Injectable({
  providedIn: 'root',
})
export class AirportService {
  private apiUrl = 'http://localhost:8080/airport';

  constructor(private http: HttpClient) {}

  getAllAirports(): Observable<Airport[]> {
    return this.http.get<Airport[]>(`${this.apiUrl}/allAirPort`);
  }

  getAirportById(id: number): Observable<Airport> {
    return this.http.get<Airport>(`${this.apiUrl}/findAirport/${id}`);
  }

  addAirport(airport: Airport): Observable<Airport> {
    return this.http.post<Airport>(`${this.apiUrl}/addAirport`, airport);
  }

  updateAirport(airport: Airport): Observable<Airport> {
    return this.http.put<Airport>(`${this.apiUrl}/updateAirport`, airport);
  }

  deleteAirport(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete/${id}`);
  }
}
