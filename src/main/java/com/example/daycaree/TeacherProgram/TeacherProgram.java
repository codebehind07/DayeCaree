package com.example.daycaree.TeacherProgram;

import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Teacher.Teacher;
import jakarta.persistence.*;

@Entity
@Table(name = "TeacherProgram")
public class TeacherProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TeacherProgramId")
    private Long TeacherProgramId;

    @Column(name="ProgramId")
    private Long ProgramId;

    @Column(name="Program")
    private String Program;

    @Column(name="Comment")
    private String Comment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TeacherId_FK", nullable = false)

    private Teacher teacher;

    public Long getProgramId() {
        return ProgramId;
    }

    public void setProgramId(Long programId) {
        ProgramId = programId;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
