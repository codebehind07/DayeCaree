package com.example.daycaree.ChildGrade;

import com.example.daycaree.Child.Child;
import com.example.daycaree.Teacher.Teacher;
import jakarta.persistence.*;

@Entity
@Table(name = "ChildGrade")
public class ChildGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ChildGradeId")
    private Long ChildGradeId;

    @Column(name="ProgramId")
    private Long ProgramId;

    @Column(name="ChildId")
    private Long ChildId;

    @Column(name="Comment")
    private String Comment;

    @Column(name="Grade")
    private String Grade;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ChilId_FK", nullable = false)

    private Child child;

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public Long getChildGradeId() {
        return ChildGradeId;
    }

    public void setChildGradeId(Long childGradeId) {
        ChildGradeId = childGradeId;
    }

    public Long getProgramId() {
        return ProgramId;
    }

    public void setProgramId(Long programId) {
        ProgramId = programId;
    }

    public Long getChildId() {
        return ChildId;
    }

    public void setChildId(Long childId) {
        ChildId = childId;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
