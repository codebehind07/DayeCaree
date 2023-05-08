package com.example.daycaree.Child;

import com.example.daycaree.Bill.Bill;
import com.example.daycaree.ChildGrade.ChildGrade;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Teacher.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Child")
public class Child {

    @Column(name="Firstname")
    private String Firstname;
    @Column(name="Lastname")
    private String Lastname;

    @Column(name="Address")
    private String Address;

    @Column(name="Program")
    private String Progam;
    @Column(name="Comment")
    private String Comment;

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getProgam() {
        return Progam;
    }

    public void setProgam(String progam) {
        Progam = progam;
    }

    public Long getChildId() {
        return ChildId;
    }

    public void setChildId(Long childId) {
        ChildId = childId;
    }

    public Integer getIsVissible() {
        return IsVissible;
    }

    public void setIsVissible(Integer isVissible) {
        IsVissible = isVissible;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Set<Bill> bill ;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ChildId")
    private Long ChildId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ParentId_FK", nullable = false)

    private Parent parent;


    public Set<ChildGrade> getChildGrade() {
        return childGrade;
    }

    public void setChildGrade(Set<ChildGrade> childGrade) {
        this.childGrade = childGrade;
    }

    @OneToMany(mappedBy = "child", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Set<ChildGrade> childGrade ;
    @Column(name="IsVissible")
    private Integer IsVissible;


    @Column(name="DOB")
    private LocalDate DOB;

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public Set<Teacher> getTeacherChild() {
        return TeacherChild;
    }

    public void setTeacherChild(Set<Teacher> teacherChild) {
        TeacherChild = teacherChild;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @JsonIgnore

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "childs")
    private Set<Teacher> TeacherChild = new HashSet<>();

    // I added this one
    public void addTeacher(Teacher teacher)
    {
        this.TeacherChild.add(teacher);
        teacher.getChilds().add(this);
    }

    public void removeTag(long teacherId){
        Teacher teacher = this.TeacherChild.stream().filter(t-> t.getTeacherId()==teacherId).findFirst().orElse(null);
        if(teacher != null)
        {
            this.TeacherChild.remove(teacher) ;
            teacher.getChilds().remove(this);
        }
        }
}
