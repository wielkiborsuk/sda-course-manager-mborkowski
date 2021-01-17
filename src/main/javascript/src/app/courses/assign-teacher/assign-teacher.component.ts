import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {LessonService} from "../../lessons/lesson.service";

@Component({
  selector: 'app-assign-teacher',
  templateUrl: './assign-teacher.component.html',
  styleUrls: ['./assign-teacher.component.css']
})
export class AssignTeacherComponent implements OnInit {

  public teacherId: number;
  public lessonBlockId: number;

  constructor(private route: ActivatedRoute, private lessonService: LessonService) { }

  ngOnInit(): void {
    this.lessonBlockId = this.route.snapshot.queryParams['lessonBlockId'];
  }

  onSubmit() {
    this.lessonService.assignTeacher(this.teacherId, this.lessonBlockId);
  }
}
