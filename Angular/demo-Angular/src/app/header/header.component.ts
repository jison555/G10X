import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  value=5;

  constructor() { 

    console.log("haii header component",this.value=this.value+5);
  }

  ngOnInit(): void {

    console.log("haii header im inside ngOnInIt()",this.value);
  }

}
