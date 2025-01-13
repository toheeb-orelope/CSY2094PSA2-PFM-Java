import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NzMessageService } from 'ng-zorro-antd/message';
import { IncomeService } from 'src/app/services/income/income.service';

@Component({
  selector: 'app-update-income',
  templateUrl: './update-income.component.html',
  styleUrls: ['./update-income.component.scss'],
})
export class UpdateIncomeComponent {
  id: number = this.activatedRoute.snapshot.params['id'];
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
    private incomeService: IncomeService,
    private activatedRoute: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.incomeForm = this.fb.group({
      title: [null, Validators.required],
      amount: [null, Validators.required],
      date: [null, Validators.required],
      category: [null, Validators.required],
      description: [null, Validators.required],
    });
    this.getIncomeByID();
  }

  //This method will retrieve the income by id by calling the getIncomeByID method from the IncomeService
  getIncomeByID() {
    this.incomeService.getIncomeByID(this.id).subscribe(
      (res) => {
        this.incomeForm.patchValue(res);
      },
      (error) => {
        this.message.error('Error retrieving income', { nzDuration: 5000 });
      }
    );
  }

  //This method will submit the income form by calling the update method from the IncomeService
  submitForm() {
    this.incomeService.updateIncome(this.id, this.incomeForm.value).subscribe(
      (res) => {
        this.message.success('Income updated successfully', {
          nzDuration: 5000,
        });
        this.router.navigate(['/income']);
      },
      (error) => {
        this.message.error('Error updating income', { nzDuration: 5000 });
      }
    );
  }
}
