// excel-data-list.component.ts
import { Component, OnInit } from '@angular/core';
import { ExcelDataService } from '../services/excel-data.service';

@Component({
  selector: 'app-excel-data-list',
  templateUrl: './excel-data-list.component.html'
})
export class ExcelDataListComponent implements OnInit {
  excelData: any[];

  constructor(private excelDataService: ExcelDataService) {}

  ngOnInit() {
    this.getExcelData();
  }

  getExcelData() {
    // Call service to fetch Excel data
    this.excelDataService.getAllExcelData().subscribe(
      (data: any[]) => {
        this.excelData = data;
      },
      error => {
        console.error('Error fetching Excel data:', error);
      }
    );
  }
}
