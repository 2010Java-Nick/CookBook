import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-moderator-home',
  templateUrl: './view-moderator-home.component.html',
  styleUrls: ['./view-moderator-home.component.css']
})
export class ViewModeratorHomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navSearch(): void {
    this.router.navigate(['/search']);
  }
}
