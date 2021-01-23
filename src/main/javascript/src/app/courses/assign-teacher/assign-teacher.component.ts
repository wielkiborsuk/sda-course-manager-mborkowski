import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {LessonService} from "../../lessons/lesson.service";
import {User} from "../../users/user";
import {UserService} from "../../users/user.service";

@Component({
  selector: 'app-assign-teacher',
  templateUrl: './assign-teacher.component.html',
  styleUrls: ['./assign-teacher.component.css']
})
export class AssignTeacherComponent implements OnInit {

  public teacherId: number;
  public lessonBlockId: number;
  public teachers: User[];

  constructor(private route: ActivatedRoute, private lessonService: LessonService,
              private userService: UserService) { }

  ngOnInit(): void {
    this.lessonBlockId = this.route.snapshot.queryParams['lessonBlockId'];
    this.userService.getTeacherList().subscribe(data => {
      this.teachers = data;
    });
  }

  onSubmit() {
    this.lessonService.assignTeacher(this.teacherId, this.lessonBlockId);
  }
}
