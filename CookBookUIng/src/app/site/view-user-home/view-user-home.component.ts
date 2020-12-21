import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-user-home',
  templateUrl: './view-user-home.component.html',
  styleUrls: ['./view-user-home.component.css']
})
export class ViewUserHomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navCreateRecipe(): void {
    this.router.navigate(['createRecipe']);
  }

  navCreateCookBook(): void {
    this.router.navigate(['createCookBook']);
  }

  navFavorites(): void {
    this.router.navigate(['favorites']);
  }

  navCookBooks(): void {
    this.router.navigate(['cookbooks']);
  }

  navSearch(): void {
    this.router.navigate(['search']);
  }

}
