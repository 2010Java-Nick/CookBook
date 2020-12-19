import { Component, Input, OnInit } from '@angular/core';
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

  constructor(private accountService: AccountCreationService) {}

  ngOnInit(): void {}

  public formCreateUser(): void {
    if (
      this.user.firstName === undefined ||
      this.user.lastName === undefined ||
      this.user.username === undefined ||
      this.user.password === undefined
    ) {
      console.log('Please fill out form!');
    } else if (this.user.password !== this.reenterPassword){
      console.log(`Passwords don't match`);
    }
    else {
      this.user.authorization = 'STANDARD';
      console.log(`View Component: ` + this.accountService.createNewUser(this.user));
    }
  }
}
