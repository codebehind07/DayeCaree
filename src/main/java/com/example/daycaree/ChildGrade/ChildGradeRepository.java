package com.example.daycaree.ChildGrade;

import com.example.daycaree.Bill.Bill;
import com.example.daycaree.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChildGradeRepository extends JpaRepository<ChildGrade, Long> {

    @Query(nativeQuery = true, value = "Select c.firstname as CFirstname,c.Lastname as CLastname,p.Firstname as PFristname,p.Lastname as PLastname,p.phone as PPhone, cg.grade as CGrade ,cg.program_id as cProgram from child c inner join child_Grade cg on cg.chil_id_fk = c.child_id inner join parent p on c.parent_id_fk = p.parent_id")
    List<ChildParentGrade> FindAllChildGrade();

}