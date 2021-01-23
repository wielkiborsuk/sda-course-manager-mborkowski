import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {LessonBlock} from "./lesson-block";

@Injectable({
  providedIn: 'root'
})
export class LessonService {

  constructor(private http: HttpClient) { }

  assignTeacher(teacherId: number, lessonBlockId: number) {
    this.http.get("/api/lessonblocks/" + lessonBlockId).subscribe((block: LessonBlock) => {
      let body = {subject: block.subject, teacherId: teacherId};
      this.http.put("/api/lessonblocks/" + lessonBlockId, body).subscribe();
    });
  }
}
