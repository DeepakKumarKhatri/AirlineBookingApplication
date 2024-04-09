export interface Pilot {
  id?: number;
  firstName: string;
  lastName: string;
  email: string;
  phone: string;
  flight?: Flight;
}

export interface Flight {
  id?: number;
  flightNumber: string;
  departureAirport: string;
  arrivalAirport: string;
  departureTime: string;
  arrivalTime: string;
}
