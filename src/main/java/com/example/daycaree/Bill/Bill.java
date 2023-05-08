package com.example.daycaree.Bill;
import com.example.daycaree.Child.Child;
import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Bill")
public class Bill {

    @Column(name="Comment")
    private String Comment;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BillId")
    private Long BillId;

    @Column(name="ProgramId")
    private Integer ProgramId;


    @Column(name="Program")
    private String Program;

    @Column(name="Amount")
    private Double Amount;

    @Column(name="PayDate")
    private LocalDate PayDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ChildId_FK", nullable = false)

    private Child child;

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Long getBillId() {
        return BillId;
    }

    public void setBillId(Long billId) {
        BillId = billId;
    }

    public Integer getProgramId() {
        return ProgramId;
    }

    public void setProgramId(Integer programId) {
        ProgramId = programId;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String program) {
        Program = program;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    public LocalDate getPayDate() {
        return PayDate;
    }

    public void setPayDate(LocalDate payDate) {
        PayDate = payDate;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
