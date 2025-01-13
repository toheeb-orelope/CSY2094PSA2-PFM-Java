import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { ExpenseService } from 'src/app/services/expense/expense.service';

@Component({
  selector: 'app-update-expense',
  templateUrl: './update-expense.component.html',
  styleUrls: ['./update-expense.component.scss'],
})
export class UpdateExpenseComponent implements OnInit {
  expenseForm!: FormGroup;
  id!: number;
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

  constructor(
    private fb: FormBuilder,
    private expenseService: ExpenseService,
    private message: NzMessageService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.expenseForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    });

    this.expenseService.getExpenseById(this.id).subscribe((res) => {
      this.expenseForm.patchValue(res);
    });
  }

  // The submitForm() method will be called when the form is submitted call the api
  submitForm() {
    if (this.expenseForm.valid) {
      this.expenseService
        .updateExpense(this.id, this.expenseForm.value)
        .subscribe(
          (res) => {
            this.message.success('Expense updated successfully', {
              nzDuration: 5000,
            });
            this.router.navigateByUrl('/expense');
          },
          (error) => {
            this.message.error('Failed to update expense', {
              nzDuration: 5000,
            });
          }
        );
    } else {
      this.message.error('Please fill out the form correctly', {
        nzDuration: 5000,
      });
    }
  }
}
