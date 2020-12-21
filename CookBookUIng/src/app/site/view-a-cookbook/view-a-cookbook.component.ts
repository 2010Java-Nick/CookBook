import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cookbook } from 'src/app/models/cookbook.model';
import { CookbookService } from 'src/app/services/cookbook.service';

@Component({
  selector: 'app-view-a-cookbook',
  templateUrl: './view-a-cookbook.component.html',
  styleUrls: ['./view-a-cookbook.component.css']
})
export class ViewACookbookComponent implements OnInit {
  cookbook!:Cookbook;
  private sub: any;
  id!: number;

  constructor(private route: ActivatedRoute,
              private cookbookService : CookbookService
    ) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];  });

    this.cookbookService.getCookbook(this.id).subscribe(
      (result) => { this.cookbook = result  
    });
  }

}
