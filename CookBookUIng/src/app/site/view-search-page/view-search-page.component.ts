import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-view-search-page',
  templateUrl: './view-search-page.component.html',
  styleUrls: ['./view-search-page.component.css']
})
export class ViewSearchPageComponent implements OnInit {
  searchValue = ``;

  searchValueInput(searchValue: string) {
    this.searchValue = searchValue;
  }

  constructor() { }
  

  ngOnInit(): void {
    
  }



}
