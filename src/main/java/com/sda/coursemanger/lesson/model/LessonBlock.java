package com.sda.coursemanger.lesson.model;

import com.sda.coursemanger.user.model.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class LessonBlock {
    @Id
    @GeneratedValue
    private long id;
    private String subject;
    @OneToMany
    private List<Lesson> lessons;
    @ManyToOne
    private User teacher;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
