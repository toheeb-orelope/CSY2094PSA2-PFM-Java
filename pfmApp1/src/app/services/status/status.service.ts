import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

//Create a service called StatusService using the Angular CLI
// ng generate service services/status/status
// This command will create a new service called StatusService in the src/app/services/status folder.
//The service will be used to manage the status-related operations.

//The URL to connect to the backend server will be stored in the environment.ts file.
const baseUrl = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root',
})
export class StatusService {
  //Here we are going to inject the HttpClient module into the constructor
  constructor(private http: HttpClient) {}

  //This method will reture the status from the database,
  //which is going to communicate with our backend endpoint
  getStatus(): Observable<any> {
    return this.http.get(baseUrl + 'api/status');
  }

  //This is a method to create a chart data for the status,
  //which is going to communicate with our backend endpoint
  getChartData(): Observable<any> {
    return this.http.get(baseUrl + 'api/status/chart');
  }
}
