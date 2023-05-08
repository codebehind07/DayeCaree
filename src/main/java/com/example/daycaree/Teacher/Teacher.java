package com.example.daycaree.Teacher;

import com.example.daycaree.Child.Child;
import com.example.daycaree.TeacherProgram.TeacherProgram;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "Teacher")
public class Teacher {

    @Column(name="Firstname")
    private String Firstname;

    public Long getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(Long teacherId) {
        TeacherId = teacherId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="TeacherId")
    private Long TeacherId;
    @Column(name="Lastname")
    private String Lastname;

    @Column(name="Email")
    private String Email;

    @Column(name="Phone")
    private String Phone;

    @Column(name="Address")
    private String Address;

    @Column(name="City")
    private String City;

    @Column(name="State")
    private String State;

    @Column(name="Zip")
    private String Zip;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Set<TeacherProgram> teacherProgram ;

    public Set<TeacherProgram> getTeacherProgram() {
        return teacherProgram;
    }

    public void setTeacherProgram(Set<TeacherProgram> teacherProgram) {
        this.teacherProgram = teacherProgram;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }
    public Set<Child> getChilds() {
        return childs;
    }

    public void setChilds(Set<Child> childs) {
        this.childs = childs;
    }
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade ={
            CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="Teacher_Child", joinColumns=@JoinColumn(name="TeacherId_FK"), inverseJoinColumns=@JoinColumn(name="ChildId_FK"))

    private Set<Child> childs = new HashSet<>();

    public void addRole(Child child){
        this.childs.add(child);
        child.getTeacherChild().add(this);
    }

    public void removeTag(long childId){
        Child child = this.childs.stream().filter(t-> t.getChildId()==childId).findFirst().orElse(null);
        if(child != null)
        {
            this.childs.remove(child) ;
            child.getTeacherChild().remove(this);
        }
    }
}
