package com.example.daycaree.Child;

import ChildDto.ParentChild;
import com.example.daycaree.Parent.Parent;
import com.example.daycaree.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepository extends JpaRepository<Child, Long> {

    @Query(nativeQuery = true, value = "Select Count(*) from Child where firstname = :firstname AND lastname = :lastname")
    Integer findByFirstnameAndLastname(@Param("firstname")String firstname, @Param("lastname")String lastname);

    @Query(nativeQuery = true, value = "Select * from Child ")
    List<Child> FindAllChild();

    @Query(nativeQuery = true, value = "Select * from Child where Child_id = :ChildId   ")
    Child findByChildId(@Param("ChildId")Long ChildId);



    @Query(nativeQuery = true,value="select c.Child_id as ChildId, c.Address as Address , c.comment as comment,c.dob as dob, c.firstname as firstname,c.lastname as lastname,c.program as program from child c inner join parent p on c.parent_id_fk = p.parent_id where c.parent_id_fk = 1")
    List<ParentChild> FindParentChild();
}