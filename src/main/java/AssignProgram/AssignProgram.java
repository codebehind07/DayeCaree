package AssignProgram;

import org.hibernate.validator.constraints.Length;

public class AssignProgram {


    private Integer TeacherId;

    @Length(min = 1, max=50)
    private String Program;

    @Length(min = 1, max=250)
    private String Comment;

    public Integer getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(Integer teacherId) {
        TeacherId = teacherId;
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
}
