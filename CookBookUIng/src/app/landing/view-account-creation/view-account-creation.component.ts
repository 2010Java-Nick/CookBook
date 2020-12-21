import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AccountCreationService } from 'src/app/services/account-creation.service';
import { User } from '../../models/user.model';

@Component({
  selector: 'app-view-account-creation',
  templateUrl: './view-account-creation.component.html',
  styleUrls: ['./view-account-creation.component.css'],
})
export class ViewAccountCreationComponent implements OnInit {
  user = {} as User;
  reenterPassword = '';

  error: string = '';

  constructor(private accountService: AccountCreationService, private router: Router) { }

  ngOnInit(): void { }

  public formCreateUser(): void {
    if (this.user.firstName === undefined || this.user.firstName.search(`[^a-zA-Z\-]`) > 0) {
      this.error = 'First name must only contain letters and hyphens';
    }
    else if (this.user.lastName === undefined || this.user.lastName.search(`[^a-zA-Z\-]`) > 0) {
      this.error = 'Last name must only contain letters and hyphens';
    }
    else if (this.user.username === undefined || this.user.username.search(`[^a-zA-Z0-9_]`) > 0) {
      this.error = 'Username must only contain letters, numbers and underscores';
    }
    else if (this.user.password === undefined || this.user.password.length < 8) {
      this.error = 'Password must be at least 8 characters in length';
    }
    else if (this.user.password !== this.reenterPassword) {
      this.error = `Passwords don't match`;
    }
    else {
      this.user.authorization = 'STANDARD';
      this.error = '';
      this.accountService.createNewUser(this.user).subscribe(response => {
        if(response) {
          this.router.navigate(['/']);
        }
        else {
          this.error = 'Oops! Something went wrong, please try again!';
        }
      });
    }
  }
}
