package ChildDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class ParentChildForm {

    @Length(min = 1, max=50)
    @NotBlank
    private String PFirstname;
    @Length(min = 1, max=50)
    @NotBlank
    private String PLastname;
    @Length(min = 1, max=50)
    @NotBlank
    @Email(message = "Please enter a valid e-mail address")
    private String PEmail;
    @Length(min = 1, max=11)
    @NotBlank
    private String PPhone;
    @Length(min = 1, max=250)
    @NotBlank
    private String PAddress;
    @Length(min = 1, max=250)
    @NotBlank
    private String PComment;
    @Length(min = 1, max=50)
    @NotBlank
    private String CFirstname;
    @Length(min = 1, max=50)
    @NotBlank
    private String CLastname;
    @Length(min = 1, max=50)
    @NotBlank
    private String CProgram;
    @Length(min = 1, max=250)
    @NotBlank
    private String CAddress;
    @Size(max = 250)
    @NotBlank
    private String CComment;

    private LocalDate CDOB;
    @Size(min = 8, max = 20)
    @NotBlank
    private String Password;
    @Length(min = 8, max=20)
    @NotBlank
    private String RPassword;

    private String Seckey;

    public String getSeckey() {
        return Seckey;
    }

    public void setSeckey(String seckey) {
        Seckey = seckey;
    }

    public String getPFirstname() {
        return PFirstname;
    }

    public void setPFirstname(String PFirstname) {
        this.PFirstname = PFirstname;
    }

    public String getPLastname() {
        return PLastname;
    }

    public void setPLastname(String PLastname) {
        this.PLastname = PLastname;
    }

    public String getPEmail() {
        return PEmail;
    }

    public void setPEmail(String PEmail) {
        this.PEmail = PEmail;
    }

    public String getPPhone() {
        return PPhone;
    }

    public void setPPhone(String PPhone) {
        this.PPhone = PPhone;
    }

    public String getPAddress() {
        return PAddress;
    }

    public void setPAddress(String PAddress) {
        this.PAddress = PAddress;
    }

    public String getPComment() {
        return PComment;
    }

    public void setPComment(String PComment) {
        this.PComment = PComment;
    }

    public String getCFirstname() {
        return CFirstname;
    }

    public void setCFirstname(String CFirstname) {
        this.CFirstname = CFirstname;
    }

    public String getCLastname() {
        return CLastname;
    }

    public void setCLastname(String CLastname) {
        this.CLastname = CLastname;
    }

    public String getCProgram() {
        return CProgram;
    }

    public void setCProgram(String CProgram) {
        this.CProgram = CProgram;
    }

    public String getCAddress() {
        return CAddress;
    }

    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    public String getCComment() {
        return CComment;
    }

    public void setCComment(String CComment) {
        this.CComment = CComment;
    }

    public LocalDate getCDOB() {
        return CDOB;
    }

    public void setCDOB(LocalDate CDOB) {
        this.CDOB = CDOB;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRPassword() {
        return RPassword;
    }

    public void setRPassword(String RPassword) {
        this.RPassword = RPassword;
    }
}
