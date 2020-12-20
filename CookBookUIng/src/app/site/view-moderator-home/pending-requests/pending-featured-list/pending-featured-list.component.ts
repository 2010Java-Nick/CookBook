import { newArray } from '@angular/compiler/src/util';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Recipe } from 'src/app/models/recipe.model';

@Component({
  selector: 'app-pending-featured-list',
  templateUrl: './pending-featured-list.component.html',
  styleUrls: ['./pending-featured-list.component.css']
})
export class PendingFeaturedListComponent implements OnInit {

  @Input()
  public recipeList: Recipe [] = new Array();

  @Output()
  event = new EventEmitter<Recipe>();

  constructor() { }

  ngOnInit(): void {
  }

  propagateEvent(modApproval: Recipe): void {
    console.log('Card event received in list component');
    this.event.emit(modApproval);
  }

}
