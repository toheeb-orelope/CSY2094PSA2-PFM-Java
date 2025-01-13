import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { IncomeService } from 'src/app/services/income/income.service';

interface Income {
  title: string;
  amount: number;
  date: string;
  category: string;
  description: string;
}

@Component({
  selector: 'app-income',
  templateUrl: './income.component.html',
  styleUrls: ['./income.component.scss'],
})
export class IncomeComponent implements OnInit {
  incomes: any;
  incomeForm!: FormGroup;
  categories: any[] = [
    'Salary',
    'Business',
    'Freelance',
    'Investments',
    'Stocks',
    'Bitcoin',
    'Bank Transfer',
    'Others',
  ];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private message: NzMessageService,
    private incomeService: IncomeService
  ) {}

  ngOnInit(): void {
    this.getAllIncome();
    this.incomeForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    });
  }

  //This method will submit the income form by calling the addIncome method from the IncomeService
  submitForm() {
    this.incomeService.addIncome(this.incomeForm.value).subscribe(
      (res) => {
        this.message.success('Income added successfully', { nzDuration: 5000 });
        this.getAllIncome();
      },
      (error) => {
        this.message.error('Error adding income', { nzDuration: 5000 });
      }
    );
  }

  //This method will retrieve all the income from the database by calling the
  //getAllIncome method from the IncomeService
  getAllIncome() {
    this.incomeService.getAllIncome().subscribe(
      (res) => {
        this.incomes = res;
      },
      (error) => {
        this.message.error('Error retrieving income', { nzDuration: 5000 });
      }
    );
  }

  //This method will delete the income by id by
  // calling the deleteIncome method from the IncomeService
  deleteIncome(id: number) {
    this.incomeService.deleteIncome(id).subscribe(
      (res) => {
        this.message.success('Income deleted successfully', {
          nzDuration: 5000,
        });
        this.getAllIncome();
      },
      (error) => {
        this.message.error('Error deleting income', { nzDuration: 5000 });
      }
    );
  }
}
