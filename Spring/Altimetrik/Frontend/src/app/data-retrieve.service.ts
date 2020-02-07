import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Result } from './main/main.component';


@Injectable({
  providedIn: 'root'
})
export class DataRetrieveService {

  constructor(private http:HttpClient) { }

  getDecodedVin(vin:string){
    return this.http.get<Result[]>(`http://localhost:8080/api/${vin}`)
  }
}
