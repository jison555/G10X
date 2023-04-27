import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TestServiceService {

  name = "Balu";

  constructor(private httpClint:HttpClient) { 
  }

  getUser():Observable<any> {
    console.log("service for test");
    
      return this.httpClint.get("http://localhost:8081/core/v1/products");
  }

  
}
