// excel-data.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExcelDataService {
  private baseUrl = 'http://localhost:8080/api/excelData';

  constructor(private http: HttpClient) {}

  getAllExcelData() {
    return this.http.get(this.baseUrl);
  }
}
