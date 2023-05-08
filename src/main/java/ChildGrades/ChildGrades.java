package ChildGrades;

import jakarta.persistence.Column;

public class ChildGrades {

    @Column(name="ProgramId")
    private Long ProgramId;

    @Column(name="ChildId")
    private Long ChildId;

    @Column(name="Comment")
    private String Comment;

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    @Column(name="Grade")
    private String Grade;

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
}
