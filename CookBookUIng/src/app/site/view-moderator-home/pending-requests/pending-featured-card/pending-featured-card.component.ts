import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Recipe } from 'src/app/models/recipe.model';

@Component({
  selector: '.app-pending-featured-card',
  templateUrl: './pending-featured-card.component.html',
  styleUrls: ['./pending-featured-card.component.css']
})
export class PendingFeaturedCardComponent implements OnInit {

  @Input()
  recipe!: Recipe;

  @Output()
  event = new EventEmitter<Recipe>();

  constructor() { }

  ngOnInit(): void {
  }

  approveFeatured(): void {
    console.log('Card approveFeature called');
    this.recipe.featured = true;
    this.event.emit(this.recipe);
  }

  denyFeatured(): void {
    console.log('Card denyFeature called');
    this.recipe.featured = false;
    this.event.emit(this.recipe);
  }

}
