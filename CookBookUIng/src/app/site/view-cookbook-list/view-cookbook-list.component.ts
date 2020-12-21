import { Component, OnInit } from '@angular/core';
import { Cookbook } from 'src/app/models/cookbook.model';
import { CookbookService } from 'src/app/services/cookbook.service';

@Component({
  selector: 'app-view-cookbook-list',
  templateUrl: './view-cookbook-list.component.html',
  styleUrls: ['./view-cookbook-list.component.css']
})
export class ViewCookbookListComponent implements OnInit {
  
  cookbookList: Cookbook []=new Array();
  searchValue = ``;

  searchValueInput(searchValue: string) {
    this.searchValue = searchValue;
  }
  constructor(private cookbookService : CookbookService) { }
  
  ngOnInit(): void {
    this.cookbookService.getCookbooks().subscribe(
      (result) => { this.cookbookList = result }
    );
  }



}
