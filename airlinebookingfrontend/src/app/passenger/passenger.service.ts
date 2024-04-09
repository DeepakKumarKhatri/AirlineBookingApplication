import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Passenger } from './passenger.model';

@Injectable({
  providedIn: 'root',
})
export class PassengerService {
  private baseUrl = 'http://localhost:8080/passengers';

  constructor(private http: HttpClient) {}

  getAllPassengers(): Observable<Passenger[]> {
    return this.http.get<Passenger[]>(`${this.baseUrl}/all`);
  }

  getPassengerById(id: number): Observable<Passenger> {
    return this.http.get<Passenger>(`${this.baseUrl}/${id}`);
  }

  addPassenger(passenger: Passenger): Observable<Passenger> {
    return this.http.post<Passenger>(`${this.baseUrl}/create`, passenger);
  }

  updatePassenger(id: number, passenger: Passenger): Observable<Passenger> {
    return this.http.put<Passenger>(`${this.baseUrl}/${id}`, passenger);
  }

  deletePassenger(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
