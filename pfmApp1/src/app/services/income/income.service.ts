import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

//Create a service called IncomeService using the Angular CLI
// ng generate service services/income/income
// This command will create a new service called IncomeService in the src/app/services/income folder.
// The service will be used to manage the income-related operations.

//The URL to connect to the backend server will be stored in the environment.ts file.
const baseUrl = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root',
})
export class IncomeService {
  //Here we are going to inject the HttpClient module into the constructor
  constructor(private http: HttpClient) {}

  //This method will insert the income into the database,
  // which is going to communate with our backend endpoint
  addIncome(incomeDTO: any): Observable<any> {
    return this.http.post(baseUrl + 'api/income', incomeDTO);
  }

  //This method will retrieve the income from the database,
  // which is going to communicate with our backend endpoint
  getAllIncome(): Observable<any> {
    return this.http.get(baseUrl + 'api/income/all');
  }

  //This method will return the income in the database by id,
  // which is going to communicate with our backend endpoint
  getIncomeByID(id: number): Observable<any> {
    return this.http.get(baseUrl + `api/income/${id}`);
  }

  //This method will update the income in the database,
  // which is going to communicate with our backend endpoint
  updateIncome(id: number, incomeDTO: any): Observable<any> {
    return this.http.put(baseUrl + `api/income/${id}`, incomeDTO);
  }

  //This method will delete the income in the database,
  // which is going to communicate with our backend endpoint
  deleteIncome(id: number): Observable<any> {
    return this.http.delete(baseUrl + `api/income/${id}`);
  }
}
