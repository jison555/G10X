import { Component, OnInit } from '@angular/core';
import { VendorService } from 'src/vendor.service';
import { TestServiceService } from '../test-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  value=0;
  name = "kevin";
  searchValue = '';
  showOrHide = true;
  products:any;

  Products = [{
   stdName : "lesh",
   stdId:105 
  },
  {
    stdName : "Balu",
    stdId:103
   },
   {
    stdName : "Maya",
    stdId:108 
   }];


    constructor(public service: TestServiceService) { 
  
  this.viewProduct();
    
    }

    viewProduct(){
      this.service.getUser().subscribe(data=>{
       this.products=data;
       console.log(data)
      });
    }

    data(event: any){
      console.log(event);
      this.name = this.name + event.data;
      
      
    }

    printData() {
      console.log("haii buton clicked");
      this.value = 0;
     
      let timerId =setInterval(() => {
        this.value = this.value+ 6;
      },2000)

      setTimeout(() => {
        clearInterval(timerId);
        timerId;
      },4000)
    }



    
  
    
    ngOnInit() {
    }
}
