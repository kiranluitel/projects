import { Component, OnInit } from '@angular/core';
import { DataRetrieveService } from '../data-retrieve.service';
import { MapService } from '../map.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  invalidVin:boolean=false;
  showDecodedPart:boolean=false;
  vin:string
  resultList:Result[]=[]
  url:string
  city:string
  showMap:boolean=false

  
  

  constructor(private dataService:DataRetrieveService,
    public sanitizer:DomSanitizer) { }

  ngOnInit() {
    
   this.city="fairfield, Iowa"
   this.url=`https://www.google.com/maps/embed/v1/place?q=${this.city}&key=AIzaSyAohNbXKpZKvgSeR02TC6BVjRUyLiv-1tA`;
    
  }

  getDecodedVin(){
    
    this.dataService.getDecodedVin(this.vin).subscribe(response=>{
      this.showDecodedPart= true;
      
      this.resultList=response;
      this.invalidVin=false;
      
      
      
      for(let i=0;i<this.resultList.length;i++){
        if(this.resultList[i].Variable==="Plant City"){

          this.city=this.resultList[i].Value
          this.showMap=true
         
        }
      }
      this.url=`https://www.google.com/maps/embed/v1/place?q=${this.city}&key=AIzaSyAohNbXKpZKvgSeR02TC6BVjRUyLiv-1tA`;

    },
    error=>{
      this.resultList=[]
      this.invalidVin=true;
      this.showMap=false
      this.showDecodedPart=false;
    })
    
  }
}
export class Result{

  Value:string
  Variable:string
  

  constructor() {
    
  }
}
