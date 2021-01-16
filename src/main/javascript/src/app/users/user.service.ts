import { Injectable } from '@angular/core';
import {User} from "./user";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>('http://localhost:8080/users/');
  }
}
