import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UserListComponent} from './users/user-list/user-list.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {UserComponent} from './users/user/user.component';
import {CourseListComponent} from './courses/course-list/course-list.component';
import {CourseComponent} from './courses/course/course.component';
import {AssignTeacherComponent} from './courses/assign-teacher/assign-teacher.component';
import {FormsModule} from "@angular/forms";
import {AuthInterceptor} from "./auth/auth.interceptor";

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    UserComponent,
    CourseListComponent,
    CourseComponent,
    AssignTeacherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
