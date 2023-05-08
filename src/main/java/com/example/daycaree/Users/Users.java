package com.example.daycaree.Users;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "Users",schema="UserRoleMgmt")
public class Users {
    @Column(name="Firstname")
    private String Firstname;
    @Column(name="Secondname")
    private String Secondname;
    @Column(name="Lastname")
    private String Lastname;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="UserId")
    private Long UserId;
    @Column(name="SignInDate")
    private LocalDate SignInDate;
    @Column(name="IsVissible")
    private Integer IsVissible;
    @Column(name="ForgetPasswordToken")
    private String ForgetPasswordToken;
    @Column(name="ForgetPasswordTokenID")
    private String ForgetPasswordTokenID;

    @Column(name="Password")
    private String Password;

    @Column(name="Username")
    private String Username;

    @Column(name="seckey")
    private String seckey;
    @Column(name="ForgetPasswordDate")
    private LocalDate ForgetPasswordDate;

    public String getSeckey() {
        return seckey;
    }

    public void setSeckey(String seckey) {
        this.seckey = seckey;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public LocalDate getForgetPasswordDate() {
        return ForgetPasswordDate;
    }

    public void setForgetPasswordDate(LocalDate forgetPasswordDate) {
        ForgetPasswordDate = forgetPasswordDate;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getSecondname() {
        return Secondname;
    }

    public void setSecondname(String secondname) {
        Secondname = secondname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public LocalDate getSignInDate() {
        return SignInDate;
    }

    public void setSignInDate(LocalDate signInDate) {
        SignInDate = signInDate;
    }

    public Integer getIsVissible() {
        return IsVissible;
    }

    public void setIsVissible(Integer isVissible) {
        IsVissible = isVissible;
    }

    public String getForgetPasswordToken() {
        return ForgetPasswordToken;
    }

    public void setForgetPasswordToken(String forgetPasswordToken) {
        ForgetPasswordToken = forgetPasswordToken;
    }

    public String getForgetPasswordTokenID() {
        return ForgetPasswordTokenID;
    }

    public void setForgetPasswordTokenID(String forgetPasswordTokenID) {
        ForgetPasswordTokenID = forgetPasswordTokenID;
    }








}

