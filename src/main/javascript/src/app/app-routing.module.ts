import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserListComponent } from "./users/user-list/user-list.component";
import { UserComponent } from "./users/user/user.component";
import {CourseListComponent} from "./courses/course-list/course-list.component";
import {CourseComponent} from "./courses/course/course.component";

const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'users/:id', component: UserComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'courses/:id', component: CourseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
