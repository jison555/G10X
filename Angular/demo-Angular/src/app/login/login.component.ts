import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  countryList = ["INDIA,AUSTRALIA,NEPAL,CHINA,JAPAN,PAKISTAN,SRILANKA"];

  constructor() { }


  ngOnInit(): void {
  }

  loginData(loginForm:any) {

    console.log(loginForm.value);
    
  }

}
