package com.sda.coursemanger.lesson.model.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LessonBlockUpdateForm {
    @NotNull
    @NotBlank
    @Length(min = 4, max = 50)
    private String subject;

    @Min(1)
    private long teacherId;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
