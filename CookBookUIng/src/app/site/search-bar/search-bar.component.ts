import { Component, OnInit, Output,  EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-bar',
  templateUrl: './search-bar.component.html',
  styleUrls: ['./search-bar.component.css']
})
export class SearchBarComponent implements OnInit {
 
  @Output()
  searchValue = new EventEmitter<string>();

  searchInput = ``;

  constructor() { }

  ngOnInit(): void {
  }

  clearSearch() {
    this.searchInput = ``;
    this.updateSearchBar();
  }

  updateSearchBar() {
    console.log("ran update Search Bar")
    this.searchValue.emit(this.searchInput.toLowerCase());
  }


}
