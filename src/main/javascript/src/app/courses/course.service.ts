import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Course} from "./course";
import {CourseDetails} from "./course-details";

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private httpClient: HttpClient) { }

  public getCourses(): Observable<Course[]> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('admin:admin'));
    return this.httpClient.get<Course[]>("/api/courses/", {headers: headers})
  }

  public getCourse(id: number): Observable<CourseDetails> {
    let headers: HttpHeaders = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa('admin:admin'));
    return this.httpClient.get<CourseDetails>("/api/courses/" + id, {headers: headers})
  }
}
