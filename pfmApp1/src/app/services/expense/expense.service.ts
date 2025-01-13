import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

// The Injectable decorator is used to define a service class
// that can be injected into other components or services.
// The providedIn property of the Injectable decorator is set to root,
//  which means that the service is available to the entire application.
// The ExpenseService class is exported
// so that it can be imported into other components or services.

//The URL to connect to the backend server will be stored in the environment.ts file.
const baseUrl = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root',
})
export class ExpenseService {
  //Here we are going to inject the HttpClient module into the constructor
  constructor(private http: HttpClient) {}

  //This method will insert the expenses into the database
  addExpense(expenseDTO: any): Observable<any> {
    console.log('Sending expense data to backend:', expenseDTO); // Add logging
    return this.http.post(baseUrl + 'api/expense', expenseDTO);
  }

  //This method will return the list of expenses from the database
  getAllExpenses(): Observable<any> {
    return this.http.get(baseUrl + 'api/expense/all');
  }

  //This method will delete the expense from the database
  deleteExpense(id: number): Observable<any> {
    return this.http.delete(baseUrl + `api/expense/${id}`).pipe(
      tap((res) => console.log('Delete response:', res)) // Add logging
    );
  }

  //This method endpoint will return the expense by id
  getExpenseById(id: number): Observable<any> {
    return this.http.get(baseUrl + `api/expense/${id}`);
  }

  //This method will update the expense in the database
  updateExpense(id: number, expenseDTO: any): Observable<any> {
    return this.http.put(baseUrl + `api/expense/${id}`, expenseDTO);
  }
}
