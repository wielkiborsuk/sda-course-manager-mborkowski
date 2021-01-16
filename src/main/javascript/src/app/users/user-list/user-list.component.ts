import {Component, Injectable, OnInit} from '@angular/core';
import {UserService} from "../user.service";
import {User} from "../user";

@Injectable()
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  private userService: UserService;
  public users: User[];

  constructor(userService: UserService) {
    this.userService = userService;
  }

  ngOnInit(): void {
    this.userService.getUserList().subscribe(data => {
      this.users = data;
    });
  }

}
