import { Injectable } from '@angular/core';
import {User} from "./user";
import {HttpClient, HttpHeaders} from "@angular/common/http";
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
    return this.httpClient.get<User[]>('/api/users/');
  }

  public getTeacherList(): Observable<User[]> {
    return this.httpClient.get<User[]>('/api/users/?type=TEACHER');
  }

  public getUser(id: number): Observable<User> {
    return this.httpClient.get<User>('/api/users/' + id);
  }
}
