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
    return this.httpClient.get<Course[]>("/api/courses/")
  }

  public getCourse(id: number): Observable<CourseDetails> {
    return this.httpClient.get<CourseDetails>("/api/courses/" + id)
  }
}
