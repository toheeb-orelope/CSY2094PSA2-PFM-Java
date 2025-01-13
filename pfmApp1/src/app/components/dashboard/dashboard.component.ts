import { Component, ElementRef, ViewChild } from '@angular/core';
import { StatusService } from 'src/app/services/status/status.service';
// Importing chart.js and category scale
import {
  Chart,
  CategoryScale,
  LinearScale,
  LineController,
  LineElement,
  PointElement,
} from 'chart.js';

// Registering the category scale, linear scale, and line controller
Chart.register(
  CategoryScale,
  LinearScale,
  LineController,
  LineElement,
  PointElement
);

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent {
  status: any;
  expensesList: any;
  incomesList: any;
  gridStyle = {
    width: '25%',
    textAlign: 'center',
  };

  //Creating an element reference for the chart
  @ViewChild('incomeLineChartRef') private incomeLineChartRef: ElementRef;
  @ViewChild('expenseLineChartRef') private expenseLineChartRef: ElementRef;

  // The StatusService service is injected into the constructor
  constructor(private statusService: StatusService) {
    this.getStatus();
    this.getChartData();
  }

  //This method will create the line chart
  createLineChart() {
    //Income chart
    const incomeCtx = this.incomeLineChartRef.nativeElement.getContext('2d');

    //Chat.js configuration: https://www.chartjs.org/docs/latest/getting-started/installation.html
    //Code generated from https://www.chartjs.org/docs/latest/getting-started/
    new Chart(incomeCtx, {
      type: 'line',
      data: {
        labels: this.incomesList.map((income) => income.date),
        datasets: [
          {
            label: 'Income',
            data: this.incomesList.map((income) => income.amount),
            borderWidth: 1,
            backgroundColor: 'rgba(80, 200, 120)',
            borderColor: 'rgba(0, 100, 0)',
            tension: 0.4, // Add tension to create wave form
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    });

    //Expense chart
    const expenseCtx = this.expenseLineChartRef.nativeElement.getContext('2d');
    new Chart(expenseCtx, {
      type: 'line',
      data: {
        labels: this.expensesList.map((expense) => expense.date),
        datasets: [
          {
            label: 'Expense',
            data: this.expensesList.map((expense) => expense.amount),
            borderWidth: 1,
            backgroundColor: 'rgba(255, 0, 0)',
            borderColor: 'rgba(255, 0, 0)',
            tension: 0.4, // Add tension to create wave form
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    });
  }

  //This method will return the status of the application
  getStatus() {
    this.statusService.getStatus().subscribe((res) => {
      this.status = res;
    });
  }

  //This method will return the chart for the status, which will be used to display the chart
  getChartData() {
    this.statusService.getChartData().subscribe((res) => {
      if (res.expenses != null && res.incomes != null) {
        this.expensesList = res.expenses;
        this.incomesList = res.incomes;
        console.log(res);

        this.createLineChart();
      }
    });
  }
}
