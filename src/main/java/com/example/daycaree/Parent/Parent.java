package com.example.daycaree.Parent;

import com.example.daycaree.Child.Child;
import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "Parent")
public class Parent {

    @Column(name="Firstname")
    private String Firstname;

    @Column(name="Lastname")
    private String Lastname;

    @Column(name="Email")
    private String Email;

    @Column(name="Phone")
    private String Phone;

    @Column(name="Address")
    private String Address;

    @Column(name="Comment")
    private String Comment;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ParentId")
    private Long ParentId;

    @Column(name="IsVissible")
    private Integer IsVissible;

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

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Long getParentId() {
        return ParentId;
    }

    public void setParentId(Long parentId) {
        ParentId = parentId;
    }

    public Integer getIsVissible() {
        return IsVissible;
    }

    public void setIsVissible(Integer isVissible) {
        IsVissible = isVissible;
    }


    public Set<Child> getChild() {
        return child;
    }

    public void setChild(Set<Child> child) {
        this.child = child;
    }

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Set<Child> child ;

}
