package com.example.daycaree.Bill;

import ChildDto.ParentChild;
import com.example.daycaree.Child.Child;
import com.example.daycaree.Parent.ParentBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query(nativeQuery = true, value = "Select * from Bill ")
    List<Bill> FindAllBill();

    @Query(nativeQuery = true, value = "Select b.bill_id as billId, b.amount as Amount, b.comment as comment,b.program as program , b.child_id_fk as childfk,c.firstname as firstname,p.firstname as Pfirstname,p.phone as phone from bill b inner join child c on b.child_id_fk = c.child_id  inner join parent p on c.parent_id_fk = p.parent_id")
    List<ParentBill> FindParentBill();

    @Query(nativeQuery = true, value = "Select b.bill_id as billId, b.amount as Amount, b.comment as comment,b.program as program , b.child_id_fk as childfk,c.firstname as firstname,p.firstname as Pfirstname,p.phone as phone from bill b inner join child c on b.child_id_fk = c.child_id  inner join parent p on c.parent_id_fk = p.parent_id where p.email = :username")
    List<ParentBill> FindParentChildBill(@Param("username")String username);


    @Query(nativeQuery = true, value = "Select  b.child_id_fk as childId,c.address as address,c.comment as comment,c.dob as dob, c.firstname as firstname, c.lastname as lastname,  b.program as program from bill b inner join child c on b.child_id_fk = c.child_id  inner join parent p on c.parent_id_fk = p.parent_id where p.email = :username")
    List<ParentChild> FindParentChild(@Param("username")String username);


}