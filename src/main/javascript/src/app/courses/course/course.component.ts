import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {CourseService} from "../course.service";
import {CourseDetails} from "../course-details";

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  public course: CourseDetails;

  constructor(private route: ActivatedRoute, private courseService: CourseService) { }

  ngOnInit(): void {
    let courseId = this.route.snapshot.params['id'];
    this.courseService.getCourse(courseId).subscribe(data => {
      this.course = data;
    });
  }

}
