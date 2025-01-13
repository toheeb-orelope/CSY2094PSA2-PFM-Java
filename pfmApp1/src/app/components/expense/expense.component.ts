import { Component } from '@angular/core';
import { Form, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { ExpenseService } from 'src/app/services/expense/expense.service';

@Component({
  selector: 'app-expense',
  templateUrl: './expense.component.html',
  styleUrls: ['./expense.component.scss'],
})
// Build a form in the expense.component.ts file using the
// FormBuilder service. The form will have the following fields:
export class ExpenseComponent {
  [x: string]: any;
  expenseForm!: FormGroup;
  categories: any[] = [
    'Education',
    'Entertainment',
    'Groceries',
    'Health',
    'Household',
    'Subscription',
    'Transportation',
    'Clothing',
    'Takeaway',
    'Travel',
    'Utilities',
    'Others',
  ];
  expenses: any;

  constructor(
    // The FormBuilder service is injected into the constructor.
    private fb: FormBuilder,
    // The ExpenseService service is injected into the constructor
    private expenseService: ExpenseService,
    // The NzMessageService service is injected into the constructor
    private message: NzMessageService,
    // The Router service is injected into the constructor
    private router: Router
  ) {}

  ngOnInit() {
    this.getAllExpenses();
    this.expenseForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    });
  }

  // The submitForm() method will be called when the form is submitted call the api
  // to insert into the database.
  submitForm() {
    if (this.expenseForm.valid) {
      console.log('Form data:', this.expenseForm.value); // Add logging
      this.expenseService.addExpense(this.expenseForm.value).subscribe(
        (res) => {
          this.message.success('Expense added successfully', {
            nzDuration: 5000,
          });
          this.expenseForm.reset();
        },
        (error) => {
          console.error('Error adding expense:', error); // Add logging
          this.message.error('Failed to add expense', { nzDuration: 5000 });
        }
      );
    } else {
      this.message.error('Please fill out the form correctly', {
        nzDuration: 5000,
      });
    }
  }

  //This method will call the api to return the list of expenses from the database
  //This method will retrieve all the income from the database by calling the
  //getAllIncome method from the IncomeService
  getAllExpenses() {
    this.expenseService.getAllExpenses().subscribe((res) => {
      this.expenses = res;
    });
  }

  //The updateExpense() method will be called when the edit button is clicked.
  // It will navigate to the update-expense component.
  updateExpense(id: number) {
    this.router.navigateByUrl(`/expense/${id}/edit`);
  }

  //This method will delete the income by id by
  // calling the deleteIncome method from the IncomeService
  deleteExpense(id: number) {
    this.expenseService.deleteExpense(id).subscribe(
      (res) => {
        this.message.success('Expense deleted successfully', {
          nzDuration: 5000,
        });
        this.getAllExpenses();
      },
      (error) => {
        this.message.error('Error deleting income', { nzDuration: 5000 });
      }
    );
  }
}
